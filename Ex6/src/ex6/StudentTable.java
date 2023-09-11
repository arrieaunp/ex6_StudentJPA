/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex6;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Student;

/**
 *
 * @author aunchisachanatipakul
 */
public class StudentTable {
    public static void insertEmployee(Student emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex6_StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static void updateEmployee(Student stu) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex6_StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        Student fromDb = em.find(Student.class, stu.getId());
        fromDb.setName(stu.getName());
        fromDb.setGpa(stu.getGpa());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static void deleteStudent(Student stu) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex6_StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        Student fromDb = em.find(Student.class, stu.getId());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }         
    }

    public static Student findStudentById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex6_StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        Student emp = em.find(Student.class, id);
        em.close();
        return emp;
    }
    public static List<Student> findAllStudent() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex6_StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        List<Student> empList = (List<Student>) em.createNamedQuery("Student.findAll").getResultList();
        em.close();
        return empList;
    }
    public static List<Student> findStudenteByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex6_StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Student.findByName");
        query.setParameter("name", name);
        List<Student> empList = (List<Student>) query.getResultList();
        em.close();
        return empList;
    }
    
}
