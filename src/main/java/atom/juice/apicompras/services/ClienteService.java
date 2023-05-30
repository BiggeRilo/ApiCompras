package atom.juice.apicompras.services;


import atom.juice.apicompras.controllers.ClienteController;
import atom.juice.apicompras.data.dto.v1.ClienteDTO;
import atom.juice.apicompras.exceptions.ResourceNotFoundException;
import atom.juice.apicompras.mapper.ObjectMapperUtils;
import atom.juice.apicompras.models.Cliente;
import atom.juice.apicompras.models.Endereco;
import atom.juice.apicompras.repositories.ClienteRepository;
import atom.juice.apicompras.repositories.EnderecoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ClienteService {

    private final Logger logger = LoggerFactory.getLogger(ClienteService.class);
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

        logger.info("{} -> Buscando todos os Clientes!", ClienteService.class.getSimpleName());

        var dtoList = ObjectMapperUtils.mapAll(repository.findAll(), ClienteDTO.class);

        dtoList.forEach(dto -> dto.add(linkTo(methodOn(ClienteController.class).findById(dto.getId())).withSelfRel()));

        return dtoList;
    }


    public ClienteDTO create(ClienteDTO dto) {
        logger.info("{} -> Criando um cliente!", ClienteService.class.getSimpleName());

        var entity = repository.save(ObjectMapperUtils.map(dto, Cliente.class));

        setAdresses(dto, entity);

        var responseDTO = ObjectMapperUtils.map(entity, ClienteDTO.class);

        responseDTO.add(linkTo(methodOn(ClienteController.class).findById(responseDTO.getId())).withSelfRel());

        return responseDTO;
    }

    private void setAdresses(ClienteDTO dto, Cliente entity) {
        if (dto.getEnderecos() != null && !dto.getEnderecos().isEmpty()) {
            List<Endereco> enderecos = ObjectMapperUtils.mapAll(dto.getEnderecos(), Endereco.class);
            enderecos.forEach(endereco -> endereco.setCliente(entity));
            entity.setEnderecos(adressRepository.saveAll(enderecos));
        }
    }


    public ClienteDTO update(ClienteDTO dto) {
        logger.info("{} -> Atualizando um cliente!", ClienteService.class.getSimpleName());


        var entity = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException("No resources found for this ID"));

        var updatedEntity = ObjectMapperUtils.map(dto, Cliente.class);

        updateClienteValues(updatedEntity, entity);

        var responseDTO = ObjectMapperUtils.map(repository.save(updatedEntity), ClienteDTO.class);

        responseDTO.add(linkTo(methodOn(ClienteController.class).findById(responseDTO.getId())).withSelfRel());

        return responseDTO;
    }

    public void delete(Long id) {
        logger.info("{} -> Deletando um cliente!", ClienteService.class.getSimpleName());

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No resources found for this ID"));

        repository.delete(entity);
    }

    public void disable(Long id) {
        logger.info("{} -> Desabilitando um cliente!", ClienteService.class.getSimpleName());

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No resources found for this ID"));

        entity.setAtivo(true);

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
