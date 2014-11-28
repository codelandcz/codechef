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
 * @see <a href=""></a>
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

  // T - # of use cases, N - # of A, A[i] - element
  // 1 <= T <= 100, 1 <= N <= 100 and for all i in [1..N] : 1 <= A[i] <= 10000
  private static String solve(String line) throws IOException
  {
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(line);
    String[] strX = in.readLine().split(" ");
    int[] occurencies = new int[10001];
    for (int i = 0; i < n; i++) {
      occurencies[Integer.parseInt(strX[i])]++;
    }

    int minValue = Integer.MAX_VALUE;
    int minOccurs = Integer.MIN_VALUE;
    for (int i = 10001 - 1; i >= 1; i--) {
      if (minValue > i && occurencies[i] >= minOccurs) {
        minOccurs = occurencies[i];
        minValue = i;
      }
    }

    sb.append(minValue);
    sb.append(" ");
    sb.append(minOccurs);
    return sb.toString();
  }
}