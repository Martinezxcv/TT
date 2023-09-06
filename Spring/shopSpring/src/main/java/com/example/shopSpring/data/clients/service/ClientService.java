package com.example.shopSpring.data.clients.service;

import com.example.shopSpring.data.clients.model.Client;
import com.example.shopSpring.data.clients.model.ClientDto;

import java.util.List;

public interface ClientService {

     List<ClientDto> getAllClients();
     void addClient(ClientDto client);
}
