package org.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Dog implements Pet{
//    private String name;

    public Dog() {
        System.out.println("Dog Constructor");
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    public void say() {
        System.out.println("Гав-гав");
    }

    protected void init() {
        System.out.println("Class Dog: init method");
    }

    private void destroy() {
        System.out.println("Class Dog: destroy method");
    }
}
