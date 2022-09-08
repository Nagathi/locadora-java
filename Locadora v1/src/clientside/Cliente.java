package clientside;
import estoque.*;
import java.util.*;

public class Cliente {

	private String nome;
	private String user;
	private String pass;
	private List <Veiculo> veiculos = new ArrayList<Veiculo>();
	
	public Cliente(String nome, String user, String pass) {
		
		this.setNome(nome);
		this.setUser(user);
		this.setPass(pass);
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List <Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List <Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	public void alugar(Veiculo veiculo) {
		veiculos.add(veiculo);
	}
	
	public String devolver(String placa) {
		
		int saveIndex = 0;
		
		for(int i = 0; i < veiculos.size(); i++) {
			
			System.out.println("Modelo: " + veiculos.get(i));
			System.out.println("Modelo: " + veiculos.get(i).getModelo());
			
			if(placa.equals(veiculos.get(i).getPlaca())) {
				
				saveIndex = i;
				veiculos.remove(i);
			}
		}
		
		String modelo = veiculos.get(saveIndex).getModelo();
		return modelo;
	}
}
