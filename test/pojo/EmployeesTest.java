/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

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
public class EmployeesTest {
    
    public EmployeesTest() {
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
    mengetes method save user yang mana method ini dipakai saat user mengklik
    tombol register. Langkah pertama yaitu dengan set semua data yang dibutuhkan.
    Setelah itu, membuat ekspetasi result. Jika hasilnya sama dengan result maka
    test berhasil.
  */
    
  @Test
  public void testSave_user() {
    System.out.println("Test Save User");
    
    Employees instance = new Employees();
    instance.setEmail("Arik@gmail.com");
    instance.setName("Aji");
    instance.setPassword("321");
    
    String expResult = "index";
    String result = instance.save_user();
    System.out.println(expResult);
    System.out.println(result);
    assertEquals(expResult, result);
    
  }

  /*
    mengetes method login user yang mana method ini dipakai saat user mengklik
    tombol login. Langkah pertama yaitu dengan set semua data yang dibutuhkan.
    Setelah itu, membuat ekspetasi result. Jika hasilnya sama dengan result maka
    test berhasil.
  */
  @Test
  public void testLogin_user() {
    System.out.println("Test Login User");
   
    Employees instance = new Employees();
    instance.setEmail("hey1212@gmailcom");
    instance.setPassword("1212"); 
    
    String expResult = "Home";
    String result = instance.login_user();
    System.out.println(expResult);
    System.out.println(result);
    assertEquals(expResult, result);
  }
//  @Ignore
    
  @Test
  public void testLogin_usererror() {
    System.out.println("Test Login User");
   
    Employees instance = new Employees();
    instance.setEmail("lia1122gmail.com");
    instance.setPassword("135"); 
    
    String expResult = "login_error";
    String result = instance.login_user();
    System.out.println(expResult);
    System.out.println(result);
    assertEquals(expResult, result);
  }
}


