package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DB;

public class OperacoesDoBanco {
	
	public void insertData(int tabela, Connection conn) {
		PreparedStatement  pst = null;
		try {
				int aux = 0;
				String resposta;
				Scanner sc = new Scanner(System.in);
				
				
				switch (tabela) {
				case 1:
					System.out.println("Tabela funcionários");
					pst = conn.prepareStatement(
							"INSERT INTO funcionario " 
							+ "(nome_funcionario, id_filial, id_departamento) " 
							+ "VALUES " 
							+ "(?, ?, ?)");
					
					System.out.println("Digite nome do funcionario");
					resposta = sc.nextLine();
					pst.setString(1, resposta);
					
					System.out.println("Digite id da filial");
					aux = sc.nextInt();
					pst.setInt(2, aux);
					
					System.out.println("Digite id do departamento");
					aux = sc.nextInt();
					pst.setInt(3, aux);
					
					
					
					break;
					
				case 2:
					System.out.println("Tabela Automóvel");
					pst = conn.prepareStatement(
							"INSERT INTO automovel" 
							+ "(modelo, id_funcionario) " 
							+ "VALUES " 
							+ "(?, ?)");
					
					System.out.println("Digite o modelo");
					resposta = sc.nextLine();
					pst.setString(1, resposta);
					
					System.out.println("Digite id do funcionario");
					aux = sc.nextInt();
					pst.setInt(2, aux);
								
					break;
					
				case 3:
					System.out.println("Tabela filial");
					pst = conn.prepareStatement(
							"INSERT INTO filial" 
							+ "(nome_filial, id_cidade) " 
							+ "VALUES " 
							+ "(?, ?)");
					
					System.out.println("Digite nome da filia");
					resposta = sc.nextLine();
					pst.setString(1, resposta);
					
					System.out.println("Digite id da cidade");
					aux = sc.nextInt();
					pst.setInt(2, aux);
							
					break;
			
				case 4:
					System.out.println("Tabela dependentes");
					pst = conn.prepareStatement(
							"INSERT INTO dependentes" 
							+ "(nome_dependente, parentesco, id_funcionario) " 
							+ "VALUES " 
							+ "(?, ?, ?)");
					
					System.out.println("Digite nome do dependente");
					resposta = sc.nextLine();
					pst.setString(1, resposta);
					
					System.out.println("Digite parentesco");
					resposta = sc.nextLine();
					pst.setString(2, resposta);
					
					System.out.println("Digite id do funcionario");
					aux = sc.nextInt();
					pst.setInt(3, aux);
					break;
				
				case 0:
					System.out.println("Retornando ao menu");
					break;
					
				default:
					System.out.println("Opcao inexistente");
					break;
				}
				pst.executeUpdate();
				
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeStatement(pst);
		}
	}


