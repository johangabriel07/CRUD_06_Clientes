package com.johan.clientes.controller;

import com.johan.clientes.models.ClienteModel;
import com.johan.clientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;



    @PostMapping
    public ResponseEntity<ClienteModel> criarCliente(@RequestBody ClienteModel clienteModel){

        ClienteModel request = clienteService.criarCliente(clienteModel);

        URI uri = URI.create("/clientes/" + request.getId());
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> findAll(){
        List<ClienteModel> request = clienteService.findAll();
        return ResponseEntity.ok().body(request);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public void buscarClientePorId(@PathVariable Long id){
        clienteService.buscarClientePorId(id);
    }




}