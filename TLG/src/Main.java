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
 * @see <a href="http://www.codechef.com/problems/TLG">The Lead Game</a>
 */
public class Main
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(in.readLine());

    int i, x1 = 0, x2 = 0;
    int tmp, max = 0, winner = 0;

    for (i = 0; i < N; i++) {
      String[] line = in.readLine().split(" ");
      x1 += Integer.parseInt(line[0]);
      x2 += Integer.parseInt(line[1]);

      tmp = Math.abs(x1 - x2);
      if (tmp > max) {
        max = tmp;
        if (x1 > x2) winner = 1;
        else winner = 2;
      }

    }

    System.out.println(winner + " " + max);
  }
}
