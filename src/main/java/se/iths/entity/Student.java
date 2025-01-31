package se.iths.entity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @Email(message = "Insert a valid Email")
    private String email;

    private String phoneNumber;
    private LocalDate createdAt;

@ManyToMany( mappedBy = "students",cascade = {CascadeType.REFRESH,CascadeType.PERSIST} )
//    @ManyToMany
    @JoinTable(name= "student_subject",
    joinColumns = {@JoinColumn(name = "subject_id")},
    inverseJoinColumns = {@JoinColumn(name = "student_id")})
     private Set<Subject> subjects = new HashSet<>();

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student(){}

    public void addSubjects(Subject subject){
        subjects.add(subject);
        subject.getStudents().add(this);
    }



    public void removeSubject(Subject subject){
        this.subjects.remove(subject);
        subject.getStudents().remove(this);
    }
   @JsonbTransient
    public Set<Subject> getSubjects(){
        return subjects;
    }

    public void setSubjects(Set<Subject> subject){
        this.subjects = subject;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
