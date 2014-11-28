import java.io.*;

/**
 * <h2>Introduction</h2>
 * <h2>Input</h2>
 * The first line of the input contains one integer T denoting the number of testcases to process.
 * The only line of each testcase contains one string A denoting Mike's parentheses sequence. It is guaranteed that A only consists of the characters '(' and ')'. It is also guaranteed that A is a valid parentheses sequence.
 * <h2>Output</h2>
 * The output should contain exactly T lines, one line per each testcase in the order of their appearance. The only line of each testcase should contain one string B denoting the valid parentheses sequence that should be chosen by Mike to replace A.
 * <h2>Example</h2>
 *
 * @author codeland
 * @version 1.0
 * @see <a href="http://www.codechef.com/COOK52/problems/BRACKETS">Brackets</a>
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
    int size = countBalance(lane);
    StringBuilder sb = new StringBuilder(2 * size);
    for (int i = 0; i < size; i++) {
      sb.append("(");
    }
    for (int i = 0; i < size; i++) {
      sb.append(")");
    }

    return sb.toString();
  }

  private static int countBalance(String sequence)
  {
    int balance = 0;
    int maxBalance = 0;

    for (int i = 0; i < sequence.length(); i++) {
      if (sequence.charAt(i) == '(') {
        balance++;
      }
      else {
        balance--;
      }
      maxBalance = Math.max(maxBalance, balance);
    }

    return maxBalance;
  }

}