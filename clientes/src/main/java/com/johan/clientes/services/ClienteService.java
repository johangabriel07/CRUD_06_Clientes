    package com.johan.clientes.services;

    import com.johan.clientes.models.ClienteModel;
    import com.johan.clientes.repositories.ClienteRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class ClienteService {

        @Autowired
        private ClienteRepository clienteRepository;

        public ClienteModel criarCliente(ClienteModel clienteModel){
            return clienteRepository.save(clienteModel);
        }

        public List<ClienteModel> findAll(){
            return clienteRepository.findAll();
        }

        public Optional<ClienteModel> buscarClientePorId(Long id){
            return clienteRepository.findById(id);
        }

        public void deletarCliente(Long id){
            clienteRepository.deleteById(id);
        }
    }