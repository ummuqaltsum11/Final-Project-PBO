# Sistem Penjualan Toko Buku "SHEENA"

## Sistem ini menyediakan pelayanan untuk melakukan kegiatan transaksi jual-beli pada toko buku

### Class Diagram

```mermaid
classDiagram
    Customer <|-- Cash
    Customer <|-- Credit
    Customer "1"--o"*" Barang : has
    
    class Customer{
      <<abstract>>
      #int IDcustomer
      #String nama
      #String alamat
      +int nextIDcustomer()
    }
    
    class Cash{
      -Date tgl_pembayaran
    }
    class Credit{
      -String contact
    }
    class Barang{
      -String jenisBuku
      -double hargaBuku
      +String getJenisBuku()
      +double getHargaBuku()
    }
            
```

### ER Diagram

```mermaid
erDiagram
          CUSTOMER ||..|| CASH : is
          CUSTOMER ||..|| CREDIT : is
          CUSTOMER ||--|{ BARANG: "has"
          CUSTOMER {
            int IDcustomer
            string nama
            string alamat
          }
          CASH{
            string tgl_pembayaran
          }
          CREDIT{
            string contact
          }
          BARANG{
            string jenisBuku
            double hargaBuku
          }
```
### Design Class Diagram for JavaFX and Database
```mermaid
classDiagram
    Customer <|-- IndividualHolder
    Customer <|-- CorporateHolder
    Customer "1"--o"*" Account : has
    Customer o-- DataModelTokoBuku : Data Modeling
    DataModelTokoBuku <-- FormCustomerController : Data Control
    DataModelTokoBuku --> DBConnection : DB Connection
    DataModelTokoBuku <.. FormCustomer : Form Control      

    class Customer{
      <<abstract>>
      #IntegerProperty IDcustomer
      #StringProperty nama
      #StringProperty alamat
      
      +IntegerProperty nextID()
    }
    
    class Cash{
      -StringProperty tgl_pembayaran
    }
    class Credit{
      -StringProperty contact
    }
    class Barang{
      -StringProperty jenisBuku
      -DoubleProperty hargaBuku
      +String getJenisBuku()
      +double getHargaBuku()
    }

    class DataModelTokoBuku{
        Connection conn
        addCustomer()
        addBarang()
        getCash()
        getCredit()
        nextIDcustomer()
    }

    class FormCustomerController{
        initialize()
        handleButtonAddBarang()
        handleButtonAddCustomer()
        loadDataCash()
        loadDataCredit()
        loadDataBarang()
        handleClearForm()
    }
    class DBConnection{
        - String USERNAME
        - String PASSWORD
        - String DB
        getConnection()
        getConnection(String driver)
        createTable();
    }
            
```
