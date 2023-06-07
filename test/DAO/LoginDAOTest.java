/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Employees;


/**
 *
 * @author 
 */

public class LoginDAOTest {
  
  public LoginDAOTest() {
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
    
  }

@Test
  public void testGetBy() {
    System.out.println("Test Login");
    String uEmail = "lia1122@gmail.com";
    String uPass = "135";   
    int empty = 0;
    DAOLogin instance = new DAOLogin();
    List<Employees> result = instance.getBy(uEmail, uPass);
    System.out.println(result.toArray().length);
    assertThat(result.toArray().length, is(not(equalTo(empty))));
  }
  
 @Test
  public void testAdd_user() {
    System.out.println("Test Register");
    
    Employees user = new Employees();
    user.setEmail("monik@gmail.com");
    user.setName("Monika");
    user.setPassword("309");
    
    DAOLogin instance = new DAOLogin();
    String expResult = "index";
    String result = instance.add_user(user);
    System.out.println(expResult);
    System.out.println(result);
    assertEquals(expResult, result);
  }
}
