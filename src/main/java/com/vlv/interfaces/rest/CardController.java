package com.vlv.interfaces.rest;

import com.vlv.application.CardAppService;
import com.vlv.application.dto.CardAssignmentDTO;
import com.vlv.application.dto.CardAssignmentResponseDTO;
import com.vlv.application.dto.CardDTO;
import com.vlv.application.dto.CardStatusDTO;
import com.vlv.domain.card.Card;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardAppService cardAppService;

    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody @Valid CardDTO cardDTO) {
        Card card =cardAppService.createCard(cardDTO);
        return ResponseEntity.ok(card);
    }

    @PostMapping("/{cardId}/assign")
    public ResponseEntity<CardAssignmentResponseDTO> assignCard(@PathVariable Long cardId, @RequestBody CardAssignmentDTO assignmentDTO) {
        Card card = cardAppService.assignCardToAccount(cardId, assignmentDTO);
        return ResponseEntity.ok(new CardAssignmentResponseDTO(card));
    }

    @PostMapping("/{cardId}/status")
    public ResponseEntity<Card> updateCard(@PathVariable Long cardId, @RequestBody CardStatusDTO cardStatusDTO) {
        Card card = cardAppService.updateStatus(cardId, cardStatusDTO);
        return ResponseEntity.ok(card);
    }
}
