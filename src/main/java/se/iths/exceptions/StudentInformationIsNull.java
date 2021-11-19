package se.iths.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class StudentInformationIsNull extends WebApplicationException {
    public StudentInformationIsNull(String message) {
        super(Response.status(Response.Status.NOT_ACCEPTABLE).entity(message).build());
    }
}
