import java.io.*;
import java.util.Arrays;

/**
 * <h2>Introduction</h2>
 * The chef has just finished baking several pies, and it's time to place them on cooling racks.
 * The chef has exactly as many cooling racks as pies. Each cooling rack can only hold one pie, and each pie may only be held by one cooling rack,
 * but the chef isn't confident that the cooling racks can support the weight of the pies.
 * The chef knows the weight of each pie,
 * and has assigned each cooling rack a maximum weight limit.
 * What is the maximum number of pies the chef can cool on the racks?
 * <h2>Input</h2>
 * Input begins with an integer T≤30, the number of test cases.
 * Each test case consists of 3 lines.
 * The first line of each test case contains a positive integer N≤30,
 * the number of pies (and also the number of racks).
 * The second and third lines each contain exactly positive N integers not exceeding 100.
 * The integers on the second line are the weights of the pies, and the integers on the third line
 * are the weight limits of the cooling racks.
 * <h2>Output</h2>
 * For each test case, output on a line the maximum number of pies the chef can place on the racks.
 * <h2>Example</h2>
 * Sample input:
 * 2
 * 3
 * 10 30 20
 * 30 10 20
 * 5
 * 9 7 16 4 8
 * 8 3 14 10 10
 * Sample output:
 * 3
 * 4
 * <h2>Algorithm explanation</h2>
 * Sorting array of racks from low to high, then taking the lowest rack and search for a max weighted pie. If found the pie, disable it by MAX_INT and add 1 to sum.
 *
 * @author codeland
 * @version 1.0
 * @see <a href="http://www.codechef.com/problems/COOLING">Cooling Pies</a>
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

  private static String solve(String lane) throws IOException
  {
    int sum = 0;
    int countPies = Integer.parseInt(lane);
    String[] strPies = in.readLine().split(" ");
    String[] strRacks = in.readLine().split(" ");
    int[] pieWeights = new int[countPies];
    int[] rackWeights = new int[countPies];

    for (int i = 0; i < countPies; i++) {
      pieWeights[i] = Integer.parseInt(strPies[i]);
      rackWeights[i] = Integer.parseInt(strRacks[i]);
    }

    Arrays.sort(rackWeights);

    int max;
    int index;
    for (int i = 0; i < countPies; i++) {
      max = -1;
      index = -1;
      for (int j = 0; j < countPies; j++) {
        if (rackWeights[i] >= pieWeights[j] && pieWeights[j] >= max) {
          max = pieWeights[j];
          index = j;
        }
      }
      if (max != -1 && index != -1) {
        pieWeights[index] = Integer.MAX_VALUE;
        sum++;
      }
    }
    return Integer.toString(sum);
  }

}