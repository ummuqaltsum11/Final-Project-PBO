package TokoBuku.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
  private static final String USERNAME = "root";
  private static final String PASSWORD = "";
  private static final String DB = "tokobuku";
  private static final String MYCONN = "jdbc:mysql://localhost/"+DB;
  private static final String SQCONN = "jdbc:sqlite:D:\\PROJECT UAS PBO\\SQLiteDB\\Tokobuku.sqlite";
  
  public static Connection getConnection(String driver) throws SQLException {
    Connection conn = null;
    switch (driver) {
      case "SQLITE": {
        try {
          Class.forName("org.sqlite.JDBC");
          conn = DriverManager.getConnection(SQCONN);
        } catch (ClassNotFoundException ex) {
          System.out.println("Library tidak ada");
          Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        break;
      }
      case "MYSQL": {
        try {
          Class.forName("com.mysql.jdbc.Driver");
          conn = DriverManager.getConnection(MYCONN, USERNAME, PASSWORD);
        } catch (ClassNotFoundException ex) {
          System.out.println("Library tidak ada");
          Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        break;
      }
    }
    
    return conn;
  }
  
  }
