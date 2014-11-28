import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Main
{
  public static void main(String[] args) throws IOException, InputMismatchException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int numHoles, n = Integer.parseInt(in.readLine());
    String line;
    HashMap<Integer, Integer> holesMap = new HashMap<Integer, Integer>();
    holesMap.put((int) 'Q', 1);
    holesMap.put((int) 'R', 1);
    holesMap.put((int) 'O', 1);
    holesMap.put((int) 'P', 1);
    holesMap.put((int) 'A', 1);
    holesMap.put((int) 'D', 1);
    holesMap.put((int) 'B', 2);

    while (n-- > 0) {
      numHoles = 0;
      line = in.readLine();
      for (int i = 0; i < line.length(); i++) {
        try {
          numHoles += holesMap.get((int) line.charAt(i));
        } catch (Exception e) {
        }
      }
      System.out.println(numHoles);
    }

    in.close();
  }
}
