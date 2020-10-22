package dao;

import java.sql.Statement;

import model.City;
import utility.ConnectionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDAO{
	
	public void getDetails() throws SQLException, ClassNotFoundException, IOException
	{
		Connection con = ConnectionManager.getConnection();
		Statement st =  con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM TEAM");
		while(rs.next())
		{
			System.out.print(rs.getString(1)+"\t ");
			System.out.print(rs.getString(2)+"\t ");
			System.out.println(rs.getString(5));
		}

	}
	
	public void getCityByName(String name) throws SQLException, ClassNotFoundException, IOException
	{
		Connection con = ConnectionManager.getConnection();
		Statement stmt=  con.createStatement();
		ResultSet rs =stmt.executeQuery("SELECT * FROM TEAM");
		while(rs.next())
		{
			if(name.equals(rs.getString("CITY")))
			{
			System.out.println("Team Name : "+rs.getString(1));
			System.out.println("Coach Name : "+rs.getString(2));
			System.out.println("Captain Name : "+rs.getString(3));
			System.out.println("City ID : "+rs.getLong(4));
			System.out.println("City Name : "+rs.getString(5));

			}
		}

	}
}
