package org.omidbiz.hibernate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "projwbs")
@Entity
public class Wbs implements Serializable
{

    
    Long id;

    private String wbsName;

    @Column(name = "wbs_name")
    public String getWbsName()
    {
        return wbsName;
    }

    public void setWbsName(String wbsName)
    {
        this.wbsName = wbsName;
    }

    @Id
    @Column(name = "wbs_id")
    @GeneratedValue
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

}
