package com.vlv.application;

import com.vlv.application.dto.CardAssignmentDTO;
import com.vlv.application.dto.CardDTO;
import com.vlv.application.dto.CardStatusDTO;
import com.vlv.domain.card.Card;
import com.vlv.domain.card.CardFactory;
import com.vlv.domain.card.CardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CardAppService {
    private final CardService cardService;
    private final CardFactory cardFactory;

    public CardAppService(CardService cardService, CardFactory cardFactory) {
        this.cardService = cardService;
        this.cardFactory = cardFactory;
    }

    public Card createCard(CardDTO cardDTO) {
        Card card = cardFactory.createCard(cardDTO.getUid(), cardDTO.getVisibleNumber());
        return cardService.createCard(card);
    }

    public Card assignCardToAccount(Long cardId, CardAssignmentDTO assignmentDTO) {
        return cardService.assignToAccount(cardId, assignmentDTO.getAccountEmail());
    }
    public Card updateStatus(Long cardId, CardStatusDTO cardStatusDTO) {

        return cardService.updateStatus( cardId,  cardStatusDTO.getStatus());
    }
}