
package TokoBuku;

import TokoBuku.db.DBConnection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  
  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("FormCustomer.fxml"));
    
    Scene scene = new Scene(root);
    
    stage.setScene(scene);
    stage.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
//    try {
//      DataModelTokoBuku dmtb = new DataModelTokoBuku("SQLITE");
//      Barang brg = new Barang("Komik",27000.);
//      Cash cs = new Cash(7, "Mikasa", "Pringsewu", "2020-12-10", brg);
//      dmtb.addTokoBuku(cs);
//      System.out.println("Sukses ditambahkan");
////    launch(args);
//    } catch (SQLException ex) {
//      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//      System.out.println("Gagal ditambahkan");
//    }
//  }
}

//    try {
//      
//      if (null != DBConnection.getConnection("ORACLE")){
//      System.out.println("Koneksi Sukses");
//      } else {
//        System.out.println("Koneksi Gagal");
//      }
////    launch(args);
//    } catch (SQLException ex) {
//      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//    }
//  }
//  
//}