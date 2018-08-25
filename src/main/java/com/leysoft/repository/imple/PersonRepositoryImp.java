
package com.leysoft.repository.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leysoft.model.Person;
import com.leysoft.repository.inter.PersonRepository;

@Repository
public class PersonRepositoryImp implements PersonRepository {

    private static final String FIND_ALL_QUERY = "select id, name, username from persons;";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public List<Person> findAll() {
        return jdbcTemplate.query(FIND_ALL_QUERY,
                (rs, rowNum) -> new Person(rs.getLong(1), rs.getString(2), rs.getString(3)));
    }
}
