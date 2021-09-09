package commerce.dgr.repository;


import commerce.dgr.entities.personas.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}