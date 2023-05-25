package atom.juice.apicompras.services;

import atom.juice.apicompras.data.dto.EnderecoDTO;
import atom.juice.apicompras.exceptions.ResourceNotFoundException;
import atom.juice.apicompras.mapper.ObjectMapperUtils;
import atom.juice.apicompras.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class EnderecoService {

    private final Logger logger = Logger.getLogger(EnderecoService.class.getName());

    private final EnderecoRepository repository;


    @Autowired
    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;

    }

    public EnderecoDTO findById(Long id) {
        logger.info("Buscando um Endereço!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No resources found for this ID"));

        return ObjectMapperUtils.map(entity, EnderecoDTO.class);

    }

}
