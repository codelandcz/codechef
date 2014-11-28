import java.io.*;

public class Main
{
  public static void main(String[] args) throws IOException, NumberFormatException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    String line;
    while ((line = in.readLine()) != null) {
      if (Integer.parseInt(line) == 42) break;
      out.write(line);
      out.newLine();
    }
    out.flush();
    in.close();
    out.close();
  }
}
