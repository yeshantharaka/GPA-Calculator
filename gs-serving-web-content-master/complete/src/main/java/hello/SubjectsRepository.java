package hello;

import hello.Subjects;
import org.springframework.data.repository.CrudRepository;

public interface SubjectsRepository extends CrudRepository<Subjects, Integer> {

}
