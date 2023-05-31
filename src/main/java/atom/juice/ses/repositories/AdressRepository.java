package atom.juice.ses.repositories;

import atom.juice.ses.models.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<AddressModel, Long> {
}
