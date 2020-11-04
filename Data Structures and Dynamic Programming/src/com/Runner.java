package com;

public class Runner {
	
	public static void main(String args[]) {
		String[] values = new String[2];
		values[0] = "horseback";
		values[1] = "snowflake";
		LongestCommonSubsequence lc = new LongestCommonSubsequence(values[0], values[1]);
		lc.printLCS();
	}

}
