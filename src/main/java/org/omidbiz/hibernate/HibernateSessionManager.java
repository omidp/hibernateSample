package org.omidbiz.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.jedlab.model.Project;
import com.jedlab.model.Task;

public class HibernateSessionManager
{

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try
        {
            AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration().configure();
            //before 4
//            AuditEventListener[] auditEventListener = new AuditEventListener[] { new AuditEventListener() };
//            annotationConfiguration.getEventListeners().setPostInsertEventListeners(auditEventListener);
//            annotationConfiguration.getEventListeners().setPostUpdateEventListeners(auditEventListener);
//            annotationConfiguration.getEventListeners().setPostDeleteEventListeners(auditEventListener);
//            annotationConfiguration.getEventListeners().setPreCollectionUpdateEventListeners(auditEventListener);
//            annotationConfiguration.getEventListeners().setPreCollectionRemoveEventListeners(auditEventListener);
//            annotationConfiguration.getEventListeners().setPostCollectionRecreateEventListeners(auditEventListener);
            annotationConfiguration.addAnnotatedClass(Project.class).addAnnotatedClass(Task.class);
            return annotationConfiguration.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static void shutdown()
    {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}