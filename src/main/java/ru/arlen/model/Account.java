package ru.arlen.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author satovritti
 */
@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {
    private long id;
    private String accountDetails;

    // This default constructor is required if there are other constructors.
    public Account() {

    }

    public Account(long id, String accountDetails) {
        this.id = id;
        this.accountDetails = accountDetails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(String accountDetails) {
        this.accountDetails = accountDetails;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountDetails='" + accountDetails + '\'' +
                '}';
    }
}
