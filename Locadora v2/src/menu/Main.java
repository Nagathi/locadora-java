package menu;

import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;
import estoque.*;
import clientside.Cliente;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException  {
			
			List<Cliente> lista_clientes = new ArrayList();
			
			Veiculo biz = new Veiculo("Biz", "2018", "4050-SMT", "30 Reais/Dia");
			Veiculo pop = new Veiculo("Pop 100", "2016", "9115-GTS", "30 Reais/Dia");
			Veiculo celta = new Veiculo("Celta", "2014", "0147-XLS", "70 Reais/Dia");
			Veiculo hb20 = new Veiculo("HB-20", "2020", "1934-KSX", "100 Reais/Dia");
			
			String logged = "";
			
			List <Veiculo> list = new ArrayList<Veiculo>();
			list.add(biz);
			list.add(pop);
			list.add(celta);
			list.add(hb20);
			
			Cliente cliente;
			
			int saveIndex = 0;
			boolean accepted = false;
			
			while(!accepted) {
	
				String op = JOptionPane.showInputDialog(
						
						"        Selecione uma opção        \n" +
						"1 - Cadastro \n" +
						"2 - Login \n\n"
				
						);
				
				if(op.equals("1")) {
					
					String nome = JOptionPane.showInputDialog("Nome: ");
					
					String user = JOptionPane.showInputDialog("Usuário: ");
					
					String pass = JOptionPane.showInputDialog("Senha: ");
					
					cliente = new Cliente(nome, user, pass);
					
					FileInputStream read_clientes = new FileInputStream("clientes.dat");
					lista_clientes = (List) new ObjectInputStream(read_clientes).readObject();
					
					Iterator it = lista_clientes.iterator();
					
					boolean aprovado = true;
					
					while(it.hasNext()) {
						Cliente cli = (Cliente) it.next();
						
						if(user.equals(cli.getUser())) {
							JOptionPane.showMessageDialog(null, "Usuário já cadastrado, tente outro.");
							aprovado = false;
						}else {
							
						}
					}
					
					if(aprovado) {
						lista_clientes.add(cliente);
						
						FileOutputStream write_clientes = new FileOutputStream("clientes.dat");
						ObjectOutputStream out = new ObjectOutputStream(write_clientes); 
						out.writeObject(lista_clientes);
						
						JOptionPane.showMessageDialog(null, "Cadastrado. Agora faça login!");
					}	
					
				}else
					
				if(op.equals("2")) {
					
					
						
					FileInputStream read_clientes = new FileInputStream("clientes.dat");
					ObjectInputStream in = new ObjectInputStream(read_clientes);
					lista_clientes = (List<Cliente>) in.readObject();
					in.close();
					
					String user = JOptionPane.showInputDialog("Usuário: ");
					
					String pass = JOptionPane.showInputDialog("Senha: ");
						
					boolean verify = false;
						
					Iterator<Cliente> it = lista_clientes.iterator();
						
					while(it.hasNext()){
							
						Cliente cli = it.next();
							
						if((user.equals(cli.getUser())) && (pass.equals(cli.getPass()))) {
								
							verify = true;
							accepted = true;
							JOptionPane.showMessageDialog(null, "Login autorizado!");
							logged = cli.getPass();
								
								
						}
					}
						
					if(!verify) {
						JOptionPane.showMessageDialog(null, "Login NÃO efetuado!");
					}
				}
				
				while(accepted) {
					
					op = JOptionPane.showInputDialog(
							
							"Escolha uma opção\n" +
							"1 - Alugar\n" +
							"2 - Devolver\n" +
							"0 - Encerrar \n\n"
							);
					
					if(op.equals("1")) {
						
						saveIndex = 0;
						
						for(int i = 0; i < list.size(); i++) {
							
							JOptionPane.showMessageDialog(null, "Modelo: " 	+ list.get(i).getModelo() 	+ "\n" +
																"Ano: " 	+ list.get(i).getAno() 		+ "\n" +
																"Placa: " 	+ list.get(i).getPlaca() 	+ "\n" +
																"Preço: " 	+ list.get(i).getPreco()			);
			
						}
						
						
						String alugar = JOptionPane.showInputDialog("Escolha o veículo a ser alugado pela placa: ");
						
						Iterator<Cliente> it = lista_clientes.iterator();

						while(it.hasNext()) {
								
							Cliente cli = it.next();
								
							if(logged.equals(cli.getPass())) {
								Iterator<Veiculo> it2 = list.iterator();
									
								while(it2.hasNext()) {
											
									Veiculo li = it2.next();
									String salvaNome = "";
											
									if(alugar.equalsIgnoreCase(li.getPlaca())) {
												
											if(saveIndex == 0) {
												cli.alugar(biz);
												salvaNome = li.getModelo();
											}else
												if(saveIndex == 1) {
													cli.alugar(pop);
													salvaNome = li.getModelo();
												}else
													if(saveIndex == 2) {
														cli.alugar(celta);
														salvaNome = li.getModelo();
													}else
														if(saveIndex == 3) {
															cli.alugar(hb20);
															salvaNome = li.getModelo();
														}
													
												JOptionPane.showMessageDialog(null, "Veiculo " + salvaNome + " alugado!");
												saveIndex++;
													
										}
									}
								}
							}
						}else
						
					if(op.equals("2")) {
						
						String placa = JOptionPane.showInputDialog("Escolha o veículo a ser devolvido pela placa: ");
						Iterator<Cliente> it = lista_clientes.iterator();

						while(it.hasNext()) {
									
							Cliente cli = it.next();
									
							if(logged.equals(cli.getPass())) {
										
								cli.devolver(placa);
										
								JOptionPane.showMessageDialog(null, "Se o veiculo estiver alugado, ele foi removido!");
							}
						}
							
					}
					if(op.equals("0")) {
						
						JOptionPane.showMessageDialog(null, "Informações do cliente estão sendo salvas...");
						
						Iterator<Cliente> it = lista_clientes.iterator();

						FileOutputStream write_clientes = new FileOutputStream("clientes.dat");
						ObjectOutputStream out = new ObjectOutputStream(write_clientes); 
						out.writeObject(lista_clientes);
							
						JOptionPane.showMessageDialog(null, "Informações salvas!");
						accepted = false;
								
						
					}
				}
			}
		}
	}