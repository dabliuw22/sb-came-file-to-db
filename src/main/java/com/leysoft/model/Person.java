
package com.leysoft.model;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(
        separator = ",",
        skipFirstLine = true)
public class Person {

    @DataField(
            pos = 1)
    private Long id;

    @DataField(
            pos = 2)
    private String name;

    @DataField(
            pos = 3)
    private String username;

    public Person() {
    }

    public Person(Long id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
