package com.sushant.cruddemo.dao;

import com.sushant.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class StudentDAOImpl implements StudentDAO{
    //define field for entity manager
    private EntityManager entityManager;




    //inject entity manager using constructor injection
@Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    //implement save method



    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }


    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);//you need to create default constructor for this to run
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName (String theLastName) {
// create query
        TypedQuery<Student> theQuery = entityManager.createQuery (
                 "FROM Student WHERE lastName=: theData", Student.class);
// set query parameters
        theQuery.setParameter ("theData", theLastName);
// return query results
        return theQuery.getResultList();}

    @Override
    @Transactional
    public void update(Student theStudent) {
       entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
      Student theStudent = entityManager.find(Student.class , id);
      entityManager.remove(theStudent);
    }
}
