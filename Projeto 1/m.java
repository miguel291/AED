import java.io.*;
import java.util.*;

class M{
   public static void main(String[] args) {
    PrintWriter out = new PrintWriter(System.out);
    InputReader in = new InputReader(System.in);
    int n1 = in.nextInt();
    int n2 = in.nextInt();
    int m ;
    int[][] matriz = new int[n1][n2];

    for (int i = 0; i<n1; i++){
      for(int j= 0; j<n2; j++){
        m = in.nextInt();
        matriz[i][j]= m;
      }
    }

    for (int k = 1; k<4; k++){
    out.print(90*k);
    matriz = roda(matriz,n1,n2,0);
    for (int i = 0; i<n2; i++){
      out.println();
      for(int j= 0; j<n1; j++){
        out.print(matriz[i][j]);
        if (j!= n1-1)
            out.print(" ");
        if (i == n2-1 && j==n1-1 && k*90!=270)
          out.println();
      }
    }
    int a = n1;
    n1= n2;
    n2 = a;

  }
    out.close();
}
  static int[][] roda(int matriz[][], int n, int m, int flag){
      int[][] matriz2 = new int[m][n];
      for (int i = 0; i<n; i++){
        for(int j= 0; j<m; j++){
          int l = matriz[i][j];
          matriz2[j][n-i-1]=l;

        }
    }return matriz2;
  }




  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream));
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	try {
	  tokenizer = new StringTokenizer(reader.readLine());
	} catch (IOException e) {
	  throw new RuntimeException(e);
	}
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }
  }
}
