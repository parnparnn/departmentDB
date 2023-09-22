/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Akiparn
 */
public class DepartmentTable {

    public static void InsertDepartment(Department dp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(dp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void updateDepartment(Department dp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();
        Department fromDb = em.find(Department.class, dp.getDepartmentid());
        fromDb.setName(dp.getName());
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
    public static void removeDepartment(Department dp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();
        Department fromDb = em.find(Department.class, dp.getDepartmentid());
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
    public static List<Department> findAllDepartment() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();
        List<Department> dpList = (List<Department>) em.createNamedQuery("Department.findAll").getResultList();
        em.close();
        return dpList;
    }
    public static Department findDepartmentById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();
        Department dp = em.find(Department.class, id);
        em.close();
        return dp;
    }
    public static List<Department> findStudentByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Department.findByName");
        query.setParameter("name", name);
        List<Department> dpList = (List<Department>) query.getResultList();
        em.close();
        return dpList;
    }
}