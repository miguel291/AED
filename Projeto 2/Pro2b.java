import java.io.*;
import java.util.*;
import java.util.Arrays;

class Pro2b{
   public static void main(String[] args) {
    PrintWriter out = new PrintWriter(System.out);
    InputReader in = new InputReader(System.in);
    int len = in.nextInt();
    int[] matriz = new int[len];
    int maiorSoma=0;
    for (int i = 0; i<len; i++){
      matriz[i]=in.nextInt();
    }

    Arrays.sort(matriz);
    maiorSoma = matriz[len-1]+matriz[len-2];


    out.print(maiorSoma+"\n");
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
