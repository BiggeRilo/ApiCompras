package atom.juice.apicompras.services;

import atom.juice.apicompras.exceptions.ResourceNotFoundException;
import atom.juice.apicompras.models.Compra;
import atom.juice.apicompras.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CompraService {

	private final Logger logger = Logger.getLogger(CompraService.class.getName());


	CompraRepository repository;
	@Autowired
	public CompraService(CompraRepository repository){
		this.repository = repository;
	}

	public Compra findById(Long id) {
		logger.info("Buscando uma Compra!");
		return repository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("No resources found for this ID"));

	}
}
