package TokoBuku;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Customer {
  private IntegerProperty IDcustomer;
  private StringProperty nama;
  private StringProperty alamat;
  private ArrayList<Barang> nbarang;

  public Customer(Integer IDcustomer, String nama,
                  String alamat, ArrayList<Barang> nbarang) {
    this.IDcustomer = new SimpleIntegerProperty(IDcustomer);
    this.nama = new SimpleStringProperty(nama);
    this.alamat = new SimpleStringProperty(alamat);
    this.nbarang = nbarang;
  }

  public Customer(Integer IDcustomer, String nama,
                  String alamat, Barang barang) {
    nbarang = new ArrayList<>();
    this.IDcustomer = new SimpleIntegerProperty(IDcustomer);
    this.nama = new SimpleStringProperty(nama);
    this.alamat = new SimpleStringProperty(alamat);
    this.nbarang.add(barang);
  }

  public Integer getIDcustomer() {
    return IDcustomer.get();
  }

  public void setIDcustomer(Integer IDcustomer) {
    this.IDcustomer.set(IDcustomer);
  }

  public String getNama() {
    return nama.get();
  }

  public void setNama(String nama) {
    this.nama.set(nama);
  }

  public String getAlamat() {
    return alamat.get();
  }

  public void setAlamat(String alamat) {
    this.alamat.set(alamat);
  }

  public ArrayList<Barang> getNbarang() {
    return nbarang;
  }

  public void setNbarang(ArrayList<Barang> nbarang) {
    this.nbarang = nbarang;
  }

  public IntegerProperty IDcustomerProperty(){
    return IDcustomer;
  }
  
  public StringProperty namaProperty(){
    return nama;
  }
  
  public StringProperty alamatProperty(){
    return alamat;
  }

}
