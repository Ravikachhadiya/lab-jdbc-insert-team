package controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import dao.CityDAO;
import dao.TeamDAO;
import model.City;
import model.Team;

public class Main 

{
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		CityDAO citydao = new CityDAO();
		TeamDAO teamdao = new TeamDAO();
		City city = null;
		Team team = null;
		System.out.println("Enter city name");
		String cityName = br.readLine();

		System.out.println("Enter id");
		long id = Long.parseLong(br.readLine());

		city = new City(id,cityName);

		System.out.println("Enter team name");
		String name = br.readLine();

		System.out.println("Enter coach name");
		String coachName = br.readLine();

		System.out.println("Enter captain name");
		String captianName = br.readLine();

		team = new Team(name,coachName,captianName,city);

		teamdao.createTeam(team);

		System.out.println("Team Details are :");
		System.out.println("Name \t Coach \t City");
		citydao.getDetails();

		System.out.println("Enter city name to get details of city");
		String cname=br.readLine();
		citydao.getCityByName(cname);

	}

} 