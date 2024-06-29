package LibraryManagementSystem;
package jsbcdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.net.ssl.SNIHostName;

import com.google.protobuf.Value;

public class Library {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("select an option");
		System.out.println("====================");
		System.out.println("1.REGISTER...");
		System.out.println("2.LOGIN...");
		Scanner scn=new Scanner(System.in);
		int Option=scn.nextInt();
		Connection con=HelperClass.get();
		switch (Option) {
		case 1:
		{
			System.out.println("insert admin data");
			System.out.println("-------------------------");
			System.out.println("enter id");
			int id=scn.nextInt();
			System.out.println("enter name");
			String name=scn.next();
			System.out.println("enter email");
			String email=scn.next();
			System.out.println("enter password");
			int password=scn.nextInt();
			
			PreparedStatement ps=con.prepareStatement("insert into admin(id,name,email,password) value(?,?,?,?)");
			ps.setInt(1,id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setInt(4, password);
			ps.execute();
			System.out.println("data inserted succesfully");
			
		}
		break;
		case 2:{
			System.out.println("enter your Email");
			String Email=scn.next();
			System.out.println("enter Password");
			String pswd=scn.next();
			PreparedStatement ps=con.prepareStatement("select * from Admin where Email=? and Password=?");
			ps.setString(1, Email);
			ps.setString(2, pswd);
			ResultSet rSet=ps.executeQuery();
			if (rSet.isBeforeFirst()) {
				System.out.println("Select following option");
				System.out.println("========================");
				System.out.println("1.add books");
				System.out.println("2.update books");
				System.out.println("3.view all books");
				System.out.println("4.view book by id");
				System.out.println("5.view book by Goner");
				System.out.println("6.delete book by id");
				System.out.println("7.view book by price(low to high)");
				System.out.println("8.view book by price(high to low)");
				int num=scn.nextInt();
				switch (num) {
				case 1:{
					System.out.println("enter id");
					int id=scn.nextInt();
					System.out.println("enter name");
					String name=scn.next();
					System.out.println("enter Auther name");
					String authorname=scn.next();
					System.out.println("enter goner");
					String goner=scn.next();
					System.out.println("enter price");
					int price=scn.nextInt();
					PreparedStatement ps1=con.prepareStatement("insert into Books(id,name,AuthorName,Goner,Price)values(?,?,?,?,?)");
					ps1.setInt(1, id);
					ps1.setString(2, name);
					ps1.setString(3,authorname);
					ps1.setString(4, goner);
					ps1.setInt(5, price);
					ps1.execute();
					System.out.println("Data added succesfully");
				}
					break;
				case 2:{
					System.out.println("enter id");
					int id=scn.nextInt();
					System.out.println("enter change name");
					String name=scn.next();
					System.out.println("enter new auther");
					String auther=scn.next();
					System.out.println("enter new Goner");
					String goner=scn.next();
					System.out.println("enter new Price ");
					int price=scn.nextInt();
					PreparedStatement ps3=con.prepareStatement("update table Books set name=?,auther=?,Goner=?,Price=? where id=?");
					ps3.setString(1, name);
					ps3.setString(2, auther);
					ps3.setInt(3, Option);
					ps3.setInt(4, id);
					int rowaffected=ps.executeUpdate();
					System.out.println("Data updated sucessfully");
					System.out.println("------------------------------------");
				}
				break;
				case 3:{
					System.out.println("These are books");
					PreparedStatement ps4=con.prepareStatement("select * from Books");
					ResultSet rs=ps4.executeQuery();
					while(rSet.next()) {
						System.out.println(rSet.getInt(1));
						System.out.println(rSet.getString(2));
						System.out.println(rSet.getString(3));
						System.out.println(rSet.getString(4));
						System.out.println(rSet.getInt(5));
						System.out.println("------------------------------------");
					}
				}
				break;
				case 4:{
					System.out.println("enter id");
					int id=scn.nextInt();
					PreparedStatement ps5=con.prepareStatement("select *from Books where id=?");
					ps5.setInt(1, id);
					ResultSet rs=ps5.executeQuery();
					if (rs.next()) {
						System.out.println("id:"+rs.getInt(1));
						System.out.println("name:"+rs.getString(2));
						System.out.println("Auther:"+rs.getString(3));
						System.out.println("Goner:"+rs.getString(4));
						System.out.println("Price:"+rs.absolute(5));
						System.out.println("------------------------------------");
					}else {
						System.out.println("enter id not exist");
					}
				}
				case 5:{
					System.out.println("enter Goner");
					String Goner=scn.next();
					PreparedStatement ps6=con.prepareStatement("select * from Books Goner=?");
					ResultSet rs=ps6.executeQuery();
					if(rs.next()) {
						System.out.println("id:"+rs.getInt(1));
						System.out.println("name:"+rs.getString(2));
						System.out.println("Auther:"+rs.getString(3));
						System.out.println("Goner:"+rs.getString(4));
						System.out.println("Price:"+rs.absolute(5));
						System.out.println("------------------------------------");
					}else {
						System.out.println("no data is available for this goner");
					}
				}
				case 6:{
					System.out.println("enter id you want to delete");
					int id=scn.nextInt();
					PreparedStatement ps7=con.prepareStatement("delete from Books where id=?");
					ps7.setInt(1, id);
					ps7.executeUpdate();
					System.out.println("id "+id+" row is deleted");
					System.out.println("------------------------------------");
				}
				case 7:{
					Statement st=con.createStatement();
					st.execute("select * from Books order by Price ASC");
					ResultSet rSet2=st.getResultSet();
					while(rSet2.next()) {
						System.out.println("id"+rSet2.getInt(1));
						System.out.println("name"+rSet2.getString(1));
						System.out.println("AutherName"+rSet2.getString(1));
						System.out.println("Goner"+rSet2.getString(1));
						System.out.println("Price"+rSet2.getInt(1));
						System.out.println("------------------------------------");
					}
				}
				break;
				case 8:{
					Statement st=con.createStatement();
					st.execute("select * from Books order by Price DESC");
					ResultSet rSet2=st.getResultSet();
					while(rSet2.next()) {
						System.out.println("id"+rSet2.getInt(1));
						System.out.println("name"+rSet2.getString(1));
						System.out.println("AutherName"+rSet2.getString(1));
						System.out.println("Goner"+rSet2.getString(1));
						System.out.println("Price"+rSet2.getInt(1));
						System.out.println("------------------------------------");
					}
				}
				break;
				}
			}
			else {
				System.out.println("invalid data or wrong id-password");
			}
			
		}
			
		
		}
	}
}
