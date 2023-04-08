package mandacaru2.dao;

import java.util.List;

import mandacaru2.entities.Imovel;

public interface ImovelDAO {
	

	public void save(Imovel entity);

	public void delete(int id);

	public Imovel find(int id);

	public List<Imovel> findAll();
	
	public Imovel findByPreco(double i);

	public List<Imovel> findAllByTitulo(String str);

}
