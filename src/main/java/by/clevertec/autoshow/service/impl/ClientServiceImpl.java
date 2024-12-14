package by.clevertec.autoshow.service.impl;


import by.clevertec.autoshow.entity.Car;
import by.clevertec.autoshow.entity.Client;
import by.clevertec.autoshow.entity.dto.CarBuyDto;
import by.clevertec.autoshow.entity.dto.ClientCreateDto;
import by.clevertec.autoshow.entity.dto.ClientDto;
import by.clevertec.autoshow.entity.dto.ClientUpdateDto;
import by.clevertec.autoshow.mapper.ClientMapper;
import by.clevertec.autoshow.postprocessor.InjectParamsLogging;
import by.clevertec.autoshow.repository.CarRepository;
import by.clevertec.autoshow.repository.ClientRepository;
import by.clevertec.autoshow.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final ClientMapper clientMapper;

    @Transactional
    @Override
    public void saveClient(ClientCreateDto clientCreateDto) {
        clientRepository.save(clientMapper.toClient(clientCreateDto));
    }

    @Transactional
    @Override
    public void buyCar(long id, CarBuyDto carBuyDto) {
        Client client = clientRepository.findById(id).orElseThrow();
        Car car = carRepository.findById(Long.valueOf(carBuyDto.id())).orElseThrow();
        client.getCars().add(car);
        clientRepository.save(client);
    }

    @Override
    public List<ClientDto> findAllClients() {
        return clientMapper.toClientDtoList(clientRepository.findAll());
    }

    @InjectParamsLogging
    @Override
    public ClientDto findClientById(long id) {
        return clientMapper.toClientDto(clientRepository.findById(id).orElseThrow());
    }

    @Override
    public void deleteClientById(long id) {
        clientRepository.deleteById(id);
    }

    @Transactional
    @Override
    public ClientDto updateClient(long id, ClientUpdateDto clientUpdateDto) {
        Client client = clientMapper.toClient(clientUpdateDto);
        client.setId(id);
        return clientMapper.toClientDto(clientRepository.save(client));
    }
}
