package org.example;

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}