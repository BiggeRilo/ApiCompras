package atom.juice.apicompras.services;

import atom.juice.apicompras.exceptions.ResourceNotFoundException;
import atom.juice.apicompras.models.ItemCompra;
import atom.juice.apicompras.repositories.CompraProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CompraProdutoService {

	private final Logger logger = Logger.getLogger(CompraProdutoService.class.getName());

	CompraProdutoRepository repository;
	@Autowired
	public CompraProdutoService(CompraProdutoRepository repository){
		this.repository = repository;
	}

	public ItemCompra findById(Long id) {
		logger.info("Buscando produtos por compra!");

		return repository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("No resources found for this ID"));
	}

}
