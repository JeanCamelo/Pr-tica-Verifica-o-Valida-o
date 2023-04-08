package madacaru2.controller;


import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import mandacaru2.dao.ImovelDAO;
import mandacaru2.dao.ImovelHibernateDAO;
import mandacaru2.entities.Imovel;

@Path("/imoveis")
public class ImovelController {

	ImovelDAO imovelDAO = new ImovelHibernateDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Imovel> getAllImoveis() {
		return imovelDAO.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Imovel getById(@PathParam("id") int id) {
		return imovelDAO.find(id);
	}

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public Imovel getByPreco(@QueryParam("preco") double preco) {
		return imovelDAO.findByPreco(preco);
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void addImovel(@FormParam("titulo") String titulo, @FormParam("endereco") String endereco,
	@FormParam("metrosQuadradosTerreno") int metrosQuadradosTerreno, @FormParam("metroQuadradoConstruido") int metroQuadradoConstruido,
	@FormParam("qtdQuartos") int qtdQuartos, @FormParam("qtdBanheiros") int qtdBanheiros, @FormParam("qtdVagasGaragem") int qtdVagasGaragem,
	@FormParam("preco") double preco) {
		Imovel imovel = new Imovel(0, titulo, endereco, metrosQuadradosTerreno, metroQuadradoConstruido, qtdQuartos, qtdBanheiros, qtdVagasGaragem, preco);
		imovelDAO.save(imovel);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updateImovel(@PathParam("id") int id, @FormParam("titulo") String titulo, @FormParam("endereco") String endereco,
	@FormParam("metrosQuadradosTerreno") int metrosQuadradosTerreno, @FormParam("metroQuadradoConstruido") int metroQuadradoConstruido,
	@FormParam("qtdQuartos") int qtdQuartos, @FormParam("qtdBanheiros") int qtdBanheiros, @FormParam("qtdVagasGaragem") int qtdVagasGaragem,
	@FormParam("preco") double preco) {
		Imovel imovel = new Imovel(id, titulo, endereco, metrosQuadradosTerreno, metroQuadradoConstruido, qtdQuartos, qtdBanheiros, qtdVagasGaragem, preco);
		imovelDAO.save(imovel);
	}

	@DELETE
	@Path("/{id}")
	public void deleteImovel(@PathParam("id") int id) {
		imovelDAO.delete(id);
	}
}
