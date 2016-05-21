package com.mzmudziak.firstrestapi.repository;

import com.mzmudziak.firstrestapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findById(long id);
    List<Person> findByFirstName(String firstName);
}
