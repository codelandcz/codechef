import java.io.*;

/**
 * <h2>Introduction</h2>
 * <h2>Input</h2>
 * <h2>Output</h2>
 * <h2>Example</h2>
 *
 * @author codeland
 * @version 1.0
 * @see <a href="http://www.codechef.com/problems/AND">Pairwise AND sum</a>
 */
public class Main
{
  static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException
  {
    int N = Integer.parseInt(in.readLine());

    String[] lane = in.readLine().split(" ");
    int[] nums = new int[N];
    int[] odds = new int[N];
    int countOdds = 0;
    for (int i = N - 1; i >= 0; i--) {
      nums[i] = Integer.parseInt(lane[i]);
      odds[i] = countOdds;
      if (nums[i] % 2 == 1) countOdds++;
    }

    out.write(solve(nums, odds));
    out.newLine();

    out.close();
  }

  private static String solve(int[] nums, int[] odds)
  {

    //TODO Make it faster
    long sum = 0L;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == 0) break;
        else if (nums[i] == 1) {
          sum += odds[i];
          break;
        }
        sum += (nums[i] & nums[j]);
      }
    }

    return Long.toString(sum);
  }
}