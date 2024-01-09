package com.subramanians.cricketscore.repo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		getFormats();
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
						teamA.setTeamMembers(getTeam(teamA));
					}else if(t.getTeam().equals(tempTeamB)) {
						teamB=t;
						teamB.setTeamMembers(getTeam(teamB));
					}
				}
				for(Formats f:formats) {
					if(f.getFormatName().equals(tempformat)) {
						format=f;
					}
				}
				Match temp=new Match(matchId,format.getOvers(),teamA,teamB,format.getFormatName());
				statement=connection.prepareStatement("select * from match_details where matchNo=?");
				statement.setInt(1, matchId);
				result=statement.executeQuery();
				while(result.next())
				{
					temp.setTeamAScore(Integer.valueOf(result.getString("teamA_score")));
					temp.setTeamBScore(Integer.valueOf(result.getString("teamB_score")));
					String won= result.getString("team_won");
					if(won.equals(temp.getTeamA().getTeam()))
					{
						temp.setWon(teamA);
					}else {
						temp.setWon(teamB);
					}
					String tossWon=result.getString("toss_won");
					if(tossWon.equals(temp.getTeamA().getTeam()))
					{
						temp.setTossWon(teamA);
					}else {
						temp.setTossWon(teamB);
					}
					byte[] teamAIndivualScore=result.getBytes("teamA_indivual");
					temp.getTeamA().setIndivualScore(deserializeMap(teamAIndivualScore));
					byte[] teamBIndivualScore=result.getBytes("teamA_indivual");
					temp.getTeamB().setIndivualScore(deserializeMap(teamBIndivualScore));
				}
				matches.add(temp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		try {
			statement=connection.prepareStatement("Insert into matches (matchNo,teamA,teamB,format,matchStatus) values(?,?,?,?,?)");
			statement.setInt(1, match.getMatchId());
			statement.setString(2, match.getTeamA().getTeam());
			statement.setString(3, match.getTeamB().getTeam());
			statement.setString(4, match.getFormat());
			statement.setString(5, "Started");
			int rowsAffected=statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateMatch(Match match)
	{
		try {
			byte[] teamA=serializeMap(match.getTeamA().getIndivualScore());
			byte[] teamB=serializeMap(match.getTeamB().getIndivualScore());
			statement=connection.prepareStatement("Update matches set matchStatus=? where matchNo=?");
			statement.setInt(2, match.getMatchId());
			statement.setString(1, "Completed");
			int rowsAffected=statement.executeUpdate();
			if(rowsAffected > 0)
			{
				statement=connection.prepareStatement("Insert into match_details (matchNo,teamA_score,teamB_score,team_won,toss_won,teamA_indivual,teamB_indivual) values(?,?,?,?,?,?,?)");
				statement.setInt(1, match.getMatchId());
				statement.setString(2, String.valueOf(match.getTeamAScore()));
				statement.setString(3, String.valueOf(match.getTeamBScore()));
				statement.setString(4, match.getWon().getTeam());
				statement.setString(5, match.getTossWon().getTeam());
				statement.setBytes(6, teamA);
				statement.setBytes(7, teamB);
				rowsAffected=statement.executeUpdate();	
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public static byte[] serializeMap(Map<Integer, Integer> map) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(map);
            return bos.toByteArray();
        }
    }
    
    public static Map<Integer, Integer> deserializeMap(byte[] serializedMap) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(serializedMap);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            return (Map<Integer, Integer>) ois.readObject();
        }
    }
}
