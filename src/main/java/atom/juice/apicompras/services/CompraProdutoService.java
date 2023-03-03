package atom.juice.apicompras.services;

import java.util.logging.Logger;

import atom.juice.apicompras.exceptions.ResourceNotFoundException;
import atom.juice.apicompras.models.CompraProduto;
import atom.juice.apicompras.repositories.CompraProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraProdutoService {

	private Logger logger = Logger.getLogger(CompraProdutoService.class.getName());

	@Autowired
	CompraProdutoRepository repository;

	public CompraProduto findById(Long id) {
		logger.info("Buscando produtos por compra!");

		return repository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("No resources found for this ID"));
	}

}
