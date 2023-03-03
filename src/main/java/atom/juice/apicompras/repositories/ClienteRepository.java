package atom.juice.apicompras.repositories;


import atom.juice.apicompras.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
