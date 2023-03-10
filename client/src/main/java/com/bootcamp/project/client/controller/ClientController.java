package com.bootcamp.project.client.controller;

import com.bootcamp.project.client.entity.ClientEntity;
import com.bootcamp.project.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value="/Client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping(value = "/FindOne/{documentNumber}")
    public Mono<ClientEntity> Get_One(@PathVariable("documentNumber") String documentNumber){
        return clientService.getOne(documentNumber);
    }
    @GetMapping(value = "/FindAll")
    public Flux<ClientEntity> Get_All(){

        return clientService.getAll();
    }
    @PostMapping(value = "/Save")
    public Mono<ClientEntity> Save(@RequestBody ClientEntity col){

        return clientService.save(col);
    }
    @PutMapping(value = "/Update/{documentNumber}/{subType}")
    public Mono<ClientEntity> Update(@PathVariable("documentNumber") String documentNumber,@PathVariable("subType") String subType){
        return clientService.update(documentNumber, subType);
    }
    @DeleteMapping  (value = "/Delete/{documentNumber}")
    public Mono<Void> Delete(@PathVariable("documentNumber") String documentNumber){
        return clientService.delete(documentNumber);
    }

    @PostMapping(value = "/RegisterPerson")
    public Mono<ClientEntity> registerPerson(@RequestBody ClientEntity col){
        return clientService.registerPerson(col);
    }
    @PostMapping(value = "/RegisterBusiness")
    public Mono<ClientEntity> registerBusiness(@RequestBody ClientEntity col){
        return clientService.registerBusiness(col);
    }
    @GetMapping(value = "/FindByDocument/{documentNumber}")
    public Mono<ClientEntity> findClientByDocument(@PathVariable("documentNumber") String documentNumber){
        return clientService.findByDocument(documentNumber);
    }
    @GetMapping(value = "/CheckClient/{documentNumber}")
    public Mono<Boolean> checkClient(@PathVariable("documentNumber") String documentNumber){
        return clientService.checkClient(documentNumber);
    }
}
