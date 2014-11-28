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
 * @see <a href="http://www.codechef.com/problems/PRPALIN">Prime Palindromes</a>
 */
public class Main
{
  static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException
  {
    String line = in.readLine();

    out.write(solve(line));
    out.newLine();

    out.close();
  }

  private static String solve(String line)
  {
    long result;

    long num = Long.parseLong(line);

    while (true) {
      if (num > 98689) return "1003001";
      else if (isPalindrome(Long.toString(num)) && isPrime(num)) {
        result = num;
        break;
      }
      num++;
    }

    return Long.toString(result);
  }

  private static boolean isPalindrome(String x)
  {
    return new StringBuilder(x).reverse().toString().equals(x);
  }

  private static boolean isPrime(long x)
  {
    if (x % 2 == 0) return false;
    for (int i = 3; i * i <= x; i += 2) {
      if (x % i == 0)
        return false;
    }
    return true;
  }
}