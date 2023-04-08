package mandacaru2;


import java.util.List;

import mandacaru2.dao.ImovelDAO;
import mandacaru2.dao.ImovelHibernateDAO;
import mandacaru2.entities.Imovel;


public class Main {
	public static void main(String[] args) {

		//Imovel imovel = new Imovel("Apartamento3","Rua Tavares Basto", 120, 20, 3, 2, 1, 350000);
		
		//ImovelDAO imovelDAO = new ImovelHibernateDAO();
		
		//Add
		//imovelDAO.save(imovel);
		
 
        // Find 
		//Imovel auxImovel = imovelDAO.find(1);
        //System.out.println(auxImovel);
 
        // Find by Preco 
        //Imovel auxImovel2 = imovelDAO.findByPreco(300000);
        //System.out.println(auxImovel2);
 
        // Find All 
        //List<Imovel> list = imovelDAO.findAll();
        //System.out.println(list);
 
        // Find All by Titulo 
        //list = imovelDAO.findAllByTitulo("Apartamento2");
        //System.out.println(list);
 
        // Update 
        //Imovel auxImovel3 = imovelDAO.find(1);
        //auxImovel3.setTitulo("Casa");
        //auxImovel3.setEndereco("Rua Joaquim Lopez");
        //auxImovel3.setPreco(400000);
        //imovelDAO.save(auxImovel3);
        //System.out.println(auxImovel3);
 
        // Delete
        //imovelDAO.delete(1);
	}
}
