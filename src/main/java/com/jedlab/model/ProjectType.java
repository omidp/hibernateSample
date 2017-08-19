package com.jedlab.model;


import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;
import org.omidbiz.core.axon.Axon;
import org.omidbiz.core.axon.AxonBuilder;

/**
 * @author Omid Pourhadi
 *
 */
public class ProjectType implements UserType
{
    
    private Axon AXON_INSTANCE = new AxonBuilder().create();

    protected static final int[] SQL_TYPES = { java.sql.Types.VARCHAR };

    public int[] sqlTypes()
    {
        return SQL_TYPES;
    }

    public Class returnedClass()
    {
        return Project.class;
    }

    public boolean equals(Object x, Object y) throws HibernateException
    {
        if (x == y)
        {
            return true;
        }
        else if (x == null || y == null)
        {
            return false;
        }
        else
        {
            return x.equals(y);
        }
    }

    public int hashCode(Object x) throws HibernateException
    {
        return x.hashCode();
    }

    public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException
    {
//        if (rs.wasNull())
//        {
//            return null;
//        }
        String rsArr = rs.getString(names[0]);
        if (rsArr == null)
            return null;        
        Project detailAttr = AXON_INSTANCE.toObject(rsArr, Project.class, null);
        return detailAttr;
    }

    public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException
    {
        if (value == null)
        {
            st.setNull(index, SQL_TYPES[0]);
        }
        else
        {
            Project castObject = (Project) value;
            
            String json = AXON_INSTANCE.toJson(castObject);
            st.setString(index, json);
        }
    }

    public Object deepCopy(Object value) throws HibernateException
    {
        return value;
    }

    public boolean isMutable()
    {
        return true;
    }

    public Serializable disassemble(Object value) throws HibernateException
    {
        return null;
    }

    public Object assemble(Serializable cached, Object owner) throws HibernateException
    {
        return null;
    }

    public Object replace(Object original, Object target, Object owner) throws HibernateException
    {
        return original;
    }

}
