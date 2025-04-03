package se.lexikon.models;

import java.util.UUID;

public class Student {
    public int id;
    public String name;
    private static int counter = 0;

    public Student(String name) {
        this.id = generateUniqueId();
        this.name = name;
    }


    private int generateUniqueId() {
       return ++counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + '}';
    }

}
