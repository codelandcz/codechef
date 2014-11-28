import java.io.*;

/**
 * <h2>Introduction</h2>
 * In Ciel's restaurant, a waiter is training.
 * Since the waiter isn't good at arithmetic, sometimes he gives guests wrong change.
 * Ciel gives him a simple problem.
 * What is A-B (A minus B) ?
 * Surprisingly, his answer is wrong.
 * To be more precise, his answer has exactly one wrong digit.
 * Can you imagine this?
 * Can you make the same mistake in this problem?
 * <h2>Input</h2>
 * An input contains 2 integers A and B.
 * <h2>Output</h2>
 * Print a wrong answer of A-B.
 * Your answer must be a positive integer containing the same number of digits as the correct answer, and exactly one digit must differ from the correct answer.
 * Leading zeros are not allowed.
 * If there are multiple answers satisfying the above conditions, anyone will do.
 * <h2>Example</h2>
 * Constraints
 * 1 ≤ B < A ≤ 10000
 * Sample Input
 * 5858 1234
 * Sample Output
 * 1624
 * <h2>Algorithm explanation</h2>
 * Output details
 * The correct answer of 5858-1234 is 4624.
 * So, for instance, 2624, 4324, 4623, 4604 and 4629 will be accepted, but 0624, 624, 5858, 4624 and 04624 will be rejected.
 *
 * @author codeland
 * @version 1.0
 * @see <a href="http://www.codechef.com/problems/CIELAB">Ciel and A-B Problem</a>
 */
public class Main
{
  static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException
  {
    out.write(solve(in.readLine().split(" ")));
    out.newLine();

    out.close();
  }

  private static String solve(String[] lane) throws IOException
  {
    int x = Integer.parseInt(lane[0]) - Integer.parseInt(lane[1]);
    if (x == 1) return "2";
    if (x % 2 == 0) x++;
    else x--;

    return Integer.toString(x);
  }
}