package data.entity;

import java.io.Serializable;

public class Account extends Entity implements Serializable{
    private Long id;
    private Long balance;
    private Integer number;
    private Status status;
    private String title;
    private Long userId;

    public Account() {
        status = Status.ACTIVE;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setStatus(Integer statusId) {
        this.status = Status.getStatus(statusId);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
