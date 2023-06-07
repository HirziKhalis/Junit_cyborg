/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import DAO.DAOProduct;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author User
 */
public class ProductTest {
    
    public ProductTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     /*
    mengetes method getAllRecord apakah berhasil menampilkan semua produk pada
    table. Untuk mengujinya, saya menggunakan variabel test yaitu expResult yang 
    berupa jumlah seluruh produk yang ada. Setelah itu, saya mengubah variabel
    result menjadi array. Selajutnya, bandingkan panjang array tersebut dengan 
    expresult. Jika hasilnya sama, maka test berhasil.
  */
  @Test
  public void testGetAllRecords() {
    System.out.println("Test Get All Record");
    Product instance = new Product();
    int expResult = 11;
    List<Product> result = instance.getAllRecords();
    assertEquals(expResult, result.toArray().length);
  }

  /*
    mengetes apakah method getById berhasil menampilkan data berdasarkan ID atau
    tidak. Langkah pertama, yaitu set id produk. Selanjutnya, membuat variabel
    test expResult dan bandingkan dengan hasil dari method getById. Jika 
    hasilnya sama, maka test berhasil.
  */
  @Test
  public void testGetById() {
    System.out.println("Test Get by ID");
      
    Product instance = new Product();
    instance.setId(1);
    
    String expResult = "dashboard";
    String result = instance.getById();

    assertEquals(expResult, result);
  }

   @Test
  public void testGetById_error() {
    System.out.println("Test Get by ID");
      
    Product instance = new Product();
    instance.setId(0);
    
    String expResult = "dashboard_error_search";
    String result = instance.getById();

    assertEquals(expResult, result);
  }
  /*
    mengetes method saveProduct yang berfungsi untuk menambahkan data produk
    di database dan method ini dipakai saat user mengklik tombol create. 
    Langkah pertama, set semua data produk yang ingin ditambahkan. Selanjutnya,
    membuat variabel test expResult dan bandingkan dengan hasil dari method
    saveProduct. Jika hasilnya sama, maka test berhasil.
  */
  @Test
  public void testSaveProduct() {
    System.out.println("Test Save Product");
    
    Product instance = new Product();
    instance.setName("Max");
    instance.setGenre("MAX REAGENT");
    instance.setDeveloper("Alihan");
    instance.setStock(20);
    
    String expResult = "dashboard";
    String result = instance.saveProduct();

    assertEquals(expResult, result);
  }

  /*
    mengetes method editProduct yang berfungsi untuk mengubah data produk
    di database dan method ini dipakai saat user mengklik tombol update. 
    Langkah pertama, set semua data produk yang ingin diubah. Selanjutnya,
    membuat variabel test expResult dan bandingkan dengan hasil dari method
    editProduct. Jika hasilnya sama, maka test berhasil.
  */
  @Test
  public void testEditProduct() {
    System.out.println("editProduct");
    
    Product instance = new Product();
    instance.setId(6);
    instance.setName("ColdWar");
    instance.setGenre("First-Person Shooter");
    instance.setDeveloper("Medy");
    instance.setStock(20);
    
    String expResult = "dashboard";
    String result = instance.editProduct();

    assertEquals(expResult, result);
  }
  
  @Test
  public void  testDeleteProduct() {
      Product instance = new Product();
      instance.setId(82);
      
      String expResult = "dashboard";
      String result = instance.deleteProduct();
      
      assertEquals(expResult, result);
      
  }
  
}
