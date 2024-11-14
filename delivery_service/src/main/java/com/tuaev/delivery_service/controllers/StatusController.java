package com.tuaev.delivery_service.controllers;

import com.google.common.util.concurrent.RateLimiter;
import com.tuaev.delivery_service.document.Status;
import com.tuaev.delivery_service.dto.StatusDTO;
import com.tuaev.delivery_service.services.DefaultStatusService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/")
@AllArgsConstructor
public class StatusController {

    private DefaultStatusService defaultStatusService;
    private RateLimiter rateLimiter;

    @PostMapping("status")
    public ResponseEntity<StatusDTO> ask(@RequestBody Long orderId){
        return ResponseEntity.status(HttpStatus.CREATED).body(defaultStatusService.save(orderId));
    }

    @PostMapping("status/{orderId}")
    public ResponseEntity<Status> update(@PathVariable("orderId") Long orderId, @RequestParam String comments){
        rateLimiter.acquire(5);
        return ResponseEntity.status(HttpStatus.OK).body(defaultStatusService.update(orderId, comments));
    }
}
