/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import junit.framework.AssertionFailedError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Product;
import org.hibernate.exception.ConstraintViolationException;
import pojo.CyborgUtil;

/**
 *
 * @author Hirzi Monica
 */
public class ProductDAOTest {
  
//  private Transaction transaction;
//  private static SessionFactory sessionFactory;
//  private Session session;
  
  public ProductDAOTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
    System.out.println("***** Start Testing *****");
  }
  
  @AfterClass
  public static void tearDownClass() {
    System.out.println("***** End Testing *****");
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
    System.out.println("\n");
  }

  /*
    mengetest apakah method berhasil menampilan semua produk pada table/list 
    atau tidak. Langkah pertama, ubah result menjadi array. Setelah itu, 
    mencari panjang array tersebut. Jika panjang array tidak kosong, maka test
    berhasil.
  */
  @Test
  public void testRetrveTblproduct() {
    System.out.println("Test List Product");
    DAOProduct instance = new DAOProduct();
    List<Product> result = instance.retrveTblproduct();
    System.out.println("Total Product: " + result.toArray().length);
    assertFalse(result.isEmpty());
  }
  
  /*
    mengetes apakah method getByID berhasil menampilkan data berdasarkan ID atau
    tidak. Langkah pertama, membuat variabel test untuk id yang nantinya akan
    digunakan sebagai argument pada method getByID. Setelah itu, cek apakah 
    hasil returnya kosong atau tidak, jika tidak kosong maka test gagal.
  */
  @Test
  public void testGetbyID() {
      System.out.println("Test Search by ID");
        Product instance = new Product ();
        instance.setId(1);
        
        String expResult = "dashboard";
        String result = instance.getById();
        
        assertEquals(expResult, result);
  }
  
  /*
    mengetes method addProduct yang berfungsi untuk menambahkan data produk
    di database. Langkah pertama, set semua data yang diperlukan. Selanjutnya,
    mengecek apakah produk null atau tidak. Jika tidak null maka test berhasil.
  */
  @Test
  public void testAddProduct() {
    System.out.println("Test Create Product");
    
    Product product = new Product();
    product.setName("UE");
    product.setGenre("Adventure");
    product.setDeveloper("Medy");
    product.setStock(20);
    
    DAOProduct instance = new DAOProduct();
    instance.addProduct(product);
    
    assertNotNull(product);
  }

  /*
    mengetes method delete yang berfungsi untuk menghapus data produk berdasarkan
    id produk. Langkah pertama, membuat variabel test berupa id untuk dimasukkan
    ke dalam argument sebagai parameter. Setelah menjalankan method delete, 
    selanjutnya memanggil objek Product dan mengecek id product. Jika id produk 
    null maka produk berhasil dihapus dan test berhasil.
  */
  @Test
  public void testDeleteUser() {
    System.out.println("Test Delete Product");
    
    Integer idProduct = 23;
    DAOProduct instance = new DAOProduct(); 
    Transaction transaction = null;
    Session session = CyborgUtil.getSessionFactory().openSession();
    
    transaction = session.beginTransaction();
    instance.deleteUser(idProduct);
    transaction.commit();
    
    Product deletedProduct = (Product) session.get(Product.class, idProduct);
    assertNull(deletedProduct);
  }

  /*
    Mengetes method update yang berfungsi untuk mengubah data produk yang sudah 
    ada pada database. Langkah pertama, yaitu dengan set semua data yang 
    diperlukan. Langkah kedua, jalankan methodnya. Selanjutnya, memanggil objek
    Product dan mengecek id product. Terakhir, membuat variabel ekspetasi result 
    apakah sesuai dengan variabel result. Disini, kita membandingkan nama produk 
    yang telah diubah. Jika hasilnya sama, maka test berhasil. 
  */
  @Test
  public void testEditUser() {
    System.out.println("Test Update Product");
    
    DAOProduct instance = new DAOProduct();
    Transaction transaction = null;
    Session session = CyborgUtil.getSessionFactory().openSession();
    
    Integer id = 4;
    Product product = new Product();
    product.setId(id);
    product.setName("Assassin");
    product.setGenre("Role-Playing");
    product.setDeveloper("Ubisoft");
    product.setStock(20);
    
    transaction = session.beginTransaction();
    instance.editUser(product);
    transaction.commit();
    
    Product updatedProduct = (Product) session.get(Product.class, id);
    
    String expResult = "Assassin";
    String result = updatedProduct.getName();
    
    assertEquals(expResult, result);
  }
  
}
