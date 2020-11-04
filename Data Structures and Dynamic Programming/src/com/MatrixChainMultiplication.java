package com;

/* A naive recursive implementation that simply follows 
   the above optimal substructure property */
class MatrixChainMultiplication { 
    // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n 
    static  int MatrixChainOrder(int p[], int n) 
    { 
        /* For simplicity of the program, one extra row and one 
        extra column are allocated in m[][].  0th row and 0th 
        column of m[][] are not used */
        int m[][] = new int[n][n]; 
  
        int i, j, k, L, q; 
  
        /* m[i, j] = Minimum number of scalar multiplications needed 
        to compute the matrix A[i]A[i+1]...A[j] = A[i..j] where 
        dimension of A[i] is p[i-1] x p[i] */
  
        // cost is zero when multiplying one matrix. 
        for (i = 1; i < n; i++) 
            m[i][i] = 0; 
  
        // L is chain length. 
        for (L = 2; L < n; L++) { 
            for (i = 1; i < n - L + 1; i++) { 
                j = i + L - 1; 
                if (j == n) 
                    continue; 
                m[i][j] = Integer.MAX_VALUE; 
                for (k = i; k <= j - 1; k++) { 
                    // q = cost/scalar multiplications 
                    q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j]; 
                    if (q < m[i][j]) 
                        m[i][j] = q; 
                } 
            } 
        } 
  
        return m[1][n - 1]; 
    } 
  
  
    // Driver program to test above function 
    public static void main(String args[]) 
    { 
    	//30x35, 35x15, 15x5, 5x10, 10x20, 20x25
        //int arr[] = new int[] { 30, 35, 15, 5, 10, 20, 25};
    	//5x10, 10x3, 3x12, 12x5
    	int arr[] = new int[] { 5, 10, 3, 12, 5}; 
        int n = arr.length; 
  
        System.out.println("Minimum number of multiplications is " 
                + MatrixChainOrder(arr, n));  
    } 
} 
/* This code is contributed by Rajat Mishra*/
