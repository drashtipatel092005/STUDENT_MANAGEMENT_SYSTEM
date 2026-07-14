/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Student;
import com.util.HibernateUtil;

public class StudentDAO {

    public boolean existsByEnrollment(String enrollment) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            return session.get(Student.class, enrollment) != null;
        }
    }

    public Student getByEnrollment(String enrollment) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            return session.get(Student.class, enrollment);
        }
    }

    // INSERT
    public void insert(Student s) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            
            session.save(s);
            
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    // VIEW
    public List<Student> getAll() {
        List<Student> list;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            list = session.createQuery("from Student", Student.class).list();
        }
        return list;
    }

    // UPDATE
    public void update(Student s) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            
            session.update(s);
            
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    // DELETE
    public void delete(String enrollment) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) {
            tx = session.beginTransaction();
            
            Student s = session.get(Student.class, enrollment);
            if (s != null) {
                session.delete(s);
            }
            
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }
}
