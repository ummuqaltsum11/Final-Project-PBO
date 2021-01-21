
package TokoBuku;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;

public class Barang {
  private final StringProperty jenisBuku;
  private final DoubleProperty hargaBuku;

  public Barang(String jenisBuku, Double hargaBuku) {
    this.jenisBuku = new SimpleStringProperty(jenisBuku);
    this.hargaBuku = new SimpleDoubleProperty(hargaBuku);
  }
  
  public String getJenisBuku() {
    return jenisBuku.get();
  }
  
  public void setJenisBuku(String jenisBuku){
    this.jenisBuku.set(jenisBuku);
  }

  public Double getHargaBuku() {
    return hargaBuku.get();
  }
  
  public void setHargaBuku(double hargaBuku){
    this.hargaBuku.set(hargaBuku);
  }
  
  
  public StringProperty jenisBukuProperty(){
    return jenisBuku;
  }

  public DoubleProperty hargaBukuProperty(){
    return hargaBuku;
  }
  
}
