package diplom.ex.dbcrud.controllers;

import diplom.ex.dbcrud.models.Client;
import diplom.ex.dbcrud.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class ClientController {
    private ClientRepository clientRepository;
    @Autowired
    public ClientController(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    @PostMapping(value = "/clients")
    public ResponseEntity<?> create(@RequestBody Client client){
        clientRepository.save(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> read(){
         final List<Client> clients= (List<Client>) clientRepository.findAll();
         return clients!=null && !clients.isEmpty()
                 ? new ResponseEntity<>(clients,HttpStatus.OK)
                 :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Client> read(@PathVariable(name="id") int id){
        final Client client=clientRepository.findById(id);
        return client!=null
                ? new ResponseEntity<>(client,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") int id,@RequestBody Client client){
        final Client updated=clientRepository.save(client);
        return updated!=null
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id")int id){
        final boolean deleted=clientRepository.deleteById(Long.valueOf(id));

    }
}
