package by.clevertec.autoshow.controller;

import by.clevertec.autoshow.entity.dto.CarBuyDto;
import by.clevertec.autoshow.entity.dto.ClientCreateDto;
import by.clevertec.autoshow.entity.dto.ClientDto;
import by.clevertec.autoshow.entity.dto.ClientUpdateDto;
import by.clevertec.autoshow.service.ClientServiceSpring;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
@Validated
public class ClientController {

    private final ClientServiceSpring clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveClient(@RequestBody @Valid ClientCreateDto client) {
        clientService.saveClient(client);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDto updateClient(@PathVariable("id") @Valid @NotBlank long id,
                                  @RequestBody @Valid ClientUpdateDto client) {
        return clientService.updateClient(id, client);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void byCar(@PathVariable("id") @Valid @NotBlank long id,
                           @RequestBody @Valid @NotBlank CarBuyDto carBuyDto) {
        clientService.buyCar(id, carBuyDto);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto getClientByID(@PathVariable("id") @Valid @NotBlank long id) {
        return clientService.findClientById(id);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDto> getClients() {
        return clientService.findAllClients();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable("id") @Valid @NotBlank long id) {
        clientService.deleteClientById(id);
    }
}
