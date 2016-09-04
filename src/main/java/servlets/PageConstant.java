package servlets;

public final class PageConstant {

    public static final String UNBLOCK_CARD_SERVLET = "/card/unblock";
    public static final String CONFIRM_PAYMENT_SERVLET = "/payment/confirm";
    public static final String PROFILE_SERVLET = "/user/profile";
    public static final String ADMIN_PROFILE_SERVLET = "/admin/profile";
    public static final String ADD_CARD_SERVLET = "/card/add";
    public static final String BLOCK_CARD_SERVLET = "/card/block";
    public static final String ADD_ACCOUNT_SERVLET = "/account/add";
    public static final String BLOCK_ACCOUNT_SERVLET = "/account/block";
    public static final String DELETE_CARD_SERVLET = "/card/delete";
    public static final String REGISTRATION_SERVLET = "/registration";

    private PageConstant() {

    }

    public static final String LOGIN_SERVLET = "/login";

    public static final String PUT_MONEY_SERVLET = "/put";
    public static final String CREATE_PAYMENT_SERVLET = "/payment/create";
    public static final String DELETE_ACCOUNT_SERVLET = "/account/delete";
    public static final String UNBLOCK_ACCOUNT_SERVLET = "/account/unblock";
    public static final String PROFILE_SETTINGS_SERVLET = "/user/profile/settings";

    public static final String PAYMENTS_HISTORY_SERVLET = "/admin/history";
    public static final String UNBLOCK_REQUESTS_CARD_SERVLET = "/admin/card/unblock";
    public static final String UNBLOCK_REQUESTS_ACCOUNT_SERVLET = "/admin/account/unblock";
    public static final String USER_MANAGEMENT_SERVLET = "/admin/user/management";

    public static final String LOGIN = "/WEB-INF/pages/welcome/login.jsp";
    public static final String REGISTRATION = "/WEB-INF/pages/welcome/registration.jsp";

    public static final String PROFILE = "/WEB-INF/pages/user/profile.jsp";
    public static final String CREATE_PAYMENT = "/WEB-INF/pages/user/payment/createPayment.jsp";
    public static final String HISTORY = "/WEB-INF/pages/user/payment/history.jsp";
    public static final String ADD_CARD = "/WEB-INF/pages/user/card/add.jsp";
    public static final String BLOCK_CARD = "/WEB-INF/pages/user/card/block.jsp";
    public static final String DELETE_CARD = "/WEB-INF/pages/user/card/delete.jsp";
    public static final String UNBLOCK_CARD = "/WEB-INF/pages/user/card/unblock.jsp";
    public static final String ADD_ACCOUNT = "/WEB-INF/pages/user/account/add.jsp";
    public static final String BLOCK_ACCOUNT = "/WEB-INF/pages/user/account/block.jsp";
    public static final String DELETE_ACCOUNT = "/WEB-INF/pages/user/account/delete.jsp";
    public static final String UNBLOCK_ACCOUNT = "/WEB-INF/pages/user/account/unblock.jsp";
    public static final String PROFILE_SETTINGS = "/WEB-INF/pages/user/profileSettings.jsp";

    public static final String ADMIN_PROFILE = "/WEB-INF/pages/admin/profile.jsp";
    public static final String PAYMENTS_HISTORY = "/WEB-INF/pages/admin/history.jsp";
    public static final String USER_MANAGEMENT = "/WEB-INF/pages/admin/users.jsp";
    public static final String UNBLOCK_REQUESTS_CARD = "/WEB-INF/pages/admin/cardUnblockRequests.jsp";
    public static final String UNBLOCK_REQUESTS_ACCOUNT = "/WEB-INF/pages/admin/accountUnblockRequests.jsp";

}
