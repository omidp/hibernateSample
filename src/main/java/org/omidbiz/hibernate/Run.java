package org.omidbiz.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.jedlab.model.Project;
import com.jedlab.model.Task;

public class Run
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {

        boolean flag = true;

        Session session = HibernateSessionManager.getSessionFactory().openSession();
         Transaction tx = session.beginTransaction();
         Task t = new Task();
         Project p = new Project();
         p.setId(2L);
         t.setProject(p);
         t.setName("Task 1");
         Project p2 = new Project();
         p2.setName("json proj");
         t.setJson(p2);
         session.saveOrUpdate(t);
         session.getTransaction().commit();
         

    }

}
