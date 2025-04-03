package se.lexikon.data_access;

import org.springframework.stereotype.Repository;
import se.lexikon.models.Student;

import java.util.ArrayList;
import java.util.List;

@Repository

public class StudentDaoListImpl implements StudentDao {

    private List<Student>  students = new ArrayList<>();

    @Override
    public Student save(Student student) {
        if (student != null) {
            if (find(student.getId()) == null) {
                students.add(student);
                return student;
            } else {
                System.out.println("Student already exists");
            }
        }
        System.out.println("You must enter a valid student");
        return null;
    }

    @Override
    public Student find(int id) {
        for (Student element : students) {
            if (element.getId() == id) {
                return element;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        if (students != null) {
            return students;
        }
        System.out.println("No students found");
        return null;
    }

    @Override
    public void delete(int id) {
        if (find(id) != null) {
            students.remove(find(id));
        } else {
            System.out.println("Student not found");
        }
    }

    @Override
    public Student edit(Student student, String name) {
        student.setName(name);
        System.out.println("Student edited" + student);
        return student;
    }
}
