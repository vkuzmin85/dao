package ru.netology.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.repository.CustomersRepository;

import java.util.List;

@RestController
@RequestMapping("/products")
public class CustomersController {
    private final CustomersRepository customersRepository;

    public CustomersController(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @GetMapping("/fetch-product")
    public ResponseEntity<List<String>> getProduct(@RequestParam String name) {
        List<String> names = customersRepository.getProductNames(name);
        return ResponseEntity.ok().body(names);
    }
}