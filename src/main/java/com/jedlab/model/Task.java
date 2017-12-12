package com.jedlab.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Table(name = "tasks")
@Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
public class Task extends PO
{

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proj_id")
    private Project project;

    @Type(type = "com.jedlab.model.ProjectType")
    @Column(name = "proj")
    private Project json;

    @Column(name = "description")
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String description;

    @Column(name = "is_active")
    @Type(type = "yes_no")
    private Boolean active;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TaskStatus status;

    public enum TaskStatus {
        COMPLETED, IN_PROGRESS;
    }

    public TaskStatus getStatus()
    {
        return status;
    }

    public void setStatus(TaskStatus status)
    {
        this.status = status;
    }

    public Boolean getActive()
    {
        return active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Project getJson()
    {
        return json;
    }

    public void setJson(Project json)
    {
        this.json = json;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Project getProject()
    {
        return project;
    }

    public void setProject(Project project)
    {
        this.project = project;
    }

}
