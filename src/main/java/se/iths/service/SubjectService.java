package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;


    public Subject findSubjectById(Long id){
        return entityManager.find(Subject.class,id);
    }

    public List<Subject> getAllSubjects(){
        return entityManager.createQuery("Select s from Subject s", Subject.class).getResultList();
    }

    public void createSubject(Subject subject){
        entityManager.persist(subject);
    }

    public void deleteSubject(Long id){
        Subject subjectToDelete = entityManager.find(Subject.class,id);
        entityManager.remove(subjectToDelete);
    }

    public Subject addSubject(Long id, Student studentt){
        Subject foundSubject = entityManager.find(Subject.class,id);
        foundSubject.addStudents(studentt);

        entityManager.persist(foundSubject);

        return foundSubject;

    }

}
