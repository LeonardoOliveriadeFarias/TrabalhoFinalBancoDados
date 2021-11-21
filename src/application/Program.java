package application;

import java.sql.Connection;
<<<<<<< HEAD

import java.util.Scanner;


=======
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
>>>>>>> 5b9d27f3480c43226d271d8c655e06eba83a8aa5

import db.DB;

public class Program {

	public static void main(String[] args) {
		
<<<<<<< HEAD
		int opc = 0, tabela;
		Scanner sc = new Scanner(System.in);
		OperacoesDoBanco banco = new OperacoesDoBanco();
		
		Connection conn = null;
=======
		int opc = 0;
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		ResultSet rs = null;
>>>>>>> 5b9d27f3480c43226d271d8c655e06eba83a8aa5
		
		do {
			System.out.println("Select 1 option: \n"
					+ "1 - Insert \n"
					+ "2 - Select \n"
					+ "3 - Update \n"
<<<<<<< HEAD
					+ "4 - Delete \n"
=======
>>>>>>> 5b9d27f3480c43226d271d8c655e06eba83a8aa5
					+ "0 - Exit"
					);
			
			opc = sc.nextInt();	
<<<<<<< HEAD
			conn = DB.getConnection();
			
			switch (opc) {
			case 1:
				//Create
					System.out.println("Inserir dado em qual tabela: \n"
							+ "1 - Funcionario\n"
							+ "2 - Automovel\n"
							+ "3 - Filial\n"
							+ "4 - Dependente");
					tabela = sc.nextInt();
					
					banco.insertData(tabela, conn);			
					
=======
			
			switch (opc) {
			case 1:
				
				System.out.println("Creating data");
					//INSERT
					
					PreparedStatement  pst = null;
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					try{
						conn = DB.getConnection();
						
						pst = conn.prepareStatement(
								"INSERT INTO seller" 
								+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) " 
								+ "VALUES " 
								+ "(?, ?, ?, ?, ?)",
								Statement.RETURN_GENERATED_KEYS);
						
						
						pst.setString(1, "Carl Purple");
						pst.setString(2, "Carl@gmail.com");
						pst.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
						pst.setDouble(4, 3000.00);
						pst.setInt(5, 4);
						
						int rowsAffected = pst.executeUpdate();
						if(rowsAffected > 0) {
							rs = pst.getGeneratedKeys();
							while(rs.next()) {
								int id = rs.getInt(1);
								System.out.println("Done! Id = " + id);
							}
						}else {
							System.out.println("No rows affected!");
						}
						
					}catch (SQLException e) {
						e.printStackTrace();
					}catch (ParseException e) {
						e.printStackTrace();
					}finally {
						DB.closeStatement(pst);
					}
>>>>>>> 5b9d27f3480c43226d271d8c655e06eba83a8aa5
				break;
				
				
			case 2:
<<<<<<< HEAD
				//Read
				
				System.out.println("Selecionar dados em qual tabela: \n"
						+ "1 - Funcionario\n"
						+ "2 - Automovel\n"
						+ "3 - Filia\n"
						+ "4 - Dependente\n"
						+ "5 - Estado\n"
						+ "6 - Cidades\n"
						+ "7 - Departamento\n");
				tabela = sc.nextInt();
				banco.selectData(tabela, conn);
				
=======
				//SELECT
				Statement st = null;
				
				System.out.println("Reading data");
				
				try{
					conn = DB.getConnection();
					
					st = conn.createStatement();			
					rs = st.executeQuery("Select * from department");
					
					while(rs.next()) {
						System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
					}
					
				}catch (SQLException e) {
					e.printStackTrace();
				}finally {
					DB.closeResultSet(rs);
					DB.closeStatement(st);
				}
>>>>>>> 5b9d27f3480c43226d271d8c655e06eba83a8aa5
				break;
			
			case 3:
				//UPDATE
<<<<<<< HEAD
				System.out.println("Atualizar dados em qual tabela: \n"
						+ "1 - Funcionario\n"
						+ "2 - Automovel\n"
						+ "3 - Filial\n"
						+ "4 - Dependente");
				tabela = sc.nextInt();
				banco.updateData(tabela, conn);
				
=======
				pst = null;
				
				System.out.println("Updating data");
				
				try {
					conn = DB.getConnection();
					
					pst = conn.prepareStatement(
							  "UPDATE seller "
							+ "SET BaseSalary = BaseSalary + ? "
							+ "WHERE "
							+ "(DepartmentId = ?)");
					
					pst.setDouble(1, 200);
					pst.setInt(2, 2);
					
					int rowsAffected = pst.executeUpdate();
					System.out.println("Done! Rows affected: " + rowsAffected);
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					DB.closeStatement(pst);
				}
>>>>>>> 5b9d27f3480c43226d271d8c655e06eba83a8aa5
				break;
				
			case 4:
				//DELETE
<<<<<<< HEAD
				
				System.out.println("Deletar dados em qual tabela:\n "
						+ "1 - Funcionario\n"
						+ "2 - Automovel\n"
						+ "3 - Filial\n"
						+ "4 - Dependente");
				tabela = sc.nextInt();
				banco.deleteData(tabela, conn);
				
=======
				pst = null;
				
				System.out.println("Deleting data");
				
				try {
					conn = DB.getConnection();
					
					pst = conn.prepareStatement(
							  "DELETE FROM department "
							+ "WHERE "
							+ "Id = ?");
					
					pst.setInt(1, 5);
					
					int rowsAffected = pst.executeUpdate();
					System.out.println("Done! Rows affected: " + rowsAffected);
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					DB.closeStatement(pst);
				}
>>>>>>> 5b9d27f3480c43226d271d8c655e06eba83a8aa5
				break;
				
			case 0:
				
				System.out.println("Closing Program! Bye!");
				DB.closeConnection();
				break;
				
			default:
				
				System.out.println("Wrong option! Try again");
				break;
			}
		} while (opc != 0);
				
 	}
	
}
