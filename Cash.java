package TokoBuku;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cash extends Customer {
  StringProperty tgl_pembayaran;

  public Cash(Integer IDcustomer, String nama, String alamat,
          String tgl_pembayaran, ArrayList<Barang> nbarang) {
    super(IDcustomer, nama, alamat, nbarang);
    this.tgl_pembayaran = new SimpleStringProperty(tgl_pembayaran);
  }

  public Cash(Integer IDcustomer, String nama, String alamat,
          String tgl_pembayaran, Barang barang) {
    super(IDcustomer, nama, alamat, barang);
    this.tgl_pembayaran = new SimpleStringProperty(tgl_pembayaran);
  }

  public String getTgl_pembayaran() {
    return tgl_pembayaran.get();
  }
  
  public void setTgl_pembayaran(String tgl_pembayaran) {
    this.tgl_pembayaran.set(tgl_pembayaran);
  }
  
  public StringProperty getTgl_pembayaranProperty() {
    return tgl_pembayaran;
  }
  
  
  
}
