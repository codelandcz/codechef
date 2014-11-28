import java.io.*;

public class Main
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(in.readLine());

    int[] ints = new int[10000001]; // N [0 <= N <= 10^6]
    int x, i;

    for (i = 0; i < N; i++) {
      x = Integer.parseInt(in.readLine());
      ints[x]++;
    }

    x = 0;
    for (i = 0; i < ints.length && x < N; i++) {
      while (ints[i]-- > 0) {
        x++;
        out.write(Integer.toString(i));
        out.newLine();
      }
    }

    out.flush();
  }
}