	public void selectData(int tabela, Connection conn) {

		Statement st = null;
		ResultSet rs = null;
		
		try {
				int aux = 0;
				String resposta;
				Scanner sc = new Scanner(System.in);
								
				st = conn.createStatement();
				
				switch (tabela) {
				case 1:
					System.out.println("Tabela funcionrios");
					rs = st.executeQuery("Select * from funcionario");
					
					while(rs.next()) {
						System.out.println(rs.getInt("id_funcionario") + ", " + rs.getString("nome_funcionario"));
					}
					
					break;
					
				case 2:
					System.out.println("Tabela Automóvel");
					rs = st.executeQuery("Select * from automovel");
					
					while(rs.next()) {
						System.out.println(rs.getInt("id_automovel") + ", " + rs.getString("nome_automovel"));
					}
					
								
					break;
					
				case 3:
					System.out.println("Tabela filial");
					rs = st.executeQuery("Select * from filial");
					
					while(rs.next()) {
						System.out.println(rs.getInt("id_filial") + ", " + rs.getString("nome_filial"));
					}
					
							
					break;
			
				case 4:
					System.out.println("Tabela dependentes");
					rs = st.executeQuery("Select * from dependentes");
					
					while(rs.next()) {
						System.out.println(rs.getInt("id_departamento") + ", " + rs.getString("nome_cidade"));
					}
					
					break;
				case 5:
					System.out.println("Tabela Estado");
					rs = st.executeQuery("Select * from estado");
					
					while(rs.next()) {
						System.out.println(rs.getInt("id_estado") + ", " + rs.getString("nome_estado"));
					}
					
					break;
				case 6:
					System.out.println("Tabela Cidades");
					rs = st.executeQuery("SELECT * from cidade");
					
					while(rs.next()) {
						System.out.println(rs.getInt("id_cidade") + ", " + rs.getString("nome_cidade"));
					}
					
					break;
				case 7:
					System.out.println("Tabela departamento");
					rs = st.executeQuery("Select * from departamento");
					
					while(rs.next()) {
						System.out.println(rs.getInt("id_departamento") + ", " + rs.getString("nome_departamento"));
					}
					
					break;
				
				case 0:
					System.out.println("Retornando ao menu");
					break;
					
				default:
					System.out.println("Opcao inexistente");
					break;
				}
				
				
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	
	public void updateData(int tabela, Connection conn) {
		PreparedStatement  pst = null;
		
		try {
				int aux = 0;
				String resposta;
				Scanner sc = new Scanner(System.in);
				
				
				
				switch (tabela) {
				case 1:
					System.out.println("Tabela funcionários");
					pst = conn.prepareStatement(
							  "UPDATE funcionario "
							+ "SET id_filial = ? "
							+ "WHERE "
							+ "(id_funcionario = ?)");
					
					System.out.println("Digite nova filial");
					aux = sc.nextInt();
					pst.setInt(1, aux);
					
					System.out.println("Digite id do funcionário");
					aux = sc.nextInt();
					pst.setInt(2, aux);
					
					
					break;
					
				case 2:
					System.out.println("Tabela Automóvel");
					pst = conn.prepareStatement(
							  "UPDATE automovel "
							+ "SET modelo = ? "
							+ "WHERE "
							+ "(id_automovel = ?)");
					
					System.out.println("Digite novo modelo");
					resposta = sc.nextLine();
					pst.setString(1, resposta);
					
					System.out.println("Digite id do automovel");
					aux = sc.nextInt();
					pst.setInt(2, aux);
								
					break;
					
				case 3:
					System.out.println("Tabela filial");
					pst = conn.prepareStatement(
							  "UPDATE filial "
							+ "SET nome_filial = ? "
							+ "WHERE "
							+ "(id_filial = ?)");
					
					System.out.println("Digite novo nome da filial");
					resposta = sc.nextLine();
					pst.setString(1, resposta);
					
					System.out.println("Digite id da filial");
					aux = sc.nextInt();
					pst.setInt(2, aux);
							
					break;
			
				case 4:
					System.out.println("Tabela dependentes");
					pst = conn.prepareStatement(
							  "UPDATE dependentes "
							+ "SET nome_dependente = ? "
							+ "WHERE "
							+ "(id_dependente = ?)");
					
					System.out.println("Digite nome dependente");
					resposta = sc.nextLine();
					pst.setString(1, resposta);
					
					System.out.println("Digite id do dependente");
					aux = sc.nextInt();
					pst.setInt(2, aux);
					break;
				
				case 0:
					System.out.println("Retornando ao menu");
					break;
					
				default:
					System.out.println("Opcao inexistente");
					break;
				}
				pst.executeUpdate();
				
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeStatement(pst);
		}
		
	}

	
	public void deleteData(int tabela, Connection conn) {
		PreparedStatement  pst = null;
		try {
				int aux = 0;
				String resposta;
				Scanner sc = new Scanner(System.in);
				
				
				
				switch (tabela) {
				case 1:
					System.out.println("Tabela funcionários");
					pst = conn.prepareStatement(
							  "DELETE FROM funcionario "
							+ "WHERE "
							+ "id_funcionario = ?");
					
					
					System.out.println("Digite id do funcionário");
					aux = sc.nextInt();
					pst.setInt(1, aux);
					
					break;
					
				case 2:
					System.out.println("Tabela Automóvel");
					pst = conn.prepareStatement(
							  "DELETE FROM automovel "
							+ "WHERE "
							+ "id_automovel = ?");
					
					
					System.out.println("Digite id do Automóvel");
					aux = sc.nextInt();
					pst.setInt(1, aux);
								
					break;
					
				case 3:
					System.out.println("Tabela filial");
					pst = conn.prepareStatement(
							  "DELETE FROM filial "
							+ "WHERE "
							+ "id_filial = ?");
					
					
					System.out.println("Digite id do Filial");
					aux = sc.nextInt();
					pst.setInt(1, aux);
							
					break;
			
				case 4:
					System.out.println("Tabela dependentes");
					pst = conn.prepareStatement(
							  "DELETE FROM dependentes "
							+ "WHERE "
							+ "id_dependente = ?");
					
					
					System.out.println("Digite id do dependentes");
					aux = sc.nextInt();
					pst.setInt(1, aux);
					break;
				
				case 0:
					System.out.println("Retornando ao menu");
					break;
					
				default:
					System.out.println("Opcao inexistente");
					break;
				}
				pst.executeUpdate();
				
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DB.closeStatement(pst);
		}
		
	}

	


}
