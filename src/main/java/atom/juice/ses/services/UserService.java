package atom.juice.ses.services;


import atom.juice.ses.controllers.UserControler;
import atom.juice.ses.data.dto.v1.UserDTO;
import atom.juice.ses.exceptions.ResourceNotFoundException;
import atom.juice.ses.mapper.ObjectMapperUtils;
import atom.juice.ses.models.UserModel;
import atom.juice.ses.repositories.AdressRepository;
import atom.juice.ses.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository repository;

    private final AdressRepository adressRepository;


    @Autowired
    public UserService(AdressRepository adressRepository, UserRepository repository) {
        this.adressRepository = adressRepository;
        this.repository = repository;
    }

    public UserDTO findById(Long id) {
        logger.info("Buscando um Cliente!");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No resources found for this ID"));

        var dto = ObjectMapperUtils.map(entity, UserDTO.class);

        dto.add(linkTo(methodOn(UserControler.class).findById(id)).withSelfRel());

        return dto;
    }

    public List<UserDTO> findAll() {

        logger.info("{} -> Buscando todos os Clientes!", UserService.class.getSimpleName());

        var dtoList = ObjectMapperUtils.mapAll(repository.findAll(), UserDTO.class);

        dtoList.forEach(dto -> dto.add(linkTo(methodOn(UserControler.class).findById(dto.getUserId())).withSelfRel()));

        return dtoList;
    }


    public UserDTO create(UserDTO dto) {
        logger.info("{} -> Criando um cliente!", UserService.class.getSimpleName());

        var entity = repository.save(ObjectMapperUtils.map(dto, UserModel.class));

        setAdresses(dto, entity);

        var responseDTO = ObjectMapperUtils.map(entity, UserDTO.class);

        responseDTO.add(linkTo(methodOn(UserControler.class).findById(responseDTO.getUserId())).withSelfRel());

        return responseDTO;
    }

    private void setAdresses(UserDTO dto, UserModel entity) {

    }


    public UserDTO update(UserDTO dto) {
        logger.info("{} -> Atualizando um cliente!", UserService.class.getSimpleName());


        var entity = repository.findById(dto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("No resources found for this ID"));

        var updatedEntity = ObjectMapperUtils.map(dto, UserModel.class);

        updateClienteValues(updatedEntity, entity);

        var responseDTO = ObjectMapperUtils.map(repository.save(updatedEntity), UserDTO.class);

        responseDTO.add(linkTo(methodOn(UserControler.class).findById(responseDTO.getUserId())).withSelfRel());

        return responseDTO;
    }

    public void delete(Long id) {
        logger.info("{} -> Deletando um cliente!", UserService.class.getSimpleName());

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No resources found for this ID"));

        repository.delete(entity);
    }

    public void disable(Long id) {
        logger.info("{} -> Desabilitando um cliente!", UserService.class.getSimpleName());

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No resources found for this ID"));

        entity.setActive(true);

        repository.save(entity);

    }

    private static void updateClienteValues(UserModel newValues, UserModel oldValues) {

    }


}
