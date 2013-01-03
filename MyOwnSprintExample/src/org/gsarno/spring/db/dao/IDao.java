package org.gsarno.spring.db.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public interface IDao {

  void setJdbcTemplate(JdbcTemplate ds);

  void create();
  void drop();
  void insert(String firstName, String lastName);

  List<Person> select(String firstname, String lastname);

  List<Person> selectAll();

  void deleteAll();

  void delete(String firstName, String lastName);

} 