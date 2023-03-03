package atom.juice.apicompras.repositories;


import atom.juice.apicompras.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
