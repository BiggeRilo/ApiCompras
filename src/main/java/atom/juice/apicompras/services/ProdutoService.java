package atom.juice.apicompras.services;

import java.util.logging.Logger;

import atom.juice.apicompras.exceptions.ResourceNotFoundException;
import atom.juice.apicompras.models.Produto;
import atom.juice.apicompras.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	private Logger logger = Logger.getLogger(ProdutoService.class.getName());

	@Autowired
	ProdutoRepository repository;

	public Produto findById(Long id) {
		logger.info("Buscando um Produto!");
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No resources found for this ID"));

	}

}
