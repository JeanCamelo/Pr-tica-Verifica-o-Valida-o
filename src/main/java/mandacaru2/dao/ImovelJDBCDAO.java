package mandacaru2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import mandacaru2.entities.Imovel;

public class ImovelJDBCDAO implements ImovelDAO{

	public void save(Imovel entity) {
		 Connection con = null;
	        try {
	            con = ConnectionFactory.getConnection();
	            String insert_sql = "insert into imovel (titulo, endereco, metrosQuadradosTerreno, metrosQuadradosConstruido, qtdQuartos, qtdBanheiros, qtdVagasGaragem, preco) values (?, ?, ?, ?, ?, ?, ?, ?)";
	            String update_sql = "update imovel set titulo = ?, endereco = ?, metrosQuadradosTerreno = ?, metrosQuadradosConstruido = ?, qtdQuartos = ?, qtdBanheiros = ?, qtdVagasGaragem = ?, preco = ? where id = ?";
	            PreparedStatement pst;
	            if (entity.getId() == 0) {
	                pst = con.prepareStatement(insert_sql);
	            } else {
	                pst = con.prepareStatement(update_sql);
	                pst.setInt(9, entity.getId());
	            }
	            pst.setString(1, entity.getTitulo());
	            pst.setString(2, entity.getEndereco());
	            pst.setInt(3, entity.getMetrosQuadradosTerreno());
	            pst.setInt(4, entity.getMetrosQuadradosConstruido());
	            pst.setInt(5, entity.getQtdQuartos());
	            pst.setInt(6, entity.getQtdBanheiros());
	            pst.setInt(7, entity.getQtdVagasGaragem());
	            pst.setDouble(8, entity.getPreco());
	            pst.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (con != null)
	                    con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		
	}

    public void delete(int id) {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "delete from imovel where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Imovel find(int id) {
        Connection con = null;
        Imovel p = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from imovel where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                p = map(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return p;
    }
    
	public List<Imovel> findAll() {
        Connection con = null;
        List<Imovel> result = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from imovel";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            result = new ArrayList<Imovel>();
            while (rs.next()) {
            	Imovel cl = map(rs);
                result.add(cl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
	}

	public Imovel findByPreco(double preco) {
		Connection con = null;
		Imovel p = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "select * from imovel where preco = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDouble(1, preco);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                p = map(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return p;
	}

	public List<Imovel> findAllByTitulo(String str) {
	     Connection con = null;
	        List<Imovel> result = null;
	        try {
	            con = ConnectionFactory.getConnection();
	            String sql = "select * from imovel where titulo = ?";
	            PreparedStatement pst = con.prepareStatement(sql);
	            pst.setString(1, str);
	            ResultSet rs = pst.executeQuery();
	            result = new ArrayList<Imovel>();
	            while (rs.next()) {
	            	Imovel cl = map(rs);
	                result.add(cl);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (con != null)
	                    con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return result;
	}
	
    private Imovel map(ResultSet rs) throws SQLException {
    	Imovel p = new Imovel();
        p.setId(rs.getInt("id"));
        p.setTitulo(rs.getString("titulo"));
        p.setEndereco(rs.getString("endereco"));
        p.setMetrosQuadradosTerreno(rs.getInt("metrosQuadradosTerreno"));
        p.setMetrosQuadradosConstruido(rs.getInt("metrosQuadradosConstruido"));
        p.setQtdQuartos(rs.getInt("qtdQuartos"));
        p.setQtdBanheiros(rs.getInt("qtdBanheiros"));
        p.setQtdVagasGaragem(rs.getInt("qtdVagasGaragem"));
        p.setPreco(rs.getDouble("preco"));
        return p;
    }
}
