package com.project.antero.personmanager.dao;

import com.project.antero.personmanager.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component("fakeDao")
public class FakePersonDataAcessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        System.out.println(DB);
        return 1;
    }

    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public int updatePerson(Person person) {
        getPersonbyId(person.getId())
                .map(person1 -> {
                    int indexOfPerson = DB.indexOf(person1);
                    if (indexOfPerson >= 0) {
                        DB.set(indexOfPerson, person);
                        return 1;
                    } else return 0;

                });
        return 0;
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> personMaybe = getPersonbyId(id);
        if (personMaybe.get().getId() != null) DB.remove(personMaybe.get());
        return 0;
    }

    @Override
    public Optional<Person> getPersonbyId(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }


    @Override
    public int addPerson(Person person) {
        UUID id = UUID.randomUUID();
        DB.add(new Person(id, person.getName()));
        System.out.println(DB);
        return 0;
    }
}
