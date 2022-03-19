package io.etiqatest.restapi.Student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue
    public int id;

    public String name;
    public String email;
    public String password;
    
    
}
