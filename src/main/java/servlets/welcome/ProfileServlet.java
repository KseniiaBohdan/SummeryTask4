package servlets.welcome;

import servlets.PageConstant;
import data.dto.UserDto;
import data.entity.*;
import service.AccountService;
import service.CardService;
import service.impl.AccountServiceImpl;
import service.impl.CardServiceImpl;
import service.impl.UserServiceImpl;

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
        CardService cardService = new CardServiceImpl();
        AccountService accountService = new AccountServiceImpl();
        User user = (User)req.getSession().getAttribute("user");
        UserDto userDto = new UserDto();
        List<Card> cardList = cardService.getByUserId(user.getId());
        List<Account> accountList = accountService.getByUserId(user.getId());
        userDto.setUser(user);
        userDto.setAccounts(accountList);
        userDto.setCards(cardList);
        req.setAttribute("userModel", userDto);
        req.getRequestDispatcher(PageConstant.PROFILE).include(req, resp);
    }
}
