package com.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/")
@Slf4j
public class TestController {

    @GetMapping("/dateTest")
    public ResponseEntity<String> testMethod(@RequestParam("fromDate") @DateTimeFormat LocalDate fromDate,
                                             @RequestParam("toDate") @DateTimeFormat LocalDate toDate) {

        if (fromDate.isAfter(toDate)) {
            log.warn("from date:{} cannot be greater than to date:{}", fromDate, toDate);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "fromDate must be before or equal to toDate.");
        }
        return ResponseEntity.ok("Dates are valid.");
    }
}
