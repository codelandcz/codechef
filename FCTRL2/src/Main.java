import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BigInteger num, factorial = null;
    int x, N = Integer.parseInt(in.readLine());

    for (int i = 0; i < N; i++) {
      num = new BigInteger("1");
      factorial = new BigInteger("1");
      x = Integer.parseInt(in.readLine());
      for (int j = 0; j < x; j++) {
        factorial = factorial.multiply(num);
        num = num.add(BigInteger.ONE);
      }
      System.out.println(factorial);
    }

    in.close();
  }
}