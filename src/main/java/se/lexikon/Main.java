package se.lexikon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexikon.config.ComponentScanConfig;
import se.lexikon.data_access.StudentDao;
import se.lexikon.models.Student;
import se.lexikon.service.StudentManagement;
import se.lexikon.service.StudentManagementConsoleImpl;
import se.lexikon.util.UserInputService;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);

        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        UserInputService userInputService = context2.getBean(UserInputService.class);

        StudentManagement studentManagement = new StudentManagementConsoleImpl(userInputService, studentDao);

        //saving 5 new students
        for (int i = 0; i < 4; i++) {
            studentManagement.save(studentManagement.create());
        }

        //writing all students
        System.out.println("All students:");
        studentManagement.findAll().forEach(element -> System.out.println(element.toString()));

        //
        System.out.println("Student to edit");
        System.out.println(studentManagement.edit(studentManagement.find(userInputService.getInt())));


        System.out.println("Student to remove");
        System.out.println(studentManagement.remove(userInputService.getInt()));

        System.out.println("All students:");
        studentManagement.findAll().forEach(element -> System.out.println(element.toString()));

    }
}