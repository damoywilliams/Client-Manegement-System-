package tech.client.clientmanegerfinal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.client.clientmanegerfinal.model.Client;

public interface ClientRepo extends JpaRepository<Client,Long> {
}
