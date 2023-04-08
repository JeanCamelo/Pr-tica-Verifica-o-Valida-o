package mandacaru2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "imovel")
public class Imovel {
	 
	 @Id
	 @GeneratedValue
	 @Column(name = "id")
     private int id;
     
	 @Column(name = "titulo")
	 private String titulo;
	 
	 @Column(name = "endereco")
	 private String endereco;
	 
	 @Column(name = "metroQuadradoTerreno")
	 private int metrosQuadradosTerreno;
	 
	 @Column(name = "metroQuadradoConstruido")
	 private int metrosQuadradosConstruido;
	 
	 @Column(name = "qtdQuartos")
	 private int qtdQuartos;
	 
	 @Column(name = "qtdBanheiros")
	 private int qtdBanheiros;
	 
	 @Column(name = "qtdVagasGaragem")
	 private int qtdVagasGaragem;
	 
	 @Column(name = "preco")
	 private double preco;
	 
	public int getId() {
		return id;
	}
	 
	public void setId(int id) {
			this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getMetrosQuadradosTerreno() {
		return metrosQuadradosTerreno;
	}

	public void setMetrosQuadradosTerreno(int metrosQuadradosTerreno) {
		this.metrosQuadradosTerreno = metrosQuadradosTerreno;
	}

	public int getMetrosQuadradosConstruido() {
		return metrosQuadradosConstruido;
	}

	public void setMetrosQuadradosConstruido(int metrosQuadradosConstruido) {
		this.metrosQuadradosConstruido = metrosQuadradosConstruido;
	}

	public int getQtdQuartos() {
		return qtdQuartos;
	}

	public void setQtdQuartos(int qtdQuartos) {
		this.qtdQuartos = qtdQuartos;
	}

	public int getQtdBanheiros() {
		return qtdBanheiros;
	}

	public void setQtdBanheiros(int qtdBanheiros) {
		this.qtdBanheiros = qtdBanheiros;
	}

	public int getQtdVagasGaragem() {
		return qtdVagasGaragem;
	}

	public void setQtdVagasGaragem(int qtdVagasGaragem) {
		this.qtdVagasGaragem = qtdVagasGaragem;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public Imovel(int id, String titulo, String endereco, int metrosQuadradosTerreno,
			int metrosQuadradosConstruido, int qtdQuartos, int qtdBanheiros, int qtdVagasGaragem, double preco) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.endereco = endereco;
		this.metrosQuadradosTerreno = metrosQuadradosTerreno;
		this.metrosQuadradosConstruido = metrosQuadradosConstruido;
		this.qtdQuartos = qtdQuartos;
		this.qtdBanheiros = qtdBanheiros;
		this.qtdVagasGaragem = qtdVagasGaragem;
		this.preco = preco;
	}
	
	public Imovel(String titulo, String endereco, int metrosQuadradosTerreno,
			int metrosQuadradosConstruido, int qtdQuartos, int qtdBanheiros, int qtdVagasGaragem, double preco) {
		super();
		this.titulo = titulo;
		this.endereco = endereco;
		this.metrosQuadradosTerreno = metrosQuadradosTerreno;
		this.metrosQuadradosConstruido = metrosQuadradosConstruido;
		this.qtdQuartos = qtdQuartos;
		this.qtdBanheiros = qtdBanheiros;
		this.qtdVagasGaragem = qtdVagasGaragem;
		this.preco = preco;
	}

	public Imovel() {
		super();
	}

	@Override
	public String toString() {
		return "Imovel [id=" + id + ", titulo=" + titulo + ", endereco=" + endereco + ", metrosQuadradosTerreno="
				+ metrosQuadradosTerreno + ", metrosQuadradosConstruido=" + metrosQuadradosConstruido + ", qtdQuartos="
				+ qtdQuartos + ", qtdBanheiros=" + qtdBanheiros + ", qtdVagasGaragem=" + qtdVagasGaragem + ", preco="
				+ preco + "]";
	}
}
