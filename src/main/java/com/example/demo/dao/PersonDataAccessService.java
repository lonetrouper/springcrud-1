package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int deletePersonById(UUID id) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int insertPerson(UUID id, Person person) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<Person> selectAllPeople() {

    final String sql = "SELECT id, name FROM person";
    return jdbcTemplate.query(sql, (resultSet, i) -> {
      UUid id = UUID.fromString(resultset.getString("id"));
      String name = resultSet.getString("name");
      return new Person(id, name);
    });
  }

  @Override
  public Optional<Person> selectPersonById(UUID id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int updatePersonById(UUID id, Person person) {
    // TODO Auto-generated method stub
    return 0;
  }

}
