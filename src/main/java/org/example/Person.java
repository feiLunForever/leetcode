package org.example;

public class Person {
    String firstName;
    String lastName;

    Person() {
    }

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    void sayName() {
        System.out.println("firstName：" + this.firstName);
        System.out.println("lastName：" + this.lastName);
    }
}