
package TokoBuku;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Credit extends Customer{
  StringProperty contact;

  public Credit(Integer IDcustomer, String nama, String alamat,
          String contact, ArrayList<Barang> nbarang) {
    super(IDcustomer, nama, alamat, nbarang);
    this.contact = new SimpleStringProperty(contact);
  }

  public Credit(Integer IDcustomer, String nama, String alamat,
          String contact, Barang barang) {
    super(IDcustomer, nama, alamat, barang);
    this.contact = new SimpleStringProperty(contact);
  }

  public String getContact() {
    return contact.get();
  }

  public void setContact(String contact) {
    this.contact.set(contact);
  }
  
  public StringProperty getContactProperty() {
    return contact;
  }
  
}
