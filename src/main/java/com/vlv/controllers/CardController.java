package com.vlv.controllers;

import com.vlv.entity.Card;
import com.vlv.service.CardService;
import com.vlv.vo.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody @Valid CardRequest request) {
        Card card = cardService.createCard(request.getUid(), request.getVisibleNumber());
        return ResponseEntity.ok(card);
    }

    @PostMapping("/{cardId}/assign")
    public ResponseEntity<CardAssignmentResponse> assignCard(@PathVariable Long cardId, @RequestBody AssignRequest request) {
        Card card = cardService.assignToAccount(cardId, request.getAccountEmail());
        return ResponseEntity.ok(new CardAssignmentResponse(card));
    }

    @PostMapping("/{cardId}/status")
    public ResponseEntity<Card> updateCard(@PathVariable Long cardId, @RequestBody CardStatusRequest request) {
        Card card = cardService.updateStatus(cardId, request.getStatus());
        return ResponseEntity.ok(card);
    }
}
