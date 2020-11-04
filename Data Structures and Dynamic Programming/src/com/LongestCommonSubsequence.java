package com;

public class LongestCommonSubsequence {

	private char[] x;
	private char[] y;

	/**
	 * Build an instance of a string x and y to find the least common sequence
	 * 
	 * @param args x, y
	 */
	public LongestCommonSubsequence(String x, String y) {

		try {
			this.x = x.toCharArray();
			this.y = y.toCharArray();
			System.out.println("X:" + this.getX() + " Length:" + this.x.length);
			System.out.println("Y:" + this.getY() + " Length:" + this.y.length);
		} catch (

		ArrayIndexOutOfBoundsException e) {
			System.err.print("Please enter: -xstring -ystring as the command");
		}
	}

	public int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public String reverse(char[] lcs) {
		String result;
		char[] temp = new char[lcs.length];
		for (int i = lcs.length - 1; i > 0; i--) {
			lcs[i] = temp[lcs.length - i];
		}
		result = String.valueOf(temp);
		return result;
	}
	
	public void printLCS() 
    { 
		int m = x.length;
		int n = y.length;
        int[][] L = new int[m+1][n+1]; // we are using this storage space to save some time having to valcula
   
        // Following steps build L[m+1][n+1] in bottom up fashion. Note 
        // that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]  
        for (int i=0; i<=m; i++) 
        { 
            for (int j=0; j<=n; j++) 
            { 
                if (i == 0 || j == 0) 
                    L[i][j] = 0; 
                else if (x[i-1] == y[j-1]) 
                    L[i][j] = L[i-1][j-1] + 1; 
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]); 
            } 
        } 
   
        // Following code is used to print LCS 
        int index = L[m][n]; 
        int temp = index; 
   
        // Create a character array to store the lcs string 
        char[] lcs = new char[index+1]; 
        lcs[index] = '\u0000'; // Set the terminating character 
   
        // Start from the right-most-bottom-most corner and 
        // one by one store characters in lcs[] 
        int i = m; 
        int j = n; 
        while (i > 0 && j > 0) 
        { 
            // If current character in X[] and Y are same, then 
            // current character is part of LCS 
            if (x[i-1] == y[j-1]) 
            { 
                // Put current character in result 
                lcs[index-1] = x[i-1];  
                  
                // reduce values of i, j and index 
                i--;  
                j--;  
                index--;      
            } 
   
            // If not same, then find the larger of two and 
            // go in the direction of larger value 
            else if (L[i-1][j] > L[i][j-1]) 
                i--; 
            else
                j--; 
        } 
   
        // Print the lcs 
        System.out.print("LCS of "+String.valueOf(x)+" and "+String.valueOf(y)+" is "); 
        for(int k=0;k<=temp;k++) 
            System.out.print(lcs[k]); 
    } 

	public String getX() {
		return String.copyValueOf(x);
	}

	public String getY() {
		return String.copyValueOf(y);
	}

}
