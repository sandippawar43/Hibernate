/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernateexample2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import Model.*;
import java.util.*;

/**
 *
 * @author Sandip
 */
public class HibernateExample2 {

    Configuration cfg;
    SessionFactory factory;
    Session ses;
    Transaction tr;
    
    public HibernateExample2()
    {
        cfg = new Configuration().configure("hibernate.cfg.xml");
        factory = cfg.buildSessionFactory();
    }
    
    public void Add()
    {
        ses = factory.openSession();
        tr = ses.beginTransaction();
        Consumer c1 = new Consumer(3,"Sandip", "Pune","9999888");
        int id = (int)ses.save(c1);
        tr.commit();
        ses.close();
        if(id>0)
            System.out.println("Record inserted successfully");
        else
            System.out.println("Error!!");
    }
    
    public void Display()
    {
        ses = factory.openSession();
        List<Consumer> consumerList = ses.createQuery("from Consumer").list();
        for(Consumer c:consumerList)
        {
            System.out.println(c.getId()+ " "+c.getName()+" "+c.getAddress()+" "+c.getMobile());
        }
    }
    
    public static void main(String[] args) 
    {
        HibernateExample2 hb = new HibernateExample2();
       hb.Add();
       hb.Display();
    }
    
}
