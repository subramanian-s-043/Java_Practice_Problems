package com.subramanians.cricketscore.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.subramanians.cricketscore.dto.Formats;
import com.subramanians.cricketscore.dto.Match;
import com.subramanians.cricketscore.dto.Team;

public class CricketRepo {
	static CricketRepo repo=null;
	Connection connection=null;
	String url="jdbc:mysql://localhost:3306/cricket_score";
	String username="root";
	String password="admin";
	PreparedStatement statement;
	ResultSet result;
	List<Team> availableTeams=new ArrayList<>();
	List<Formats> formats=new ArrayList<>();
	List<Match> matches=new ArrayList<>();
	
	public CricketRepo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error In Connecting With Database!,Please Import the SQL file !!");
		}	
	}
	
	public static CricketRepo getInstance() {
		if(repo==null) {
			repo=new CricketRepo();
		}
		return repo;
	}
	
	public void getTeams() {
		try {
			statement=connection.prepareStatement("Select * from teams");
			result=statement.executeQuery();
			while(result.next()) {
				int teamId=result.getInt("teamId");
				String name=result.getString("teamName");
				String teamAbb=result.getString("teamAbb");
				availableTeams.add(new Team(teamId,name,teamAbb));
			}
		}catch(SQLException e) {
			
		}
	}

	public void getMatches() {
		try {
			statement=connection.prepareStatement("Select * from matches");
			result=statement.executeQuery();
			while(result.next()) {
				int matchId=result.getInt("matchNo");
				String teampTeamA=result.getString("teamA");
				String tempTeamB=result.getString("teamB");
				String tempformat=result.getString("format");
				Team teamA=null;
				Team teamB=null;
				Formats format=null;
				for(Team t:availableTeams) {
					if(t.getTeam().equals(teampTeamA)) {
						teamA=t;
					}else if(t.getTeam().equals(tempTeamB)) {
						teamB=t;
					}
				}
				for(Formats f:formats) {
					if(f.getFormatName().equals(tempformat)) {
						format=f;
					}
				}
				matches.add(new Match(matchId,format.getOvers(),teamA,teamB,format.getFormatName()));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getFormats() {
		try {
			statement=connection.prepareStatement("Select * from formats");
			result=statement.executeQuery();
			while(result.next()) {
				String name=result.getString("formatName");
				int overs=result.getInt("overallOvers");
				formats.add(new Formats(name,overs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String[][] getTeam(Team team){
		String[][] players=new String[11][3];
		int i=0;
		try {
			statement=connection.prepareStatement("Select * from players where playerCountry=? ");
			statement.setString(1, team.getTeam());
			result=statement.executeQuery();
			while(result.next()) {
				players[i][0]=result.getString("playerName");
				players[i][1]=result.getString("playerRole");
				players[i][2]=String.valueOf(result.getInt("playerAt"));
				i++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return players;
	}
	
	public List<Match> getAllMatches(){
		getMatches();
		return matches;
	}
	
	public List<Team> getAvailableTeams() {
		getTeams();
		return availableTeams;		
	}

	public List<Formats> getAvailableFormats() {
		getFormats();
		return formats;
	}

	public void newMatch(Match match) {
		matches.add(match);
//		try {
//			statement=connection.prepareStatement("Insert into matches (matchNo,teamA,teamB,format) values(?,?,?,?)");
//			statement.setInt(1, match.getMatchId());
//			statement.setString(2, match.getTeamA().getTeam());
//			statement.setString(3, match.getTeamB().getTeam());
//			statement.setString(4, match.getFormat());
//			int rowsAffected=statement.executeUpdate();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
	}
}
