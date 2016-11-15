package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


/**
 * Created by Myriad 72 on 10/19/2016.
 */
public class QueryStudentDemo {

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents)
            System.out.println(tempStudent);
    }

    public static void main(String[] args) {

        //  create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //  create session
        Session session = factory.getCurrentSession();

        try {
            //  start a transaction
            session.beginTransaction();

            //  query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            //  display the students
            displayStudents(theStudents);

            //  query students: lastName='Doe'
            theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();

            //  display the students
            System.out.println("\nThe students who have the last name of Doe");
            displayStudents(theStudents);

            //  query students: lastName='Doe' or firstName='Daffy'
            theStudents = session.createQuery("from Student s where s.lastName='Doe' or s.firstName='Daffy'").getResultList();

            //  display the students
            System.out.println("\nThe students who have the last name of Doe or first name of Daffy");
            displayStudents(theStudents);

            //  querry students where email like '%gmail.com
            theStudents = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();

            System.out.println("\nThe students whose email ends with gmail.com");
            displayStudents(theStudents);

            //  commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
