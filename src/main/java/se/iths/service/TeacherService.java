package se.iths.service;

import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TeacherService {
    @PersistenceContext
    EntityManager entityManager;


    public Teacher findTeacherbyId(Long id){
        return entityManager.find(Teacher.class,id);
    }

    public List<Teacher> getAllTeachers(){
        return entityManager.createQuery("Select t from Teacher t",Teacher.class).getResultList();
    }

    public void createTeacher(Teacher teacher){
        entityManager.persist(teacher);
    }

    public void deleteTeacher(Long id){
        Teacher teacherToDelete = entityManager.find(Teacher.class,id);
        entityManager.remove(teacherToDelete);
    }



}
