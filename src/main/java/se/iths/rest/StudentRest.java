package se.iths.rest;

import se.iths.entity.Student;
import se.iths.exceptions.StudentNotFound;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;


    @Path("create/")
    @POST
    public Response createStudent(Student student) {

        studentService.createStudent(student);

        return Response.status(Response.Status.CREATED).entity(student).build();

    }
    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id")Long id){
        Student foundStudent = studentService.findStudentById(id);

        if(foundStudent == null){
            throw new StudentNotFound("Can´t find Studens with selected ID : " + id);
        }
        return Response.status(Response.Status.OK).entity(foundStudent).build();
    }

    @Path("getstudents")
    @GET
    public Response getAllStudents() {
        List<Student> foundStudents = studentService.getAllStudents();

        if(foundStudents.isEmpty()){
            throw new StudentNotFound("Can´t find Students");
        }

        return Response.ok(foundStudents).build();
    }

    @Path("delete/{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id")Long id){
        studentService.deleteStudent(id);
        return Response.status(Response.Status.OK).build();
    }

//   @Path("update")
//    @PUT
//    public Response updateStudent(Student student){
//         studentService.updateStudent(student);
//        return Response.status(Response.Status.ACCEPTED).entity(student).build();
//
//   }


    @Path("update/firstname/{id}")
    @PATCH
    public Response patchFirstName(@PathParam("id")Long id ,Student student){
        Student updatedStudent = studentService.updateFirstName(id,student);

        return Response.status(Response.Status.ACCEPTED).entity(updatedStudent).build();
    }

    @Path("update/lastname/{id}")
    @PATCH
    public Response patchLastName(@PathParam("id") Long id , Student student){
        Student updatedStudent = studentService.updateLastName(id,student);
        return Response.status(Response.Status.ACCEPTED).entity(updatedStudent).build();
    }

    @Path("update/email/{id}")
    @PATCH
    public Response patchEmail(@PathParam("id")Long id , Student student){
        Student updatedStudent = studentService.updateEmail(id,student);
        return Response.status(Response.Status.ACCEPTED).entity(updatedStudent).build();

    }

    @Path("update/phonenumber/{id}")
    @PATCH
    public Response patchPhoneNumber(@PathParam("id")Long id , Student student){
        Student updatedStudent = studentService.updatePhoneNumber(id,student);

        return Response.status(Response.Status.ACCEPTED).entity(updatedStudent).build();
    }

    @Path("findStudent")
    @GET
    public Response getStudentLastName(@QueryParam("lastName") String lastName){
        List<Student> studentList = studentService.getLastName(lastName);

        return Response.status(Response.Status.FOUND).entity(studentList).build();
    }

    // FIXA PATCHMETODENRNA SÅ MAN KAN ÄNDRA SAKER


}
