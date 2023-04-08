package mandacaru2.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mandacaru2.entities.Imovel;

public class ImovelHibernateDAO implements ImovelDAO{
	
	static EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory("mandacaru");
    static EntityManager entityManager;

	public void save(Imovel entity) {
		entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
 
        if (entity.getId() == 0) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
 
        entityManager.getTransaction().commit();
        entityManager.close();
		
	}

	public void delete(int id) {
		entityManager = sessionFactory.createEntityManager();
		Imovel imovel = entityManager.find(Imovel.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(imovel);
        entityManager.getTransaction().commit();
        entityManager.close();
		
	}

	public Imovel find(int id) {
		 entityManager = sessionFactory.createEntityManager();
		 Imovel imovel = entityManager.find(Imovel.class, id);
	     entityManager.close();
	     
		return imovel;
	}

	public List<Imovel> findAll() {
		entityManager = sessionFactory.createEntityManager();
        List<Imovel> imoveis = entityManager.createQuery("from imovel", Imovel.class).getResultList();
        entityManager.close();
 
        return imoveis;
	}

	public Imovel findByPreco(double str) {
		entityManager = sessionFactory.createEntityManager();
		Imovel imovel = null;
 
        try {
        	imovel = entityManager.createQuery("from imovel where preco=?1", Imovel.class).setParameter(1, str)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
        entityManager.close();
 
        return imovel;
	}

	public List<Imovel> findAllByTitulo(String str) {
		 entityManager = sessionFactory.createEntityManager();
	        List<Imovel> imoveis = null;
	 
	        try {
	        	imoveis = entityManager.createQuery("from products where titulo=?1", Imovel.class)
	                    .setParameter(1, str).getResultList();
	        } catch (Exception e) {
	            return null;
	        }
	        entityManager.close();
	 
	        return imoveis;
	}
}
