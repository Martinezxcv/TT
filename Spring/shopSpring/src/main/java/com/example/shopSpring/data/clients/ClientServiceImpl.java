package com.example.shopSpring.data.clients;

import com.example.shopSpring.data.clients.mapper.ClientMapper;
import com.example.shopSpring.data.clients.model.Client;
import com.example.shopSpring.data.clients.model.ClientDto;
import com.example.shopSpring.data.clients.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientDto> getAllClients() {
        return clientMapper.toDtoList(clientRepository.findAll());
    }

    @Override
    public void addClient(ClientDto client) {
        clientRepository.save(clientMapper.fromDto(client));
    }
}
