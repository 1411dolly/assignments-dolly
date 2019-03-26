package repository;

import entity.Person;
import entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//Q2....Implement CrudRepository for it.

public interface PersonRepository extends CrudRepository<Person,Integer> {
    List<Person> findByFirstname(String firstname);
    List<Person> findByLastname(String lastname);
    Person findById(Integer id);

    @Query("select firstname from Person where age=25")
    String findByAge25();

    @Query("select firstname,lastname from Person where age=25")
    String findBynameAge25();

    @Query("select firstname,lastname from Person where age=25")
    String getPerson();

    @Query("select count(firstname) from Person where firstname='Peter'")
    int countname();

    int countByFirstname(String name);

    List<Person> findDistinctByFirstname(String name);

    List<Person> findByFirstnameOrAge(String name, Integer age);

    List<Person> findByFirstnameAndAge(String name, Integer age);

    List<Person> findByAgeBetween(int min,int max);

    List<Person> findByAgeLessThan(int age);

    List<Person> findByAgeGreaterThan(int age);

    List<Person> findByFirstnameLike(String name);

    List<Person> findByFirstnameNot(String name);

    List<Person> findByAgeIn(List<Integer> ageList);

    List<Person> findByFirstnameIgnoreCase(String name);


    //Q11...Get the persons greater than age 25 and sort them in descending order according to id by method query.
    @Query("select p from Person p where age > 25 order by id desc")
    List<Person> findByAgeGreaterThanSortById();

    List<Person> findByAgeGreaterThan(Integer age, Sort sort);

    Page<Person> findAll(Pageable pageable);
}
