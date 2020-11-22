package com.postgresqlplayground.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// To specify this is an entity to be used with postgres, we need these 2 annotations
// We can map out what table this entity maps to with the @Table annotation
@Entity
@Table(name = "names")
public class Names {
    private String name;
    private String email;
    private int age;
    // We need to provide an Id, in this scenario, I set up a a pk that auto increments.
    // The auto increment is done on the postgres side in this example, not the spring side!
    @Id
    private int pk;

    public Names (int pk, String name, String email, int age){
        this.pk = pk;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // A no args constructor is needed
    public Names() {
    }

    public long getId() {
        return pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        String stringBuilder = "Name:" + this.name +
                ", Age: " + this.age +
                ", Email:" + this.email;
        return stringBuilder;
    }
}
