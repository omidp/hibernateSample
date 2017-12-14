package com.jedlab.model;

import org.hibernate.envers.RevisionListener;

public class RevPoListener implements RevisionListener
{

    public void newRevision(Object revisionEntity)
    {
        RevisionPO rev = (RevisionPO) revisionEntity;
        rev.setUsername("jedlab");
        rev.setIpAddress("127.0.0.1");
    }

	
}
