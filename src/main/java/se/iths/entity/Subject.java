package se.iths.entity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private LocalDate createdAt;

    @ManyToMany(cascade = CascadeType.MERGE)
    private Set<Student> students = new HashSet<>();

    @ManyToOne()
    private Teacher teacher;



    public void addStudents(Student student){
        students.add(student);
        student.getSubjects().add(this);
    }
    public void removeStudent(Student student){
        this.students.remove(student);
        student.getSubjects().remove(this);
    }
   //@JsonbTransient
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Subject() {

    }



    @PrePersist
    public void getCurrentDate() {
        setCreatedAt(LocalDate.now());
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
