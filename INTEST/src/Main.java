import java.io.*;
import java.util.InputMismatchException;

public class Main
{
  public static void main(String[] args) throws IOException, InputMismatchException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line = in.readLine();
    String[] inputs = line.split(" ");
    int n = Integer.parseInt(inputs[0]);
    int k = Integer.parseInt(inputs[1]);

    int divs = 0;
    for (int i = 0; i < n; i++) {
      if ((Integer.parseInt(in.readLine()) % k) == 0) {
        divs++;
      }
    }

    in.close();
    System.out.print(divs);
  }
}
