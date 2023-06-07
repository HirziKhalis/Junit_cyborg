/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Product;
import pojo.CyborgUtil;

/**
 *
 * @author Hirzi Monica
 */
public class DAOProduct {
    // Untuk menampilkan data ke tabel
    public List<Product> retrveTblproduct() {
        List listProduct = new ArrayList();
        Transaction transaction = null;
        Session session = CyborgUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Product");
            listProduct = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listProduct;
    }
    
     // untuk mencari/seach data, manipulasi data seperti delete, edit, dan search
    public List<Product> getbyID(String idProduct) {
        Product product = new Product();
        List<Product> listProduct = new ArrayList();
        Transaction transaction = null;
        Session session = CyborgUtil.getSessionFactory().openSession();
        
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Product where id = :id");
            query.setString("id", idProduct);
            product = (Product) query.uniqueResult();
            listProduct = query.list();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listProduct;
    }
    
    // untuk add data
    public void addProduct(Product product){
        Transaction transaction = null;
        Session session = CyborgUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // untuk delete berdcasarkan id
    public void deleteUser(Integer idProduct) {
        Transaction transaction = null;
        Session session = CyborgUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Product usr = (Product) session.load(Product.class, new Integer(idProduct));
            session.delete(usr);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    // untuk edit
    public void editUser(Product product) {
        Transaction transaction = null;
        Session session = CyborgUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
