package com.johan.clientes.controller;

import com.johan.clientes.models.ClienteModel;
import com.johan.clientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteModel criarCliente(@RequestBody ClienteModel clienteModel){
        return clienteService.criarCliente(clienteModel);
    }

    @GetMapping
    public List<ClienteModel> listarClientes(){
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ClienteModel> buscarClientePorId(@PathVariable Long id){
        return clienteService.buscarClientePorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
    }
}