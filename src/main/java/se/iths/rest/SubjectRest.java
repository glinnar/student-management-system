package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {
    @Inject
    SubjectService subjectService;

    @Path("createSubject")
    @POST
    public Response createSubject(Subject subject){
        subjectService.createSubject(subject);

        return Response.status(Response.Status.CREATED).entity(subject).build();
    }

    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id){
        Subject foundStudent = subjectService.findSubjectById(id);

        return Response.status(Response.Status.OK).entity(foundStudent).build();
    }

    @Path("getsubjects")
    @GET
    public Response getAllSubjects(){
        List<Subject> foundSubjects = subjectService.getAllSubjects();

        return Response.status(Response.Status.OK).entity(foundSubjects).build();
    }

    @Path("delete/{id}")
    @DELETE
    public Response deleteSubject(@PathParam("id")Long id){
        subjectService.deleteSubject(id);
        return Response.status(Response.Status.OK).build();
    }

//    @Path("addStudents/{id}")
//    @POST
//    public Response addStudents(Subject subject , @PathParam("id")Long id){
//
//
//        subjectService.addStudents(subject,id);
//
//        return Response.status(Response.Status.CREATED).build();
//
//    }

}
