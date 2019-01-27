package hello;

import org.springframework.data.repository.CrudRepository;
import hello.Users;

public interface UserRepository extends CrudRepository<Users, Integer> {

}
