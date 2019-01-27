package hello;

import org.springframework.data.repository.CrudRepository;
import hello.Students;

public interface StudentsRepository extends CrudRepository<Students, Integer> {

}
