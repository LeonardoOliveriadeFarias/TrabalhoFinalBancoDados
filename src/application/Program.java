package application;

import java.sql.Connection;

import java.util.Scanner;



import db.DB;

public class Program {

	public static void main(String[] args) {
		
		int opc = 0, tabela;
		Scanner sc = new Scanner(System.in);
		OperacoesDoBanco banco = new OperacoesDoBanco();
		
		Connection conn = null;
		
		do {
			System.out.println("Select 1 option: \n"
					+ "1 - Insert \n"
					+ "2 - Select \n"
					+ "3 - Update \n"
					+ "4 - Delete \n"
					+ "0 - Exit"
					);
			
			opc = sc.nextInt();	
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
					
				break;
				
				
			case 2:
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
				
				break;
			
			case 3:
				//UPDATE
				System.out.println("Atualizar dados em qual tabela: \n"
						+ "1 - Funcionario\n"
						+ "2 - Automovel\n"
						+ "3 - Filial\n"
						+ "4 - Dependente");
				tabela = sc.nextInt();
				banco.updateData(tabela, conn);
				
				break;
				
			case 4:
				//DELETE
				
				System.out.println("Deletar dados em qual tabela:\n "
						+ "1 - Funcionario\n"
						+ "2 - Automovel\n"
						+ "3 - Filial\n"
						+ "4 - Dependente");
				tabela = sc.nextInt();
				banco.deleteData(tabela, conn);
				
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
