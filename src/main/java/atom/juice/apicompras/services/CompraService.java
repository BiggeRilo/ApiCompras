package atom.juice.apicompras.services;

import java.util.logging.Logger;

import atom.juice.apicompras.exceptions.ResourceNotFoundException;
import atom.juice.apicompras.models.Compra;
import atom.juice.apicompras.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

	private Logger logger = Logger.getLogger(CompraService.class.getName());

	@Autowired
	CompraRepository repository;

	public Compra findById(Long id) {
		logger.info("Buscando uma Compra!");
		return repository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("No resources found for this ID"));

	}
}
