package br.com.gs.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.gs.bo.PlanoBO;
import br.com.gs.to.PlanoTO;

@Path("/plano")
public class PlanoResource {
	PlanoBO pbo = new PlanoBO();

	// Cadastrar plano
	@POST
	@Consumes
	public Response cadastrar(PlanoTO pto, @Context UriInfo uriInfo) {

		pbo.cadastrar(pto);

		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(pto.getId()));
		return Response.created(builder.build()).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PlanoTO> buscar() {
		return pbo.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public PlanoTO buscar(@PathParam("id") int id) {
		return pbo.listar(id);
	}

	// Atualizar Plano
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(PlanoTO pto, @PathParam("id") int id) {
		pbo.atualizar(pto, id);
		return Response.ok().build();
	}
	//

	// Deletar plano
	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		pbo.deletar(id);
	}

}
