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
        String userInput = scanner.nextLine().trim();
        while (userInput.isEmpty()) {
            System.out.println( "You must enter a name. ");
            userInput = scanner.nextLine().trim();
        }
        return userInput;
    }

    @Override
    public int getInt() {
        System.out.println( "Enter an integer: ");
        String userInput = scanner.nextLine().trim();
        while (userInput.isEmpty()) {
            System.out.println( "You must enter an id. ");
            userInput = scanner.nextLine().trim();
        }
        return Integer.parseInt(userInput);
    }
}
