import java.io.*;

/**
 * <h2>Introduction</h2>
 * <h2>Input</h2>
 * <h2>Output</h2>
 * <h2>Example</h2>
 * <h2>Algorithm explanation</h2>
 *
 * @author codelandcz
 * @version 1.0
 * @see <a href="http://www.codechef.com/problems/CIELRCPT">Ciel and Receipt</a>
 */
public class Main
{
  static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException
  {
    int N = Integer.parseInt(in.readLine());

    for (int i = 0; i < N; i++) {
      out.write(solve(in.readLine()));
      out.newLine();
    }

    out.close();
  }

  private static String solve(String line)
  {
    int[] offer = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048};
    StringBuilder sb = new StringBuilder();
    int x = Integer.parseInt(line);
    int count;
    int sum = 0;
    for (int i = offer.length - 1; i >= 0; i--) {
      count = x / offer[i];
      if (count > 0) {
        x %= offer[i];
        sum += count;
      }
    }
    sb.append(sum);

    return sb.toString();
  }
}