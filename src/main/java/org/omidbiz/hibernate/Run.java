package org.omidbiz.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditQuery;

import com.jedlab.model.Project;
import com.jedlab.model.Revision;
import com.jedlab.model.RevisionPO;

public class Run
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {

        Session session = HibernateSessionManager.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
//        Project p = new Project();
//        p.setName("projproj");
//        session.persist(p);
//      
        AuditReader auditReader = AuditReaderFactory.get(session);
        AuditQuery query = auditReader.createQuery().forRevisionsOfEntity(Project.class, false, true);
        List resultList = query.getResultList();
        final List<Object[]> queryResult = (List<Object[]>) resultList;
        final List<Revision<Project>> result = new ArrayList<Revision<Project>>(resultList.size());
        for (final Object[] array : queryResult)
        {
            Project instance = (Project) array[0];
            RevisionPO revpo = (RevisionPO) array[1];
            RevisionType rt = (RevisionType) array[2];
            result.add(new Revision<Project>(instance, revpo, rt));
        }
        for (Revision<Project> revision : result)
        {
            System.out.println(revision.getRevpo().getUsername());
            System.out.println(revision.getInstance().getName());
        }
        session.getTransaction().commit();
        session.close();
        //
        
       

    }

}
