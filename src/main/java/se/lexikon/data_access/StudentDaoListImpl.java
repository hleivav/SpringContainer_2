package se.lexikon.data_access;

import org.springframework.stereotype.Repository;
import se.lexikon.models.Student;

import java.util.List;

@Repository

public class StudentDaoListImpl implements StudentDao {

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Student find(int id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public void delete(int id) {

    }
}
