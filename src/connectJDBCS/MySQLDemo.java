package connectJDBCS;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MySQLDemo {

	public static void main(String[] args) throws Exception
	{
		// loading the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establish the connection between java application and MySQL database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp1", "root", "mysql");
		
		//Create statement Object
		Statement st = con.createStatement();
		
		//Inputing the table name
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Table Name: ");
		String tablename = br.readLine();
		
		//Inputing the employee number
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter employee number: ");
		String employeeNo = br1.readLine();

		//Inputing the employee name
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter employee name: ");
		String employeeName = br2.readLine();
		
		//Inputing the employee salary
		BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter employee salary: ");
		String employeeSalary = br3.readLine();
		
		//write and Execute SQL Query
		String query =" create table " + tablename + " (ENumber int(3) primary key,EName varchar(10), EmpSalary float(5))";
		
		st.execute(query);
	
		String query1 = "Insert into "+tablename+" VALUES('"+employeeNo+"','"+employeeName+"','"+employeeSalary+"')";
		st.execute(query1);
		System.out.println("\n");
		System.out.println(" table created and values added succesfully");
		
		//close the connection
		st.close();
		con.close();

	}

}
