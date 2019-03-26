package repository;
import entity.Employee;
import entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

//    @Query("SELECT e from Employee e where id=:id")
//    Employee findById(@Param("id") Integer id);

//    Employee findById(@Param("id") Integer id);

//    Integer countByName(@Param("name") String name);

//    List<Employee> findByNameIs(@Param("name") String name);

//    List<Employee> findByNameOrderByIdDesc(String name);


//    @Query("select e from Employee e where age=25")
//    Employee getEmployee();

    @Query("SELECT e from Employee e where id=:id")
    Employee findById(@Param("id") Integer id);

}
