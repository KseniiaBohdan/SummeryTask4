package constant;

public final class DbFieldConstant {

    private DbFieldConstant() {

    }

    //user
    public static final String USER_ID = "id";
    public static final String USER_FIRST_NAME = "first_name";
    public static final String USER_SECOND_NAME = "second_name";
    public static final String USER_PATRONYMIC = "patronymic";
    public static final String USER_EMAIL = "email";
    public static final String USER_PASSWORD = "password";
    public static final String USER_STATUS_ID = "status_id";
    public static final String USER_ROLE_ID = "role_id";
    public static final String USER_PHONE_NUMBER = "phone_number";

    //card
    public static final String CARD_NUMBER = "card_number";
    public static final String CARD_USER_ID = "user_id";
    public static final String CARD_EXPIRY_DATE = "expiry_date";
    public static final String CARD_PIN = "pin";
    public static final String CARD_STATUS_ID = "status_id";
    public static final String CARD_TITLE = "title";
    public static final String CARD_ACCOUNT_ID = "account";

    //account
    public static final String ACCOUNT_ID = "id";
    public static final String ACCOUNT_BALANCE = "balance";
    public static final String ACCOUNT_NUMBER = "number";
    public static final String ACCOUNT_STATUS_ID = "status_id";
    public static final String ACCOUNT_TITLE = "title";
    public static final String ACCOUNT_USER_ID = "user_id";

    //payment
    public static final String PAYMENT_ID = "id";
    public static final String PAYMENT_DATE = "date";
    public static final String PAYMENT_NUMBER = "number";
    public static final String PAYMENT_CARD_NUMBER_RECEIVER = "card_number_receiver";
    public static final String PAYMENT_CARD_NUMBER_SENDER = "card_number_sender";
    public static final String PAYMENT_TITLE = "title";
    public static final String PAYMENT_SUM = "sum";
    public static final String PAYMENT_PAY_STATUS_ID = "payment_status_id";

    //payment status
    public static final String PAYMENT_STATUS_ID = "id";
    public static final String PAYMENT_STATUS_NAME = "payment_status";

    //role
    public static final String ROLE_ID = "id";
    public static final String ROLE_NAME = "role_name";

    //status
    public static final String STATUS_ID = "id";
    public static final String STATUS_NAME = "status";
}
