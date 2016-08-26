package service.comand.impl;

import data.entity.Card;
import data.entity.Status;
import service.CardRequestService;
import service.CardService;
import service.comand.Command;
import service.impl.CardRequestServiceImpl;
import service.impl.CardServiceImpl;

import javax.naming.Context;
import java.util.Map;

public class UnblockCardCommand implements Command {

    public Object execute(Context context, Map<String, Object> params) {
        Long cardNumber = Long.valueOf(params.get("cardNumber").toString());
        CardService cardService = new CardServiceImpl();
        Card card = cardService.getByCardNumber(cardNumber);
        card.setStatus(Status.ACTIVE);
        cardService.update(card);
        CardRequestService cardRequestService = new CardRequestServiceImpl();
        cardRequestService.DeleteByCarddNumber(cardNumber);
        return card;
    }
}
