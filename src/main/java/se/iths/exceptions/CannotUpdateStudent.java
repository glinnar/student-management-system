package se.iths.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class CannotUpdateStudent extends WebApplicationException {

    public CannotUpdateStudent(String message) {
        super(Response.status(Response.Status.CONFLICT).entity(message).build());
    }
}
