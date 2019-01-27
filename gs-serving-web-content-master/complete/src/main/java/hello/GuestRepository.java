package hello;

import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Integer> {

}
