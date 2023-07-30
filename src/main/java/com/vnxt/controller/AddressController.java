package com.vnxt.controller;

import com.vnxt.model.Address;
import com.vnxt.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/address")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(value = "/", consumes = "application/json")
    public Address create(@RequestBody Address address) {
        return addressService.create(address);
    }

}
