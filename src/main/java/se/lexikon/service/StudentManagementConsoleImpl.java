package se.lexikon.service;

import se.lexikon.data_access.StudentDao;
import se.lexikon.models.Student;
import se.lexikon.util.UserInputService;

import java.util.List;

public class StudentManagementConsoleImpl implements StudentManagement {
    UserInputService scannerService;
    StudentDao studentDao;

    public StudentManagementConsoleImpl(UserInputService scannerService, StudentDao studentDao) {
        this.scannerService = scannerService;
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        String studentName = scannerService.getString();
        return new Student(studentName);
    }

    @Override
    public Student save(Student student) {
        if (student != null) {
            if (find(student.getId()) == null) {
                return studentDao.save(student);
            } else {
                System.out.println("Student already exists");
            }
        }
        return null;
    }

    @Override
    public Student find(int id) {
        if (studentDao.find(id) != null) {
            return studentDao.find(id);}
        return null;
    }

    @Override
    public Student remove(int id) {
        if (find(id) != null) {
            studentDao.delete(id);
            return find(id);
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        if (studentDao.findAll() != null) {return studentDao.findAll();}
        return null;
    }

    @Override
    public Student edit(Student student) {
        if (student != null) {
            Student studentToEdit = find(student.getId());
            if (studentToEdit != null) {
                return studentDao.edit(studentToEdit, scannerService.getString());
            }
        }
        return null;
    }
}
