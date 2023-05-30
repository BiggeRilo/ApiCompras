package atom.juice.apicompras.services;


import atom.juice.apicompras.controllers.ClienteController;
import atom.juice.apicompras.data.dto.ClienteDTO;
import atom.juice.apicompras.exceptions.ResourceNotFoundException;
import atom.juice.apicompras.mapper.ObjectMapperUtils;
import atom.juice.apicompras.models.Cliente;
import atom.juice.apicompras.models.Endereco;
import atom.juice.apicompras.repositories.ClienteRepository;
import atom.juice.apicompras.repositories.EnderecoRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final Logger logger = LoggerFactory.getLogger(ClienteService.class.getName());
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

        var dto = ObjectMapperUtils.map(entity, ClienteDTO.class);

        dto.add(linkTo(methodOn(ClienteController.class).findById(id)).withSelfRel());

        return dto;
    }

    public List<ClienteDTO> findAll() {

        logger.info("Buscando todos os Clientes!");

        var dtos = ObjectMapperUtils.mapAll(repository.findAll(), ClienteDTO.class);

        dtos.forEach(c -> c.add(linkTo(methodOn(ClienteController.class).findById(c.getId())).withSelfRel()));

        return dtos;
    }


    public ClienteDTO create(ClienteDTO dto) {
        logger.info("Criando um cliente");

        var entity = repository.save(ObjectMapperUtils.map(dto, Cliente.class));

        if (dto.getEnderecos() != null && !dto.getEnderecos().isEmpty()) {
            List<Endereco> enderecos = ObjectMapperUtils.mapAll(dto.getEnderecos(), Endereco.class);
            enderecos.forEach(endereco -> endereco.setCliente(entity));
            entity.setEnderecos(adressRepository.saveAll(enderecos));
        }


        var responseDTO = ObjectMapperUtils.map(entity, ClienteDTO.class);

        responseDTO.add(linkTo(methodOn(ClienteController.class).findById(responseDTO.getId())).withSelfRel());

        return responseDTO;
    }


    public ClienteDTO update(ClienteDTO dto) {
        logger.info("Atualizando o clinte");

        var entity = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException("No resources found for this ID"));

        var updatedEntity = ObjectMapperUtils.map(dto, Cliente.class);

        updateClienteValues(updatedEntity, entity);

        var responseDTO = ObjectMapperUtils.map(repository.save(updatedEntity), ClienteDTO.class);

        responseDTO.add(linkTo(methodOn(ClienteController.class).findById(responseDTO.getId())).withSelfRel());

        return responseDTO;
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
