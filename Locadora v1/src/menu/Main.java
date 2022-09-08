package menu;

import java.util.*;
import java.io.*;
import estoque.*;
import clientside.Cliente;

public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			
			Veiculo biz = new Veiculo("Biz", "2018", "4050-SMT", "30 Reais/Dia");
			Veiculo pop = new Veiculo("Pop 100", "2016", "9115-GTS", "30 Reais/Dia");
			Veiculo celta = new Veiculo("Celta", "2014", "0147-XLS", "70 Reais/Dia");
			Veiculo hb20 = new Veiculo("HB-20", "2020", "1934-KSX", "100 Reais/Dia");
			
			List <Veiculo> list = new ArrayList<Veiculo>();
			list.add(biz);
			list.add(pop);
			list.add(celta);
			list.add(hb20);
			
			Cliente cliente;
			List <Cliente> clientes = new ArrayList<Cliente>();
			
			int saveIndex = 0;
			boolean accepted = false;
			
			while(!accepted) {
	
				System.out.println("Escolha uma opção: ");
				System.out.println("1 - Cadastro");
				System.out.println("2 - Login");
				String op = sc.next();
				System.out.println();
				
				if(op.equals("1")) {
					System.out.println("Nome: ");
					String nome = sc.next();
					
					System.out.println("Usuário: ");
					String user = sc.next();
					
					System.out.println("Senha: ");
					String pass = sc.next();
					
					cliente = new Cliente(nome, user, pass);
					clientes.add(cliente);
					
					System.out.println();
					System.out.println("Cadastrado! Agora faça login.");
					System.out.println();
					
				}else
					
				if(op.equals("2")) {
					
					System.out.println("Usuário: ");
					String user = sc.next();
					
					System.out.println("Senha: ");
					String pass = sc.next();
					
					boolean verify = false;
					
					for(int i = 0; i < clientes.size(); i++) {
						
						if((user.equals(clientes.get(i).getUser())) && (pass.equals(clientes.get(i).getPass()))) {
							
							
							
							verify = true;
							accepted = true;
							System.out.println();
							System.out.println("Login autorizado!");
							System.out.println();
							
							saveIndex = i;
							
							
						}else {
							
						}
					}
					
					if(!verify) {
						System.out.println();
						System.out.println("Login NÃO efetuado!");
						System.out.println();
					}
				}
			}
			
			while(accepted) {
				
				System.out.println("Escolha uma opção: ");
				System.out.println("1 - Alugar");
				System.out.println("2 - Devolver");
				String op = sc.next();
				System.out.println();
				
				if(op.equals("1")) {
					
					System.out.println("=======================================");
					
					for(int i = 0; i < list.size(); i++) {
						
						System.out.println("Modelo: " + list.get(i).getModelo());
						System.out.println("Ano: " + list.get(i).getAno());
						System.out.println("Placa: " + list.get(i).getPlaca());
						System.out.println("Preço: " + list.get(i).getPreco());
						System.out.println("=======================================");
					}
					
					System.out.println("Escolha o veículo a ser alugado pela placa: ");
					String alugar = sc.next();
					
					for(int i = 0; i < list.size(); i++) {
						if(alugar.equalsIgnoreCase(list.get(i).getPlaca())) {
							if(i == 0) {
								clientes.get(saveIndex).alugar(biz);
							}else
								if(i == 1) {
									clientes.get(saveIndex).alugar(pop);
								}else
									if(i == 2) {
										clientes.get(saveIndex).alugar(celta);
									}else
										if(i == 3) {
											clientes.get(saveIndex).alugar(hb20);
										}
							System.out.println("Veiculo " + list.get(i).getModelo() + " alugado!");
						}
					}
					
				}else
					
				if(op.equals("2")) {
					
					System.out.println("Escolha o veículo a ser devolvido pela placa: ");
					String devolver = sc.next();
					
					clientes.get(saveIndex).devolver(devolver);
					
					String velDevolvido = clientes.get(saveIndex).devolver(devolver);
					
					System.out.println("Veiculo " + velDevolvido + " devolvido!");
					
				}
			}
		}
	}
}
