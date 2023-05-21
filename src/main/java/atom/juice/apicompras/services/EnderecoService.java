package atom.juice.apicompras.services;

import java.util.logging.Logger;

import atom.juice.apicompras.exceptions.ResourceNotFoundException;
import atom.juice.apicompras.models.Endereco;
import atom.juice.apicompras.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final Logger logger = Logger.getLogger(EnderecoService.class.getName());

    EnderecoRepository repository;

    @Autowired
    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public Endereco findById(Long id) {
        logger.info("Buscando um Endereço!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No resources found for this ID"));

    }

}
