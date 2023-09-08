package com.example.mavendemo01.mybatiscatalog.redis;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person,String > {
    List<com.example.mavendemo01.ShujuFanhui.Person> findByLastname(String lastname);
    Page<Person> findPersonByLastname(String lastname, Pageable page);
    List<Person> findByFirstnameAndLastname(String firstname,String lastname);
    List<Person> findByAddress_City(String city);
    List<Person> findByFamilyList_Username(String usernam);
}