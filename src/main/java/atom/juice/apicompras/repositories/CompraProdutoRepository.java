package atom.juice.apicompras.repositories;


import atom.juice.apicompras.models.ItemCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraProdutoRepository extends JpaRepository<ItemCompra, Long> {

}
