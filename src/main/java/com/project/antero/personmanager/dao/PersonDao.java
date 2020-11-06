package com.project.antero.personmanager.dao;

import com.project.antero.personmanager.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);
    default int addPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
    List<Person> selectAllPeople();

    int updatePerson(Person person);

    int deletePerson(UUID id);

    Optional<Person> getPersonbyId(UUID id);

}
