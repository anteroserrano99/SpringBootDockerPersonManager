package com.project.antero.personmanager.service;

import com.project.antero.personmanager.dao.PersonDao;
import com.project.antero.personmanager.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return  personDao.addPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();

    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.getPersonbyId(id);
    }

    public void updatePerson(Person person){
          personDao.updatePerson(person);
    }

    public void deletePerson(UUID id ){
        personDao.deletePerson(id);
    }



}
