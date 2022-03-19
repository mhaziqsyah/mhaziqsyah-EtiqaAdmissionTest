package io.etiqatest.restapi.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository repository;

    @GetMapping("/")
    List<Student> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Student findOne(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/")
    Student create(@RequestBody Student student) {
        return repository.save(student);
    }

    @PutMapping("/{id}")
    Student update(@PathVariable int id, @RequestBody Student student) {
        Student oldStudent = repository.findById(id).orElse(null);
        oldStudent.setName(student.getName());
        oldStudent.setEmail(student.getEmail());
        oldStudent.setPassword(student.getPassword());
        return repository.save(oldStudent);
    }

    @DeleteMapping("/{id}")
    Integer destroy(@PathVariable int id) {
        repository.deleteById(id);
        return id;
    }

}
