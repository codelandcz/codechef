import java.io.*;

public class Main
{
  static BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException
  {
    int N = Integer.parseInt(in.readLine());
    int[] results = new int[N];

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(in.readLine());
      if ((num & 1) == 0) {
        results[i] = num;
      }
      else {
        results[i] = --num;
      }
    }

    for (int i : results) {
      out.write(Integer.toString(i));
      out.newLine();
    }
    out.close();
  }
}
