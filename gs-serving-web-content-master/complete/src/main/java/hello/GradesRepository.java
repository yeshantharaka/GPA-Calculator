package hello;
import org.springframework.data.repository.CrudRepository;

import hello.grades;

public interface GradesRepository extends CrudRepository<grades, Integer>  {
	
}
