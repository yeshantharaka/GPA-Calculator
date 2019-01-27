package hello;

import hello.Departments;

import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Departments, Integer> {
	
}
