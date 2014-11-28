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
 * @see <a href="http://www.codechef.com/problems/SUMTRIAN">Sums in a Triangle</a>
 */
public class Main
{
  static BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException
  {
    int N = Integer.parseInt(in.readLine());
    int[] sums = new int[N];

    for (int i = 0; i < N; i++) sums[i] = resolveTriangle();

    for (int i : sums) {
      out.write(Integer.toString(i));
      out.newLine();
    }
    out.close();
  }

  private static int resolveTriangle() throws IOException
  {
    int rows = Integer.parseInt(in.readLine());
    int[][] triangle = new int[rows][rows];
    String[] line;

    //read triangle
    for (int i = 0; i < rows; i++) {
      line = in.readLine().split(" ");
      for (int j = 0; j < i + 1; j++) {
        triangle[i][j] = Integer.parseInt(line[j]);
      }
    }

    //count sum
    for (int i = rows - 1; i > 0; i--) {
      for (int j = 0; j < rows - 1; j++) {
        triangle[i - 1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);
      }
    }

    return triangle[0][0];
  }
}
