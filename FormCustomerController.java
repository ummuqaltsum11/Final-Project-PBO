package TokoBuku;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FormCustomerController implements Initializable {
  
 @FXML
    private TextField tfIDcustomer;

    @FXML
    private TextField tfnama;

    @FXML
    private TextField tfalamat;

    @FXML
    private DatePicker dptgl_pembayaran;

    @FXML
    private TextField tfjenisBuku;

    @FXML
    private TextField tfhargaBuku;

    @FXML
    private Button btnsave;

    @FXML
    private Button btnreload;

    @FXML
    private Button btnclear;

    @FXML
    private TableView<Cash> tblCustomer;

    @FXML
    private TableColumn<Cash, Integer> colIDcustomer;

    @FXML
    private TableColumn<Cash, String> colNama;

    @FXML
    private TableColumn<Cash, String> colAlamat;

    @FXML
    private TableColumn<Cash, String> colTglBayar;

    @FXML
    private TableView<Barang> tblBarang;

    @FXML
    private TableColumn<Barang, String> colJenisBuku;

    @FXML
    private TableColumn<Barang, Double> colHargaBuku;

    @FXML
    private TextField tfnewIDcustomer;

    @FXML
    private TextField tfnewjenisBuku;

    @FXML
    private Button btnaddBarang;

    @FXML
    private TextField tfnewhargaBuku;

    @FXML
    private Label labeldbstatus;
    
    @FXML
    private Label labelsavestatus;
    private DataModelTokoBuku dmtb;

    @FXML
    void handleAddBarangButton(ActionEvent event) {
     try {
       Barang brg = new Barang(tfnewjenisBuku.getText(),
              Double.parseDouble(tfnewhargaBuku.getText()));
       dmtb.addBarang(Integer.parseInt(tfnewIDcustomer.getText()),brg);
       viewDataBarang(Integer.parseInt(tfnewIDcustomer.getText()));
       btnreload.fire();
       btnclear.fire();
       tfnewhargaBuku.setText("");
     
   } catch (SQLException ex) {
     Logger.getLogger(FormCustomerController.class.getName()).log(Level.SEVERE, null, ex);
   }
}
    
    @FXML
    void handleAddCustomerButton(ActionEvent event) {
      LocalDate id = dptgl_pembayaran.getValue();
      String tgl_pembayaran = String.format("%d-%02d-%02d", id.getYear(), id.getMonthValue(), id.getDayOfMonth());
      Cash cs = new Cash(Integer.parseInt(tfIDcustomer.getText()), tfnama.getText(), tfalamat.getText(),
            tgl_pembayaran, new Barang(tfjenisBuku.getText(), Double.parseDouble(tfhargaBuku.getText())));
    try {
      dmtb.addTokoBuku(cs);
      labelsavestatus.setText("Penyimpanan Data Sukses");
      btnclear.fire();
      btnreload.fire();
    } catch (SQLException ex) {
      labelsavestatus.setText("Penyimpanan Data Gagal");
      Logger.getLogger(FormCustomerController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

    @FXML
    void handleClearFormButton(ActionEvent event) {
    try {
      tfIDcustomer.setText("" + dmtb.nextIDcustomer());
      tfnama.setText("");
      tfalamat.setText("");
      tfjenisBuku.setText("");
      tfhargaBuku.setText("");
    } catch (SQLException ex) {
      Logger.getLogger(FormCustomerController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

    @FXML
    void handleReloadButton(ActionEvent event) {
      ObservableList<Cash> data = dmtb.getCashs();
      colIDcustomer.setCellValueFactory(new PropertyValueFactory<>("IDcustomer"));
      colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
      colAlamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
      colTglBayar.setCellValueFactory(new PropertyValueFactory<>("tgl_pembayaran"));
      tblCustomer.setItems(null);
      tblCustomer.setItems(data);
    }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
   try {
     dmtb = new DataModelTokoBuku("MYSQL");
     labeldbstatus.setText(dmtb.conn==null?"Not Connected":"Connected");
     btnclear.fire();
     btnreload.fire();
   } catch (SQLException ex) {
     Logger.getLogger(FormCustomerController.class.getName()).log(Level.SEVERE, null, ex);
   }
   
   tblCustomer.getSelectionModel().selectedIndexProperty().addListener(listener->{
     if (tblCustomer.getSelectionModel().getSelectedItem()!=null){
       Cash cs = tblCustomer.getSelectionModel().getSelectedItem();
       viewDataBarang(cs.getIDcustomer());
       btnaddBarang.setDisable(false);
       tfnewIDcustomer.setText(""+cs.getIDcustomer());
       }
   });
    
  }
  
  public void viewDataBarang(int IDcustomer){
    ObservableList<Barang> data = dmtb.getnBarang(IDcustomer);
    colJenisBuku.setCellValueFactory(new PropertyValueFactory<>("jenisBuku"));
    colHargaBuku.setCellValueFactory(new PropertyValueFactory<>("hargaBuku"));
    tblBarang.setItems(null);
    tblBarang.setItems(data);
  }

}
