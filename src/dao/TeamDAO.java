
package dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.City;
import model.Team;
import utility.ConnectionManager;

public class TeamDAO
{
	public void createTeam(Team team) throws ClassNotFoundException, SQLException, IOException 
	{
		Connection con = ConnectionManager.getConnection();

		String sql = "INSERT INTO TEAM(id, name ,coach,captain,cityid)VALUES(?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		City city = (City) team.getCity();

		st.setInt(1, 5);
		st.setString(2, team.getName());
		st.setString(3,team.getCoach());
		st.setString(4,team.getCaptain());
		st.setLong(5,city.getCityId());
    	

		st.executeUpdate();
		con.close();
		System.out.println("Team has been created");
	}
}