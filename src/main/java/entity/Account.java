package entity;

public class Account extends Entity {
    private Long id;
    private Long userId;
    private Long balance;
    private Integer number;
    private BlockStatus status;
    private String title;

    public Account() {
    }

    public Account(Long id, Long userId, Long balance, Integer number, BlockStatus status, String title) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
        this.number = number;
        this.status = status;
        this.title = title;
    }

    public Account(Long id, Long balance, String title) {
        this.id = id;
        this.balance = balance;
        this.title = title;
        this.status = BlockStatus.unblocked;
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

    public BlockStatus getStatus() {
        return status;
    }

    public void setStatus(BlockStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
