package com.jedlab.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.omidbiz.core.axon.internal.IgnoreElement;

@Entity
@Table(name = "project_view")
@AttributeOverrides({    
    @AttributeOverride(column=@Column(name= "proj_id"), name="id")
})
public class ProjectView extends ProjectVO
{

    @Column(name = "progress")
    private Long progress;

    public Long getProgress()
    {
        return progress;
    }

    public void setProgress(Long progress)
    {
        this.progress = progress;
    }

}
