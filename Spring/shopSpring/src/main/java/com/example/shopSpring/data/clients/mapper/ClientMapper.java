package com.example.shopSpring.data.clients.mapper;

import com.example.shopSpring.data.clients.model.Client;
import com.example.shopSpring.data.clients.model.ClientDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDto toDto(Client source);
    List<ClientDto> toDtoList(List<Client> source);
    Client fromDto(ClientDto destination);
}
