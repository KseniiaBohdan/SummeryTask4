package entity;

import java.io.Serializable;

public class Account extends Entity implements Serializable{
    private Long id;
    private Long balance;
    private Integer number;
    private Integer statusId;
    private String title;
    private Long userId;

    public Account() {
    }

    public Account(Long id, Long balance, String title) {
        this.id = id;
        this.balance = balance;
        this.title = title;
        this.statusId = Status.valueOf("UNBLOCKED").ordinal()+1;
    }

    public Account(Long id, Long balance, Integer number, String title, Long userId) {
        this.id = id;
        this.balance = balance;
        this.number = number;
        this.title = title;
        this.userId = userId;
        this.statusId = Status.valueOf("UNBLOCKED").ordinal()+1;
    }

    public Account(Long id, Long balance, Integer number, Integer statusId, String title, Long userId) {
        this.id = id;
        this.balance = balance;
        this.number = number;
        this.statusId = statusId;
        this.title = title;
        this.userId = userId;
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer status) {
        this.statusId = statusId;
    }

    public void setStatusId(Status status) {
        this.statusId = status.ordinal()+1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
