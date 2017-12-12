package org.omidbiz.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jedlab.model.Project;
import com.jedlab.model.Task;
import com.jedlab.model.Task.TaskStatus;

public class Run
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {

        Session session = HibernateSessionManager.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Project p = new Project();
        p.setName("projproj");
        session.persist(p);
//      
        session.getTransaction().commit();
        session.close();

    }

}
