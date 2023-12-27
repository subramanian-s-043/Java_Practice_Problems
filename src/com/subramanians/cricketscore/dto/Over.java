package com.subramanians.cricketscore.dto;

import java.util.Map;

public class Over {
	Map<Integer,String> ballAndBatsmanFaced;
	Map<Integer,Integer> eachBallScore;
	String bowler;
	public Over(Map<Integer,String> balls,Map<Integer,Integer> batsman,String bowler) {
		this.ballAndBatsmanFaced=balls;
		this.eachBallScore=batsman;
		this.bowler=bowler;
	}
}
