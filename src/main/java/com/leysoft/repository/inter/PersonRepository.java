
package com.leysoft.repository.inter;

import java.util.List;

import com.leysoft.model.Person;

public interface PersonRepository {

    public List<Person> findAll();
}
