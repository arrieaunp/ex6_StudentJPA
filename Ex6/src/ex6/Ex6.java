/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex6;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Student;

/**
 *
 * @author aunchisachanatipakul
 */
public class Ex6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Student stu1 = new Student(1, "Somchai", 3.77);
       Student stu2 = new Student(2, "Somying", 4.00);
       StudentTable.insertEmployee(stu1);
       StudentTable.insertEmployee(stu2);
//       Student stu;
//       stu = StudentTable.findEmployeeById(1);
//       if (stu != null) {
//           stu.setName("Jack");
//           EmployeeTable.removeEmployee(emp);
//           StudentTable.updateEmployee(stu);
//       }
//       List<Employee> empList = EmployeeTable.findEmployeeByName("Marry"); 
       List<Student> empList = StudentTable.findAllStudent();
       printAllEmployee(empList);
    }
    public static void printAllEmployee(List<Student> studentList) {
        for(Student stu : studentList) {
           System.out.print(stu.getId() + " ");
           System.out.print(stu.getName() + " ");
           System.out.println(stu.getGpa() + " ");
       }
    }
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex6_StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
    
