package tech.client.clientmanegerfinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.client.clientmanegerfinal.model.Client;
import tech.client.clientmanegerfinal.repo.ClientRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }


    public Client AddEmployee(Client client){
        clientRepo.save(client);
       return client;
    }

    public List<Client> getAllClient(){

        return clientRepo.findAll();
    }


    public void  DeleteClient(Long id){

        clientRepo.deleteById(id);
    }
    @Transactional
    public Client updateclient(Client c){
        return clientRepo.save(c);

    }


    public Client findClientByid(long id){
        Client c = clientRepo.findById(id).orElseThrow(() -> new IllegalStateException("This student does not exist"));

        if(c!=null){
        return c;} else{ return null;}
    }
}
