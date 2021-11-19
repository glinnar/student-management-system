package se.iths.service;

import se.iths.entity.Student;
import se.iths.exceptions.CannotUpdateStudent;
import se.iths.exceptions.StudentInformationIsNull;
import se.iths.exceptions.StudentNotFound;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public Student findStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> getAllStudents() {
        return entityManager.createQuery("SELECT s from Student s", Student.class).getResultList();
    }


    public void createStudent(Student student) {
        if (student.getFirstName().isEmpty() || student.getLastName().isEmpty() || student.getEmail().isEmpty()) {
            throw new StudentInformationIsNull("Fields: " + student.getFirstName() + student.getLastName() + student.getEmail() + "cannot be empty! Please provide a value");
        }
        entityManager.persist(student);

    }

    public void deleteStudent(Long id) {
        Student studentToDelete = entityManager.find(Student.class, id);
        entityManager.remove(studentToDelete);

        if (studentToDelete == null) {
            throw new StudentNotFound("Can´t find selected Student");
        }
    }

//    public void updateStudent(Student student) {
//        if (student.getId() == null) {
//            throw new StudentNotFound("Can´t find selected Student");
//        }
//            entityManager.merge(student);
//
//    }

    public Student updateFirstName(Long id, Student student) {
        Student studentToUpdate = entityManager.find(Student.class, id);
        if (studentToUpdate == null) {
            throw new StudentNotFound("Can´t find selected student");
        }

        if (student.getFirstName().equals(studentToUpdate.getFirstName())) {
            throw new CannotUpdateStudent("First name was not changed");
        } else {
            studentToUpdate.setFirstName(student.getFirstName());
        }


        return entityManager.merge(studentToUpdate);

    }


    public Student updateLastName(Long id, Student student) {
        Student studentToUpdate = entityManager.find(Student.class, id);

        if (studentToUpdate == null) {
            throw new StudentNotFound("Can´t find selected student");
        }

        if (student.getLastName().equals(studentToUpdate.getLastName())) {
            throw new CannotUpdateStudent("Last name was not changed");
        } else {
            studentToUpdate.setLastName(student.getLastName());
        }

        return entityManager.merge(studentToUpdate);
    }


    public Student updateEmail(Long id, Student student) {
        Student studentToUpdate = entityManager.find(Student.class, id);

        if (studentToUpdate == null) {
            throw new StudentNotFound("Can´t find selected student");
        }

        if (student.getEmail().equals(studentToUpdate.getEmail())) {
            throw new CannotUpdateStudent("Email name was not changed");
        } else {

            studentToUpdate.setEmail(student.getEmail());
        }

        return entityManager.merge(studentToUpdate);
    }

    public Student updatePhoneNumber(Long id, Student student) {
        Student studentToUpdate = entityManager.find(Student.class, id);

        if (studentToUpdate == null) {
            throw new StudentNotFound("Can´t find selected student");
        }

        if (student.getPhoneNumber().equals(studentToUpdate.getPhoneNumber())) {
            throw new CannotUpdateStudent("Phone number was not changed");
        } else {
            studentToUpdate.setPhoneNumber(student.getPhoneNumber());
        }

        return entityManager.merge(studentToUpdate);
    }

    public List<Student> getLastName(String lastName) {
        return entityManager.createQuery("SELECT s from Student s where s.lastName = :lastName", Student.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }


}
