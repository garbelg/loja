package br.unibh.loja.integracao;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unibh.loja.entidades.Cliente;
import br.unibh.loja.negocio.ServicoCliente;
import io.swagger.annotations.Api;

@Api
@Path("Cliente")
public class RestCliente {
	@Inject
	private ServicoCliente sc;

	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> helloworld() throws Exception {
		return sc.findAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente listarId(@PathParam("id") final Long id) throws Exception {
		return sc.find(id);
	}

	@GET
	@Path("perfil/{perfil}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> listarPerfil(@PathParam("perfil") final String perfil) throws Exception {
		return sc.findByPerfil(perfil);
	}

	@GET
	@Path("nome/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> listarNome(@PathParam("nome") final String nome) throws Exception {
		return sc.findByName(nome);
	}


	  //...
	  @POST
	  @Path("new")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	  public Cliente criarCliente(Cliente cliente) throws Exception {
		  return sc.insert(cliente);
	  }
	  @PUT
	  @Path("atualizar/{id}")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	  public Cliente atualizarCliente(@PathParam("id") final Long id, Cliente cliente) throws Exception {
		  return sc.update(cliente);
	  }
	  @DELETE
	  @Path("delete/{id}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public void deletarCliente(@PathParam("id")  final Long id) throws Exception {
		  sc.delete(sc.find(id));

	  }
	  
	
}