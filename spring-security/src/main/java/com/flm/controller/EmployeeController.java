package com.flm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    @GetMapping("/sayHello")
    //@PreAuthorize("hasRole('USER')")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<String> sayHello() {
    	log.info("Getting all Employees....");
    	return ResponseEntity.ok("Hello world");
    }
   

}
