package com.vlv.domain.card;

import org.springframework.stereotype.Component;

@Component
public class CardFactory {
    public Card createCard(String uid, String visibleNumber) {
        Card card = new Card();
        card.setUid(uid);
        card.setVisibleNumber(visibleNumber);
        return card;
    }
}
