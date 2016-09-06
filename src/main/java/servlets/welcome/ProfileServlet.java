package servlets.welcome;

import org.apache.log4j.Logger;
import servlets.EncodingFilter;
import servlets.PageConstant;
import data.dto.UserDto;
import data.entity.*;
import service.AccountService;
import service.CardService;
import service.impl.AccountServiceImpl;
import service.impl.CardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ProfileServlet extends HttpServlet {

    private static final String USER_MADEL = "userModel";
    private static final String USER = "user";
    private static final Logger LOGGER = Logger.getLogger(ProfileServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CardService cardService = new CardServiceImpl();
        AccountService accountService = new AccountServiceImpl();
        User user = (User)req.getSession().getAttribute(USER);
        UserDto userDto = new UserDto();
        List<Card> cardList = cardService.getByUserId(user.getId());
        cardService.removeCardsByStatus(cardList, Status.DELETED);
        checkExpiryDate(cardList);
        List<Account> accountList = accountService.getByUserId(user.getId());
        accountService.removeAccountByStatus(accountList, Status.DELETED);
        userDto.setUser(user);
        userDto.setAccounts(accountList);
        userDto.setCards(cardList);
        req.setAttribute(USER_MADEL, userDto);
        LOGGER.trace("Profile of " + user.getEmail() + " was open");
        req.getRequestDispatcher(PageConstant.PROFILE).include(req, resp);
    }

    private void checkExpiryDate(List<Card> cardList) {
        for (int i = 0; i < cardList.size(); i++) {
            Date currentDate = new Date();
            if(currentDate.after(cardList.get(i).getExpiryDate()) && cardList.get(i).getStatus().equals(Status.ACTIVE)){
                cardList.get(i).setStatus(Status.BLOCKED);
                new CardServiceImpl().update(cardList.get(i));
            }
        }
    }
}
