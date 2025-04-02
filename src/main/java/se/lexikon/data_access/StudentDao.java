package se.lexikon.data_access;

import se.lexikon.models.Student;

import java.util.List;

public interface StudentDao {

    Student save(Student student);
    Student find(int id);
    List<Student> findAll();
    void delete(int id);

}
