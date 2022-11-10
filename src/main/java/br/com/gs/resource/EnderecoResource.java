package br.com.gs.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.gs.bo.EnderecoBO;
import br.com.gs.dao.EnderecoDAO;
import br.com.gs.exceptions.IdNotFoundException;
import br.com.gs.factory.ConnectionFactory;
import br.com.gs.to.EnderecoTO;
import oracle.jdbc.proxy.annotation.Post;


@Path("/endereco")
public class EnderecoResource {
	private EnderecoBO bo;
	private EnderecoDAO dao;
	
	public EnderecoResource() {
		try {
			bo = new EnderecoBO(ConnectionFactory.getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EnderecoTO> getAll() throws SQLException{
		return dao.getAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public EnderecoTO getById(int id) throws SQLException, IdNotFoundException{
		return dao.getById(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public EnderecoTO getByIdUser(int id) throws SQLException, IdNotFoundException{
		return dao.getByIdUser(id);
	}
	
	@Post
	@Consumes(MediaType.APPLICATION_JSON)
	public Response register(EnderecoTO endereco, @Context UriInfo uriInfo) throws SQLException {
		
		bo.register(endereco);
		
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		
		builder.path(Integer.toString(endereco.getId()));
		
		return Response.created(builder.build()).build();
	}
	
}
