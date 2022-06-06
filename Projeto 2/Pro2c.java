import java.io.*;
import java.util.*;

class Pro2c{
   public static void main(String[] args) {
    PrintWriter out = new PrintWriter(System.out);
    InputReader in = new InputReader(System.in);
    int len = in.nextInt();
    int[] matriz = new int[len];
    int maiorSoma=0;
    for (int i = 0; i<len; i++){
      matriz[i]=in.nextInt();
    }
    int m = -1;
    int n = -1;

    for (int i = 0; i<len; i++){
      if(matriz[i]> m){
        if(m > n) 
          n = m;
        m = matriz[i];
      }
      else if (matriz[i]>n){
        n = matriz[i];
      }
    }

    out.print(m+n+"\n");
    out.print(m+ "\n");
    out.print(n+ "\n");
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
