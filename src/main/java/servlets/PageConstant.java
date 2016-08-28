package servlets;

public final class PageConstant {

    public static final String UNBLOCK_CARD_SERVLET = "/card/unblock";
    public static final String CONFIRM_PAYMENT_SERVLET = "/payment/confirm";
    public static final String PROFILE_SERVLET = "/profile";
    public static final String ADMIN_PROFILE_SERVLET = "/admin/profile";

    private PageConstant() {

    }

    public static final String LOGIN_SERVLET = "/login";
    public static final String PUT_MONEY_SERVLET = "/put";
    public static final String LOGIN = "/WEB-INF/pages/welcome/login.jsp";
    public static final String REGISTRATION = "/WEB-INF/pages/welcome/registration.jsp";
    public static final String PROFILE = "/WEB-INF/pages/welcome/profile.jsp";

    public static final String DO_PAYMENT = "/WEB-INF/pages/payment/doPayment.jsp";
    public static final String HISTORY = "/WEB-INF/pages/payment/history.jsp";

    public static final String ADD_CARD = "/WEB-INF/pages/card/add.jsp";
    public static final String BLOCK_CARD = "/WEB-INF/pages/card/block.jsp";
    public static final String DELETE_CARD = "/WEB-INF/pages/card/delete.jsp";
    public static final String UNBLOCK_CARD = "/WEB-INF/pages/card/unblock.jsp";

    public static final String ADD_ACCOUNT = "/WEB-INF/pages/account/add.jsp";
    public static final String BLOCK_ACCOUNT = "/WEB-INF/pages/account/block.jsp";
    public static final String DELETE_ACCOUNT = "/WEB-INF/pages/account/delete.jsp";

    public static final String ADMIN_PROFILE = "/WEB-INF/pages/admin/profile.jsp";
    public static final String PAYMENTS_HISTORY = "/WEB-INF/pages/admin/history.jsp";
    public static final String PAYMENTS_HISTORY_SERVLET = "/WEB-INF/pages/admin/history";
    public static final String USER_MANAGEMENT = "/WEB-INF/pages/admin/users.jsp";
    public static final String USER_MANAGEMENT_SERVLET = "/user/management";
    public static final String UNBLOCK_REQUESTS_CARD = "/WEB-INF/pages/admin/cardUnblockRequests.jsp";
    public static final String UNBLOCK_REQUESTS_CARD_SERVLET = "/admin/card/unblock-requests";
}
