package com.jedlab.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "credit_card")
@DiscriminatorValue("CC")
@SecondaryTable(name = "CREDIT_CARD", pkJoinColumns = @PrimaryKeyJoinColumn(name = "CREDIT_CARD_ID"))
public class CreditCard extends BillingDetails
{

    @Column(name = "CREDIT_CARD_ID", table="CREDIT_CARD" , insertable=false, updatable=false)
    private Long creditCardId;

    @Column(name = "c_number", table="CREDIT_CARD")
    private String number;

    public Long getCreditCardId()
    {
        return creditCardId;
    }

    public void setCreditCardId(Long creditCardId)
    {
        this.creditCardId = creditCardId;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

}
