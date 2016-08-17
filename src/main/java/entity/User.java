package entity;

public class User extends Entity {
    private Long id;
    private String firstName;
    private String secondName;
    private String patronymic;
    private String email;
    private String password;
    private Integer statusId;
    private Integer roleId;
    private String phoneNumber;

    public User(Long id, String firstName, String secondName, String patronymic,
                String email, String password, Integer statusId, Integer roleId,
                String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.email = email;
        this.password = password;
        this.statusId = statusId;
        this.roleId = roleId;
        this.phoneNumber = phoneNumber;
    }

    public User(String firstName, String secondName, String patronymic,
                String email, String password, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.email = email;
        this.password = password;
        this.statusId = 1; //status id create method
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return statusId;
    }

    public void setStatus(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
