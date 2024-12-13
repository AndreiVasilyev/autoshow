package by.clevertec.autoshow.service;


import by.clevertec.autoshow.entity.dto.CarBuyDto;
import by.clevertec.autoshow.entity.dto.ClientCreateDto;
import by.clevertec.autoshow.entity.dto.ClientDto;
import by.clevertec.autoshow.entity.dto.ClientUpdateDto;

import java.util.List;

public interface ClientServiceSpring {

    void saveClient(ClientCreateDto car);

    void buyCar(long id, CarBuyDto carBuyDto);

    List<ClientDto> findAllClients();

    ClientDto findClientById(long id);

    void deleteClientById(long id);

    ClientDto updateClient(long id, ClientUpdateDto clientUpdateDto);
}
