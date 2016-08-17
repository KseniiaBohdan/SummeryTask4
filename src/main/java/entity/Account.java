package entity;

public class Account extends Entity{
    private Long id;
    private Long balance;
    private Integer number;

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    private Integer statusId;
    private String title;
    private Long userId;

    public Account() {
    }

    public Account(Long id, Long balance, Integer number, Integer statusId, String title, Long userId) {
        this.id = id;
        this.balance = balance;
        this.number = number;
        this.statusId = statusId;
        this.title = title;
        this.userId = userId;
    }

    public Account(Long id, Long balance, Integer number, String title, Long userId) {
        this.id = id;
        this.balance = balance;
        this.number = number;
        this.title = title;
        this.userId = userId;
        this.statusId = 1; //create method
    }

    public Account(Long id, Long balance, String title) {
        this.id = id;
        this.balance = balance;
        this.title = title;
        this.statusId = 1; //create method
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

    public void setStatus(int status) {
        this.statusId = statusId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
