package org.omidbiz.hibernate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;

import com.jedlab.model.Project;
import com.jedlab.model.ProjectView;
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
//        for (int i = 0; i < 100; i++)
//       {
//           Project p = new Project();
//           p.setName("Project" + i);
//           session.persist(p);
//       }
//        Task t = (Task) session.get(Task.class, 102L);
//        t.setName("ttt33");
//        session.saveOrUpdate(t);
//        Task t = new Task();
//        t.setStatus(TaskStatus.COMPLETED);
//        Project p = new Project();
//        p.setId(20000L);
//        t.setProject(p);
//        t.setName("Task status");
//        session.saveOrUpdate(t);
//        List<Task> tasks =  session.createSQLQuery("select * from tasks").addEntity(Task.class).list();
//        System.out.println(tasks.iterator().next().getName());
        List<ProjectView> list = session.createQuery("select pv from ProjectView pv").list();
        for (ProjectView projectView : list)
        {
            System.out.println(projectView.getProgress());
        }
        session.getTransaction().commit();
         session.close();

    }

}
