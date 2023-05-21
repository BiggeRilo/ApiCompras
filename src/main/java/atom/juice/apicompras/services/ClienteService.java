package atom.juice.apicompras.services;


import atom.juice.apicompras.exceptions.ResourceNotFoundException;
import atom.juice.apicompras.models.Cliente;
import atom.juice.apicompras.models.Endereco;
import atom.juice.apicompras.repositories.ClienteRepository;
import atom.juice.apicompras.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ClienteService {

    private final Logger logger = Logger.getLogger(ClienteService.class.getName());

    ClienteRepository repository;

    EnderecoRepository adressRepository;

    @Autowired
    public ClienteService(EnderecoRepository adressRepository, ClienteRepository repository) {
        this.adressRepository = adressRepository;
        this.repository = repository;
    }

    public Cliente findById(Long id) {
        logger.info("Buscando um Cliente!");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No resources found for this ID"));

    }

    public List<Cliente> findAll() {

        logger.info("Buscando todos os Clientes!");
        return repository.findAll();
    }


    public Cliente create(Cliente cliente) {
        logger.info("Criando um cliente");


        var entity = repository.save(cliente);

        if (cliente.getEnderecos() != null && !cliente.getEnderecos().isEmpty()) {
            List<Endereco> enderecos = cliente.getEnderecos();
            enderecos.forEach(endereco -> endereco.setCliente(entity));
            adressRepository.saveAll(enderecos);
        }

        return entity;

    }


    public Cliente update(Cliente cliente) {
        logger.info("Atualizando o clinte");

        var entity = repository.findById(cliente.getId()).orElseThrow(() -> new ResourceNotFoundException("No resources found for this ID"));

        updateValues(cliente, entity);

        return repository.save(entity);

    }

    public void delete(Long id) {
        logger.info("Deletando um cliente");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No resources found for this ID"));

        repository.delete(entity);
    }

    public void disable(Long id) {
        logger.info("Disabilitanod um cliente");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No resources found for this ID"));

        entity.setStatusDb(true);

        repository.save(entity);

    }

    private static void updateValues(Cliente newValues, Cliente oldValues) {
        oldValues.setNome(newValues.getNome());
        oldValues.setSobreNome(newValues.getSobreNome());
        oldValues.setDataNascimento(newValues.getDataNascimento());
        oldValues.setRg(newValues.getRg());
        oldValues.setCnpj(newValues.getCnpj());
        oldValues.setCpf(newValues.getCpf());
    }


}
