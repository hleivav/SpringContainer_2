package se.lexikon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt;
import se.lexikon.config.ComponentScanConfig;
import se.lexikon.data_access.StudentDao;
import se.lexikon.service.UserInputService;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);

        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        UserInputService userInputService = context2.getBean(UserInputService.class);

        System.out.println("you entered:" + userInputService.getString());

    }
}