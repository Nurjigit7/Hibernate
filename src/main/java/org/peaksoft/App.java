package org.peaksoft;


import org.hibernate.Session;
import org.peaksoft.model.Student;
import org.peaksoft.util.Hibernate_Util;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Student student = new Student("Bektursun", "Amanov", "bektursun@gmail.com", 22);
        Student student1 = new Student("Rysbek", "Sharapov", "rysbek@gmail.com", 25);
        Student student2 = new Student("Bekbolsun", "Bekmyrza uluu", "bekbolsun@gmail.com", 26);
//        createStudent(student);
//        createStudent(student1);
//        createStudent(student2);
//        System.out.println(getById(1L));
//        System.out.println(getALlStudent());
        System.out.println(deleteStudent(student));

    }

    public static void createStudent(Student student) {

        Session session = Hibernate_Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("Aded Successfily ");

    }

    public static Student getById(Long id) {
        Session session = Hibernate_Util.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        session.close();
        return student;
    }
    public static List<Student> getALlStudent() {
        Session session = Hibernate_Util.getSessionFactory().openSession();
        session.beginTransaction();
        List<Student> students = session.createQuery
                (" from Student ", Student.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return students;
    }
    public static Student deleteStudent(Student student){
        Session session=Hibernate_Util.getSessionFactory().openSession();
        session.beginTransaction();
        try{
            session.delete(student);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    return student;
    }
}
