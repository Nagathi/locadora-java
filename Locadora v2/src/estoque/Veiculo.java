package estoque;

import java.io.Serializable;

public class Veiculo implements Serializable{
	private String modelo;
	private String ano;
	private String placa;
	private String preco;
	
public Veiculo(String modelo, String ano, String placa, String preco) {
		
		this.setModelo(modelo);
		this.setAno(ano);
		this.setPlaca(placa);
		this.setPreco(preco);
		
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
}