import java.sql.*;


import java.util.Scanner;/**
 * 
 */

/**
 * @author Harini
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int choice =0;
		
		while(choice!=8066)
		{
			System.out.println(" welcome to SMS (STUDENT MANAGEMENT SYSTEM)");
			System.out.println("please Authenticate System");
			
			System.out.println("enter choice : \n 1: Login \n 2: signup \n 3: exit \n");
			int menu =0;
			Scanner sc = new Scanner (System.in); 
			menu = sc.nextInt();
			
			switch(menu)
			{
			case 1:
				   boolean result = login();
			       if(result)
			       {
			    	   System.out.println("Login success");
			       }
			       else
			       {
			    	   System.out.println("wrong creditals or no record found:");
			       }
			       break;
			    	   
			case 2:System.out.println("signup");
			       break;
			
			case 3:choice = 8066;
					break;
			
			}
		}
	}
	
	static boolean login()
	
	{
		boolean loginsuccess = false;
		String id1="",pass="";
		String id="",password="";
		Scanner sc = new Scanner(System.in);
		System.out.println("enter ID:");
		id = sc.nextLine();
		System.out.println("enter password:");
		password = sc.nextLine();
		
		try {
			Class.forName("com.mysql.cj.jdbc.driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306SMS","root", "root");
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery("select *from login");
			
			while(rs.next())
		{
			id1 = rs.getString(1);
			pass = rs.getString(2);
			
		}
		}			
		catch(Exception e)
		{
			System.out.println(e);
		}

	

	    return loginsuccess;
}
//signup method
	static void signUp()
	{
		int loop=0;
		int code=0;
		String id="",password="",name="";
		while(loop!=8006)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Signup: two-step verification: \n");
			code = sc.nextInt();
			if(code==8006)
			{
				Scanner data = new Scanner(System.in);
				System.out.println("enter ID:");
				id = data.nextLine();
				System.out.println("enter a password:");
				password = data.nextLine();
				System.out.println("enter a name:");
				name = data.nextLine();
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306SMS","root", "root");
					String query = "insert into signUp (id,password,name)"+ "values (?,?,?)";
					String query1 = "insert into login (id,password)"+"values (?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					PreparedStatement ps1 = con.prepareStatement(query);
					ps.setString(1,  id);
					ps.setString(2, password);
					ps.setString(3, name);
					ps1.setString(1,  id);
					ps1.setString(2, password);
					int i =ps.executeUpdate();
					ps1.executeUpdate();
					
					if(i>0)
					{
						System.out.println("\n\nDate inserted.....\n\n");
					
					}
					else
					{
						System.out.println("/n/nDate is not inserted......\n\n");
					}
				}
				
				catch(Exception e)
				{
					System.out.println(e);
				}
			}else
			{
				System.out.println("wrong pin_code");
				return;
			}
		}
	}
}

