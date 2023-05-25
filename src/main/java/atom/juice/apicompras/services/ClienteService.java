package atom.juice.apicompras.services;


import atom.juice.apicompras.data.dto.ClienteDTO;
import atom.juice.apicompras.exceptions.ResourceNotFoundException;
import atom.juice.apicompras.mapper.ObjectMapperUtils;
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


    private final ClienteRepository repository;

    private final EnderecoRepository adressRepository;


    @Autowired
    public ClienteService(EnderecoRepository adressRepository, ClienteRepository repository) {
        this.adressRepository = adressRepository;
        this.repository = repository;
    }

    public ClienteDTO findById(Long id) {
        logger.info("Buscando um Cliente!");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No resources found for this ID"));

        return ObjectMapperUtils.map(entity, ClienteDTO.class);
    }

    public List<ClienteDTO> findAll() {

        logger.info("Buscando todos os Clientes!");
        return ObjectMapperUtils.mapAll(repository.findAll(), ClienteDTO.class);
    }


    public ClienteDTO create(ClienteDTO dto) {
        logger.info("Criando um cliente");

        var entity = repository.save(ObjectMapperUtils.map(dto, Cliente.class));

        if (dto.getEnderecos() != null && !dto.getEnderecos().isEmpty()) {
            List<Endereco> enderecos = ObjectMapperUtils.mapAll(dto.getEnderecos(), Endereco.class);
            enderecos.forEach(endereco -> endereco.setCliente(entity));
            entity.setEnderecos(adressRepository.saveAll(enderecos));
        }
        return ObjectMapperUtils.map(entity, ClienteDTO.class);
    }


    public ClienteDTO update(ClienteDTO dto) {
        logger.info("Atualizando o clinte");

        var entity = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException("No resources found for this ID"));

        var updatedEntity = ObjectMapperUtils.map(dto, Cliente.class);

        updateClienteValues(updatedEntity, entity);

        return ObjectMapperUtils.map(repository.save(updatedEntity), ClienteDTO.class);

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

    private static void updateClienteValues(Cliente newValues, Cliente oldValues) {
        oldValues.setNome(newValues.getNome());
        oldValues.setSobreNome(newValues.getSobreNome());
        oldValues.setDataNascimento(newValues.getDataNascimento());
        oldValues.setRg(newValues.getRg());
        oldValues.setCnpj(newValues.getCnpj());
        oldValues.setCpf(newValues.getCpf());
    }


}
