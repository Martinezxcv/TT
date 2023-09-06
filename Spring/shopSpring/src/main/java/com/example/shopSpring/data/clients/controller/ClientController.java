package com.example.shopSpring.data.clients.controller;

import com.example.shopSpring.data.clients.model.Client;
import com.example.shopSpring.data.clients.model.ClientDto;
import com.example.shopSpring.data.clients.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "client")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public @ResponseBody Iterable<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    public String addClient(@RequestBody ClientDto client) {
        clientService.addClient(client);
        return "Added";
    }
}
