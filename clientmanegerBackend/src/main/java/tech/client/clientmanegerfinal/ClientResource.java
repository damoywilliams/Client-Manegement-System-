package tech.client.clientmanegerfinal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.client.clientmanegerfinal.model.Client;
import tech.client.clientmanegerfinal.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientResource {
    private final ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>>getAllClient()  // return a http response inside the http respose is going to be a list of clients
    {

        //ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, we can use it to fully configure the HTTP response.

       List<Client> c = clientService.getAllClient();
      return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Client>getClient(@PathVariable("id")long id){ // return a http response inside the http respose is going to be a list of clients


        //ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, we can use it to fully configure the HTTP response.

        Client c = clientService.findClientByid(id);
        return new ResponseEntity<>(c, HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<Client>updateClientStatus(@RequestBody Client c){ // return a http response inside the http respose is going to be a list of clients


        //ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, we can use it to fully configure the HTTP response.

            Client updateclient=clientService.updateclient(c);
            return new ResponseEntity<>(updateclient,HttpStatus.OK);
    }

    @PostMapping("/insert")


    public  ResponseEntity<Client> addClient(@RequestBody Client client)
    {
        Client NewClient= client;
        clientService.AddEmployee(NewClient);
        return new ResponseEntity<>(NewClient,HttpStatus.CREATED);


    }

    @DeleteMapping("/delete/{id}")

    public ResponseEntity<?> deleteClient(@PathVariable("id")long id){

        clientService.DeleteClient(id);
        return  new ResponseEntity<>(HttpStatus.OK);

    }




}
