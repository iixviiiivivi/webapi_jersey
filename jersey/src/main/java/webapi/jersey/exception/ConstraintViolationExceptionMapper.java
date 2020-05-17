package webapi.jersey.exception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		StringBuilder sb = new StringBuilder();
		for(ConstraintViolation<?> cv: exception.getConstraintViolations()) {
			sb.append("<").append(cv.getMessage()).append("> ");
		}
		
		ResponseMessage rm = new ResponseMessage(Status.BAD_REQUEST.getStatusCode(), Status.BAD_REQUEST, sb.toString());
		return Response.status(Status.BAD_REQUEST).entity(rm).build();
	}

}
