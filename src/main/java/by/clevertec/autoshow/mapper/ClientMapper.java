package by.clevertec.autoshow.mapper;

import by.clevertec.autoshow.entity.Client;
import by.clevertec.autoshow.entity.dto.ClientCreateDto;
import by.clevertec.autoshow.entity.dto.ClientDto;
import by.clevertec.autoshow.entity.dto.ClientUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(source = "registered", target = "registered", qualifiedByName = "stringToLocalDateTime")
    Client toClient(ClientDto clientDto);

    @Mapping(source = "registered", target = "registered", dateFormat = "dd.MM.yyyy")
    ClientDto toClientDto(Client client);

    @Mapping(source = "registered", target = "registered", dateFormat = "dd.MM.yyyy")
    ClientCreateDto toClientCreateDto(Client client);

    @Mapping(source = "registered", target = "registered", dateFormat = "dd.MM.yyyy")
    ClientUpdateDto clientUpdateDto(Client client);

    @Mapping(source = "registered", target = "registered", qualifiedByName = "stringToLocalDateTime")
    Client toClient(ClientCreateDto clientCreateDto);

    @Mapping(source = "registered", target = "registered", qualifiedByName = "stringToLocalDateTime")
    Client toClient(ClientUpdateDto clientUpdateDto);

    @Mapping(source = "registered", target = "registered", dateFormat = "dd.MM.yyyy")
    List<ClientDto> toClientDtoList(List<Client> clients);


    @Named("stringToLocalDateTime")
    default LocalDateTime mapStringToLocalDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, formatter).atStartOfDay();
    }

}
