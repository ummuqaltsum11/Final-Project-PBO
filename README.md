# Penjelasan Program Sistem Penjualan Toko Buku "SHEENA"

## Sistem ini menyediakan pelayanan untuk melakukan kegiatan transaksi jual-beli pada toko buku

### Class Diagram

Terdapat empat buah entitas pada diagram ini, yaitu Customer, Barang, Cash, dan Credit

1. Entitas Customer memiliki beberepa atribut:
    - "IDcustomer" yang bertipe data integer sebagai Primary Key
    - "nama" dengan tipe data string
    - "alamat" dengan tipe data string
    Juga memiliki method "nextIDcustomer" bertipe data integer

2. Entitas Barang memiliki beberepa atribut:
    - "jenisBuku" yang bertipe data string
    - "hargaBuku" dengan tipe data double
    Juga memiliki method "getJenisBuku" dan "getHargaBuku" dengan masing-masing tipe data menyesuaikan tipe variabelnya

3. Entitas Cash memiliki sebuah atribut yaitu "tgl_pembayaran" yang bertipe data date
4. Entitas Credit memiliki sebuah atribut yaitu "Contact" yang bertipe data string

Hubungan atau relasi antara entitas Customer dengan Barang adalah aggregation dengan ketentuan setiap satu Customer dapat memiliki banyak Barang.
Hubungan atau relasi antara entitas Cash dan Credit dengan Customer adalah inheritance.


### Entity Reationship Diagram

Terdapat empat buah entitas pada diagram ini, yaitu Customer, Barang, Cash, dan Credit

1. Entitas Customer memiliki beberepa atribut:
    - "IDcustomer" bertipe data integer
    - "nama" bertipe data string
    - "alamat" bertipe data string

2. Entitas Barang memiliki beberepa atribut:
    - "jenisBuku" bertipe data string
    - "hargaBuku" bertipe data double

3. Entitas Cash memiliki sebuah atribut yaitu "tgl_pembayaran" yang bertipe data date
4. Entitas Credit memiliki sebuah atribut yaitu "Contact" yang bertipe data string

Hubungan atau relasi antara entitas Customer dengan Barang adalah tepat satu ke banyak (one to many), artinya setiap seorang Customer dapat membeli (memiliki) satu atau lebih Barang yang dijual oleh toko.
Hubungan atau relasi antara entitas Cash dan Credit dengan Customer adalah satu ke satu (one to one), dimana relasi ini berupa pilihan bagi pengguna untuk memilih melakukan pembayaran menggunakan Cash/Credit atau tidak.
