package data.entity;

public class AccountRequest extends Entity{

    private Long id;
    private Long accountId;
    private String title;

    public AccountRequest() {
        title="";
    }

    public AccountRequest(Long accountId, String title) {
        this.accountId=accountId;
        this.title=title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
