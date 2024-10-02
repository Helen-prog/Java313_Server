package org.spring;

public class Person {
    private Pet pet;
    private String surname;
    private int age;

    public Person() {
        System.out.println("Constructor Person без параметров");
    }

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

    public void setPet(Pet pet) {
        System.out.println("В класс Person добавили животное");
        this.pet = pet;
    }

    public void callYourPet() {
        System.out.println("Привет, питомец!");
        pet.say();
    }
}
