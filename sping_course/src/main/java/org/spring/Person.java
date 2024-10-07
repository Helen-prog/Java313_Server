package org.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("personBean")
public class Person {
//    @Autowired
    private Pet pet;

    @Value("${person.surname}")
    private String surname;

    @Value("${person.age}")
    private int age;

//    public Person() {
//        System.out.println("Constructor Person без параметров");
//    }
//
//    @Autowired
//    public Person(@Qualifier("catBean") Pet pet) {
//        System.out.println("Person constructor");
//        this.pet = pet;
//    }


    public Person(Pet pet) {
        System.out.println("Person constructor");
        this.pet = pet;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Class Person: setSurname");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Class Person: setAge");
        this.age = age;
    }

//    @Autowired
//    @Qualifier("dog")
    public void setPet(Pet pet) {
//    public void anyMethod(Pet pet) {
        System.out.println("В класс Person добавили животное");
//        System.out.println("В класс Person добавили anyMethod");
        this.pet = pet;
    }

    public void callYourPet() {
        System.out.println("Привет, питомец!");
        pet.say();
    }
}
