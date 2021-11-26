package se.iths.rest;

import se.iths.entity.Teacher;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teacher")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    @Inject
    TeacherService teacherService;

    @Path("create")
    @POST
    public Response createTeacher(Teacher teacher){
        teacherService.createTeacher(teacher);
        return Response.status(Response.Status.CREATED).entity(teacher).build();
    }

    @Path("{id}")
    @GET
    public Response getTeacher(@PathParam("id") Long id){
        Teacher foundTeacher = teacherService.findTeacherbyId(id);
        return Response.status(Response.Status.OK).entity(foundTeacher).build();
    }

    @Path("getTeachers")
    @GET
    public Response getAllTeachers(){
        List<Teacher> foundTeachers = teacherService.getAllTeachers();

        return Response.status(Response.Status.OK).build();
    }

    @Path("delete/{id}")
    @DELETE
    public Response deleteTeacher(@PathParam("id") Long id){
        teacherService.deleteTeacher(id);
        return Response.status(Response.Status.OK).build();
    }
}
