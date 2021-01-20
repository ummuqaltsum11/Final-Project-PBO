
package TokoBuku;

import TokoBuku.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataModelTokoBuku {
  public final Connection conn;
  
  public DataModelTokoBuku(String driver) throws SQLException{
    this.conn = DBConnection.getConnection(driver);
  }
  
  public void addTokoBuku(Cash customer) throws SQLException{
    String insertCustomer = "INSERT INTO customer (IDcustomer, nama, alamat)"
            + "VALUES (?,?,?)";
    String insertCash = "INSERT INTO cash (IDcustomer, tgl_pembayaran)"
            + "VALUES (?,?)";
    String insertBarang = "INSERT INTO barang (jenisBuku, hargaBuku, IDcustomer)"
            + "VALUES (?,?,?)";
    
    PreparedStatement statCustomer = conn.prepareStatement(insertCustomer);
    statCustomer.setInt(1, customer.getIDcustomer());
    statCustomer.setString(2, customer.getNama());
    statCustomer.setString(3, customer.getAlamat());
    statCustomer.execute();
    
    PreparedStatement statCash = conn.prepareStatement(insertCash);
    statCash.setInt(1, customer.getIDcustomer());
    statCash.setString(2, customer.getTgl_pembayaran());
    statCash.execute();
    
    PreparedStatement statBarang = conn.prepareStatement(insertBarang);
    statBarang.setString(1, customer.getNbarang().get(0).getJenisBuku());
    statBarang.setDouble(2, customer.getNbarang().get(0).getHargaBuku());
    statBarang.setInt(3, customer.getIDcustomer());
    statBarang.execute();
  }
  
  public void addTokoBuku(Credit customer) throws SQLException{
        String insertCustomer = "INSERT INTO customer (IDcustomer, nama, alamat)"
            + "VALUES (?,?,?)";
    String insertCredit = "INSERT INTO credit (IDcustomer, contact)"
            + "VALUES (?,?)";
    String insertBarang = "INSERT INTO barang (jenisBuku, hargaBuku, IDcustomer)"
            + "VALUES (?,?,?)";
    
    PreparedStatement statCustomer = conn.prepareStatement(insertCustomer);
    statCustomer.setInt(1, customer.getIDcustomer());
    statCustomer.setString(2, customer.getNama());
    statCustomer.setString(3, customer.getAlamat());
    statCustomer.execute();
    
    PreparedStatement statCredit = conn.prepareStatement(insertCredit);
    statCredit.setInt(1, customer.getIDcustomer());
    statCredit.setString(2, customer.getContact());
    statCredit.execute();
    
    PreparedStatement statBarang = conn.prepareStatement(insertBarang);
    statBarang.setString(1, customer.getNbarang().get(0).getJenisBuku());
    statBarang.setDouble(2, customer.getNbarang().get(0).getHargaBuku());
    statBarang.setInt(3, customer.getIDcustomer());
    statBarang.execute();
  }
  
  public ObservableList<Cash> getCashs(){
    ObservableList<Cash> data = FXCollections.observableArrayList();
    String sql = "SELECT `IDcustomer`, `nama`, `alamat`,"
            + "`tgl_pembayaran` FROM `customer` NATURAL JOIN `cash`"
            + "ORDER BY nama";
    try {
      ResultSet rs = conn.createStatement().executeQuery(sql);
      String sqlBarang = "SELECT jenisBuku, hargaBuku "
              + "FROM barang WHERE IDcustomer"+ rs.getInt(1);
      ResultSet rsBarang = conn.createStatement().executeQuery(sqlBarang);
      ArrayList<Barang> dataBarang = new ArrayList<>();
      while (rsBarang.next()){
        dataBarang.add(new Barang(rsBarang.getString(1),rsBarang.getDouble(2)));
      }
      data.add(new Cash(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), dataBarang));
    } catch (SQLException ex) {
      Logger.getLogger(DataModelTokoBuku.class.getName()).log(Level.SEVERE, null, ex);
    }
    return data;
  }
  
  public ObservableList<Credit> getCredits() {
    ObservableList<Credit> data = FXCollections.observableArrayList();
    String sql = "SELECT `IDcustomer`, `nama`, `alamat`,"
            + "`contact` FROM `customer` NATURAL JOIN `credit`"
            + "ORDER BY nama";
    try {
      ResultSet rs = conn.createStatement().executeQuery(sql);
      String sqlBarang = "SELECT jenisBuku, hargaBuku "
              + "FROM barang WHERE IDcustomer" + rs.getInt(1);
      ResultSet rsBarang = conn.createStatement().executeQuery(sqlBarang);
      ArrayList<Barang> dataBarang = new ArrayList<>();
      while (rsBarang.next()) {
        dataBarang.add(new Barang(rsBarang.getString(1), rsBarang.getDouble(2)));
      }
      data.add(new Credit(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), dataBarang));
    } catch (SQLException ex) {
      Logger.getLogger(DataModelTokoBuku.class.getName()).log(Level.SEVERE, null, ex);
    }
    return data;
  }
  
  public ObservableList<Barang> getnBarang(int IDcustomer){
    ObservableList<Barang> data = FXCollections.observableArrayList();
    String sql = "SELECT jenisBuku, hargaBuku "
              + "FROM barang WHERE IDcustomer" + IDcustomer;
    try {
      ResultSet rs = conn.createStatement().executeQuery(sql);
      while (rs.next()){
        data.add(new Barang(rs.getString(1), rs.getDouble(2)));
      }
    } catch (SQLException ex) {
      Logger.getLogger(DataModelTokoBuku.class.getName()).log(Level.SEVERE, null, ex);
    }
    return data;
  }
  
  public int nextIDcustomer() throws SQLException{
    String sql = "SELECT MAX(IDcustomer) FROM customer";
    ResultSet rs = conn.createStatement().executeQuery(sql);
    while (rs.next()){
      return rs.getInt(1)==0?100000:rs.getInt(1)+1;
    }
    return 100000;
  }

}
