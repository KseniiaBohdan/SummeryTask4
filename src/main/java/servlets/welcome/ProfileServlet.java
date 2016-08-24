package servlets.welcome;

import constant.PageConstant;
import data.dto.UserDto;
import data.entity.*;
import service.AccountService;
import service.CardService;
import service.implementation.AccountServiceImpl;
import service.implementation.CardServiceImpl;
import service.implementation.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        UserServiceImpl userService = new UserServiceImpl();
        CardService cardService = new CardServiceImpl();
        AccountService accountService = new AccountServiceImpl();


        try {
            User user = userService.getByEmail(email);
            if (validUser(user, password)) {
                session.setAttribute("user", user);
                resp.setContentType("text/html");
                if (user.getRole().equals(Role.USER)) {
                    UserDto userDto = new UserDto();
                    List<Card> cardList = cardService.getByUserId(user.getId());
                    List<Account> accountList = accountService.getByUserId(user.getId());
                    userDto.setUser(user);
                    userDto.setAccounts(accountList);
                    userDto.setCards(cardList);
                    req.setAttribute("userModel", userDto);
                    req.getRequestDispatcher(PageConstant.PROFILE).include(req, resp);
                }
                if (user.getRole().equals(Role.ADMIN)) {
                    req.getRequestDispatcher(PageConstant.ADMIN_PROFILE).include(req, resp);
                }
            } else {
                req.setAttribute("error", "wrong email or password");
                req.getRequestDispatcher("error.jsp").include(req, resp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean validUser(User user, String password) {
        return (user != null
                && user.getStatus() != Status.DELETED
                && user.getPassword().equals(password));
    }
}
