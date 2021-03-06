package com.jedlab.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;
import org.omidbiz.core.axon.internal.IgnoreElement;

@Entity
@Table(name = "projects")
@Audited
@AuditOverride(forClass=ProjectVO.class)
public class Project extends ProjectVO
{

    @Transient
    @IgnoreElement
    public String getShortName()
    {
        if (getName() != null && getName().trim().length() > 0)
        {
            if (getName().length() > 20) return getName().substring(0, 20);
        }
        return getName();
    }

}
