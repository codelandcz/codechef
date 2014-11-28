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
 * @see <a href="http://www.codechef.com/problems/PERMUT2">Ambiguous Permutations</a>
 */
public class Main
{
  static BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException
  {
    int n = Integer.parseInt(in.readLine());

    while (n != 0) {
      String[] inputs = in.readLine().split(" ");
      int[] permutation = new int[n];

      for (int i = 0; i < n; i++) {
        permutation[i] = Integer.parseInt(inputs[i]);
      }

      for (int i = 0; i < n; i++) {
        if (permutation[permutation[i] - 1] != i + 1) {
          out.write("not ");
          break;
        }
      }

      out.write("ambiguous");
      out.newLine();

      n = Integer.parseInt(in.readLine());
    }

    out.close();
  }
}
