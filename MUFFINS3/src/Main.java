import java.io.*;

/**
 * <h2>Introduction</h2>
 * Now that Chef has finished baking and frosting his cupcakes, it's time to package them. Chef has N cupcakes, and needs to decide how many cupcakes to place in each package. Each package must contain the same number of cupcakes. Chef will choose an integer A between 1 and N, inclusive, and place exactly A cupcakes into each package. Chef makes as many packages as possible. Chef then gets to eat the remaining cupcakes. Chef enjoys eating cupcakes very much. Help Chef choose the package size A that will let him eat as many cupcakes as possible.
 * <h2>Input</h2>
 * Input begins with an integer T, the number of test cases. Each test case consists of a single integer N, the number of cupcakes.
 * <h2>Output</h2>
 * For each test case, output the package size that will maximize the number of leftover cupcakes. If multiple package sizes will result in the same number of leftover cupcakes, print the largest such size.
 * <h2>Example</h2>
 * Constraints
 * 1 ≤ T ≤ 1000
 * 2 ≤ N ≤ 100000000 (108)
 * Sample Input
 * 2
 * 2
 * 5
 * Sample Output
 * 2
 * 3
 * <h2>Algorithm explanation</h2>
 * For maximize the leftovers we need only one biggest package ("If multiple package sizes will result in the same number of leftover cupcakes, print the largest such size.").
 * That can be achieved by store half of the cupcakes + minimum to avoid 2 packages. Here is the minimum one cupcake.
 *
 * @author codeland
 * @version 1.1
 * @see <a href="http://www.codechef.com/problems/MUFFINS3">Packaging Cupcakes</a>
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

  private static String solve(String lane)
  {
    int x = Integer.parseInt(lane);
    return Integer.toString((x >> 1) + 1);
  }
}