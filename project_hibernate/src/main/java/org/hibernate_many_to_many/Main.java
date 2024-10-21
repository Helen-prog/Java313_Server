package org.hibernate_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate_many_to_many.entity.Child;
import org.hibernate_many_to_many.entity.Section;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg2.xml").addAnnotatedClass(Child.class).addAnnotatedClass(Section.class).buildSessionFactory();

        Session session = null;

        try{
//            session = factory.getCurrentSession();
//
//            Section section = new Section("Football");
//            Child child1 = new Child("Вадик", 5);
//            Child child2 = new Child("Саша", 6);
//            Child child3 = new Child("Миша", 7);
//            section.addChildToSection(child1);
//            section.addChildToSection(child2);
//            section.addChildToSection(child3);
//
//            session.beginTransaction();
//            session.persist(section);
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Volleyball");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Math");
//
//            Child child1 = new Child("Сергей", 9);
//
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//            session.persist(child1);
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 1);
//
//            System.out.println(section);
//            System.out.println(section.getChildren());
//
//            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            Child child = session.get(Child.class, 7);
//            System.out.println(child);
//            System.out.println(child.getSections());
            session.remove(child);

            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 6);
//            session.remove(section);
//
//            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
