package se.iths.Util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class Datagenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData(){
        Student student1 = new Student("Kungen","Kingen","Kungen@yahoo.com");
        Student student2 = new Student("Kejsaren" ,"Emperor", "Emperor@yahoo.com");
        Student student3 = new Student("Tsar" ,"Tsarson","Tsar@yahoo.com");

        Subject subject1 = new Subject("Historia","Hi1A");
        Subject subject2 = new Subject("Mattematik","Ma1A");
        Subject subject3 = new Subject("Geografi","Ge1A");
        Subject subject4 = new Subject("Idrott","I1A");

        Teacher teacher1 = new Teacher("Conny","Larsson","larsson@yahoo.com","111111");
        Teacher teacher2 = new Teacher("Magda","Karlsson","Karlsson@yahoo.com","222222");
        Teacher teacher3 = new Teacher("Klas","Klasson","Klasson@yahoo.com","333333");
        Teacher teacher4 = new Teacher("Anna","Annasson","Annasson@yahoo.com","444444");


        student1.addSubjects(subject1);
        student1.addSubjects(subject4);

        student2.addSubjects(subject2);
        student2.addSubjects(subject4);

        student3.addSubjects(subject3);
        student3.addSubjects(subject4);

        teacher1.addSubject(subject1);
        teacher2.addSubject(subject2);
        teacher3.addSubject(subject3);
        teacher4.addSubject(subject4);


        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);

        entityManager.persist(teacher1);
        entityManager.persist(teacher2);
        entityManager.persist(teacher3);
        entityManager.persist(teacher4);


    }
}
