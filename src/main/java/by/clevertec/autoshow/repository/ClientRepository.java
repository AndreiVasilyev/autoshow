package by.clevertec.autoshow.repository;

import by.clevertec.autoshow.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
