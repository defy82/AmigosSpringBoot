package com.example.amigosspringboot.dao;

import com.example.amigosspringboot.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    public List<Person> selectAllPeople();
}
