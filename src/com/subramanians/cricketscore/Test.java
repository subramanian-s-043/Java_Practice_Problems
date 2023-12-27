package com.subramanians.cricketscore;

import java.util.Arrays;
import java.util.List;

import com.subramanians.cricketscore.dto.Formats;

public class Test {
	  public static void main(String[] args) {
	        String[][] players = {
	                {"Player1", "Forward", "2022-01-01"},
	                {"Player2", "Midfielder", "2022-01-02"},
	                // ... (add more players)
	        };

	        String team = "Sample Team";

	        // Invoke the printTable method
	        printTable(players, team);
	    }

	    public static void printTable(String[][] data, String team) {
	        int teamWidth = team.length();
	        int playerNameWidth = 15;
	        int playerRoleWidth = 15;
	        int inAtWidth = 15;

	        // Print the top border and header
	        System.out.println("+" + "-".repeat(teamWidth + playerNameWidth + playerRoleWidth + inAtWidth + 8) + "+");
	        System.out.println("| " + team + " Players |");
	        System.out.println("+" + "-".repeat(teamWidth + playerNameWidth + playerRoleWidth + inAtWidth + 8) + "+");
	        System.out.println("| " +
	                padString("Player Name", playerNameWidth) + " | " +
	                padString("Player Role", playerRoleWidth) + " | " +
	                padString("In At", inAtWidth) + " |"
	        );

	        for (int i = 0; i < data.length; i++) {
	            System.out.println("+" + "-".repeat(teamWidth + playerNameWidth + playerRoleWidth + inAtWidth + 8) + "+");
	            System.out.println("| " +
	                    padString(data[i][0], playerNameWidth) + " | " +
	                    padString(data[i][1], playerRoleWidth) + " | " +
	                    padString(data[i][2], inAtWidth) + " |"
	            );
	        }

	        // Print the bottom border of the box
	        System.out.println("+" + "-".repeat(teamWidth + playerNameWidth + playerRoleWidth + inAtWidth + 8) + "+");
	    }

	    private static String padString(String input, int width) {
	        return String.format("%-" + width + "s", input);
	    }
}
