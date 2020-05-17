package webapi.jersey.exception;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
			ResponseMessage reponse = new ResponseMessage(Status.NOT_ACCEPTABLE.getStatusCode(), Status.NOT_ACCEPTABLE, exception.getMessage());
			return Response.status(Status.NOT_ACCEPTABLE).entity(reponse).type(MediaType.APPLICATION_JSON).build();
	}

}
