package com.jedlab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Entity
@RevisionEntity(value = RevPoListener.class)
@Table(name = "revinfo")
public class RevisionEntityPO extends DefaultRevisionEntity implements RevisionPO
{

    private String username;
    private String ipAddress;
    private String userAgent;

    @Column(name = "user_name")
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Column(name = "ip_address")
    public String getIpAddress()
    {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }

    @Column(name = "user_agent")
    public String getUserAgent()
    {
        return userAgent;
    }

    public void setUserAgent(String userAgent)
    {
        this.userAgent = userAgent;
    }

}
