package com.sg.kata.BankAccountData.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OPERATION")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer operationId;

    @Enumerated(EnumType.STRING)
    private OperationType type;

    private Date operationDate;

    private Date applicationDate;

    private User user;

    private String amount;

    @ManyToOne
    private Account account;

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
        if ((o instanceof Operation)
                && ((Operation) o).getOperationId() == this.getOperationId()
                && ((Operation) o).getAccount().equals(this.getAccount())
                && ((Operation) o).getType().equals(this.getType())
                && ((Operation) o).getAmount().equals(this.getAmount())
                && ((Operation) o).getUser().equals(this.getUser())
                && ((Operation) o).getOperationDate().equals(this.getOperationDate())
                ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + this.getOperationDate().hashCode();
        result = 31 * result + this.getUser().hashCode();
        result = 31 * result + this.getAmount().hashCode();
        result = 31 * result + this.getType().hashCode();
        result = 31 * result + this.getAccount().hashCode();
        return result;
    }
}
