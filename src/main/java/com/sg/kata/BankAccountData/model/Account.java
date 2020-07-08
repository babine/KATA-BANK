package com.sg.kata.BankAccountData.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    private Date creationDate;

    private Date closeDate;

    private Date lastUpdate;

    private String balance;

    @ManyToOne()
    private User owner;

    @OneToMany(mappedBy = "account")
    private List<Operation> operations = new ArrayList<>();

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public boolean equals(Object o) {

        // null check
        if (o == null) {
            return false;
        }

        // this instance check
        if (this == o) {
            return true;
        }

        // instanceof Check and actual value check
        if ((o instanceof Account)
                && ((Account) o).accountId == this.accountId
                && ((Account) o).balance.equals(this.balance)
                && ((Account) o).closeDate.equals(this.closeDate)
                && ((Account) o).creationDate.equals(this.creationDate)
                && ((Account) o).lastUpdate.equals(this.lastUpdate)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + this.accountId.hashCode();
        result = 31 * result + this.balance.hashCode();
        result = 31 * result + this.closeDate.hashCode();
        result = 31 * result + this.creationDate.hashCode();
        result = 31 * result + this.lastUpdate.hashCode();
        return result;
    }
}
