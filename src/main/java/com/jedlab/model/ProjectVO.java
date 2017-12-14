package com.jedlab.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.NotAudited;
import org.omidbiz.core.axon.internal.IgnoreElement;

@MappedSuperclass
public abstract class ProjectVO extends PO
{

    @Column(name = "proj_name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
//    @NotAudited
    List<Task> tasks = new ArrayList<Task>(0);

    @IgnoreElement
    public List<Task> getTasks()
    {
        return tasks;
    }

    public void setTasks(List<Task> tasks)
    {
        this.tasks = tasks;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
