package webapi.jersey.controller;

import java.util.List;
import javax.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import webapi.jersey.dao.MemberDao;
import webapi.jersey.exception.ResponseMessage;
import webapi.jersey.model.Member;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("member")
public class MemberController {
	
	@GET
	public Response getAll() {
		List<Member> members = new MemberDao().findAll();
		return Response.status(Status.OK).entity(members).build();
	}
	
	@GET
	@Path("{id}")
	public Response getOne(@PathParam("id") Integer id) {
		Member member = new MemberDao().findOne(id);
		if(member != null) {
			return Response.status(Status.OK).entity(member).build();
		} else {
			ResponseMessage rm = new ResponseMessage(
						Status.NOT_FOUND.getStatusCode(), 
						Status.NOT_FOUND, 
						String.format("Member ID %d does not exist", id)
					);
			return Response.status(Status.NOT_FOUND).entity(rm).build();
		}
	}
	
	@POST
	public Response post(@Valid Member m) {
		Member member = new MemberDao().save(m);
		if(member != null) {
			return Response.status(Status.OK).entity(member).build();
		} else {
			ResponseMessage rm = new ResponseMessage(
						Status.BAD_REQUEST.getStatusCode(), 
						Status.BAD_REQUEST, 
						"Save Member Fail"
					);
			return Response.status(Status.BAD_REQUEST).entity(rm).build();
		}
	}
	
	@PUT
	@Path("{id}")
	public Response put(@PathParam("id") Integer id, @Valid Member m) {
		Member member = new MemberDao().update(id, m);
		if(member != null) {
			return Response.status(Status.OK).entity(member).build();
		} else {
			ResponseMessage rm = new ResponseMessage(
						Status.BAD_REQUEST.getStatusCode(), 
						Status.BAD_REQUEST, 
						String.format("Member ID %d does not exist", id)
					);
			return Response.status(Status.BAD_REQUEST).entity(rm).build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Integer id) {
		boolean flag = new MemberDao().delete(id); 
		if(flag) {
			ResponseMessage rm = new ResponseMessage(
						Status.OK.getStatusCode(), 
						Status.OK, 
						String.format("Member ID %d is deleted", id)
					);
			return Response.status(Status.OK).entity(rm).build();
		} else {
			ResponseMessage rm = new ResponseMessage(
						Status.BAD_REQUEST.getStatusCode(), 
						Status.BAD_REQUEST, 
						String.format("Invalid Member Format or Member ID %d does not exist", id)
					);
			return Response.status(Status.BAD_REQUEST).entity(rm).build();
		}
	}
	
}
