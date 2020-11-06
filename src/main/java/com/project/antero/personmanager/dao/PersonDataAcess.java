package com.project.antero.personmanager.dao;

import com.project.antero.personmanager.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("postgres")
public class PersonDataAcess implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAcess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {

        //TODO
        return 0;
    }

    @Override
    public int addPerson(Person person) {
        String query = "INSERT INTO person (id , name) VALUES (uuid_generate_v4(), '"+person.getName()+"')";
        jdbcTemplate.execute(query);
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        String query = "SELECT id, name FROM person";
        List<Person> people = jdbcTemplate.query(query, (rs, rowNum) -> {
            return new Person(UUID.fromString(rs.getString("id")), rs.getString("name"));
        });
        return people;
    }

    @Override
    public int updatePerson(Person person) {
        String query = "UPDATE person SET name = '"+ person.getName()+ "' WHERE person.id = '"+person.getId().toString()+"'";
        jdbcTemplate.execute(query);

        return 0;
    }

    @Override
    public int deletePerson(UUID id) {
        String query = "DELETE FROM person WHERE person.id = '"+id.toString()+"'";
        jdbcTemplate.execute(query);
        return 0;
    }

    @Override
    public Optional<Person> getPersonbyId(UUID id) {
        String queery = "SELECT id, name FROM person WHERE person.id = '"+id.toString()+"'";
        Person person = jdbcTemplate.queryForObject(queery,(rs, rowNum) -> {
            UUID personId = UUID.fromString(rs.getString("id"));
            String name = rs.getString("name");
            return new Person(personId, name);

        });




        return Optional.ofNullable(person);
    }
}
