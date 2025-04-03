package se.lexikon.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService {

    private final Scanner scanner;

    @Autowired
    public ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        System.out.println( "Enter the student's name: ");
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        System.out.println( "Enter an integer: ");

        return Integer.parseInt(scanner.nextLine());
    }
}
