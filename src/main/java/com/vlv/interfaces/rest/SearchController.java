package com.vlv.interfaces.rest;

import com.vlv.application.SearchAppService;
import com.vlv.application.dto.AccountWithCardsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {
    private final SearchAppService searchAppService;

    @GetMapping
    public ResponseEntity<Page<AccountWithCardsDTO>> searchByLastUpdated(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime lastUpdated,
            @PageableDefault(size = 20) Pageable pageable
    ) {
        return ResponseEntity.ok(
                searchAppService.searchByLastUpdated(lastUpdated, pageable)
        );
    }

}
