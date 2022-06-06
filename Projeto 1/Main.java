import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) {
    InputReader in = new InputReader(System.in);
    PrintWriter out = new PrintWriter(System.out);

    int n1 = in.nextInt();
    int n2 = in.nextInt();
    int m ;
    int[][] matriz = new int[n2][n1];
    out.print(90);
    for (int i = 0; i<n1; i++){
      for(int j= 0; j<n2; j++){
        m = in.nextInt();
        matriz[j][n1-i-1]= m;
      }
    }
    int[][] matriz180 = new int[n1][n2];
    for (int i = 0; i<n2; i++){
      out.println();
      for(int j= 0; j<n1; j++){
        m = matriz[i][j];
        out.print(m );
        if (j!=n1-1)
          out.print(" ");
        matriz180[j][n2-i-1]=m;
      }
    }
    int[][] matriz270 = new int[n2][n1];
    out.println();
    out.print(180);
    for (int i = 0; i<n1; i++){
      out.println();
      for(int j= 0; j<n2; j++){
        m = matriz180[i][j];
        out.print(m);
        if (j!=n2-1)
          out.print(" ");
        matriz270[j][n1-i-1]=m;
      }
    }
    out.println();
    out.print(270);
    for (int i = 0; i<n2; i++){
      out.println();
      for(int j= 0; j<n1; j++){
        m = matriz270[i][j];
        out.print(m );
        if (j!=n1-1)
          out.print(" ");
      }
    }

    out.close();
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
