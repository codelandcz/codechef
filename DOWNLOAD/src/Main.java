import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

//TODO Unresolved
public class Main
{
  public static void main(String[] args) throws IOException, InputMismatchException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<Recipe> recipes = readRecipes(in);
    ArrayList<Group> groups = readGroups(in);
    WatchResolver resolver = new WatchResolver(recipes, groups);

    resolver.resolve();

    in.close();
  }

  private static ArrayList<Group> readGroups(BufferedReader in) throws IOException
  {
    int Q = Integer.parseInt(in.readLine());
    ArrayList<Group> groups = new ArrayList<Group>(Q);
    for (int i = 0; i < Q; i++) {
      groups.add(new Group(in.readLine().split(" ")));
    }

    return groups;
  }

  private static ArrayList<Recipe> readRecipes(BufferedReader in) throws IOException
  {
    int N = Integer.parseInt(in.readLine());
    ArrayList<Recipe> recipes = new ArrayList<Recipe>(N);
    for (int i = 0; i < N; i++) {
      recipes.add(new Recipe(in.readLine().split(" ")));
    }

    return recipes;
  }
}

class WatchResolver
{
  private final ArrayList<Recipe> recipes;
  private final ArrayList<Group>  groups;

  public WatchResolver(ArrayList<Recipe> recipes, ArrayList<Group> groups)
  {
    this.recipes = recipes;
    this.groups = groups;
  }

  public void resolve()
  {
    int[][] watched = new int[groups.size()][recipes.size()];
    for (int[] w : watched) {
      Arrays.fill(w, 0);
    }

    int i = 0, j = 0, k = 0, l = 0;
    for (Group group : groups) {
      j = 0;
      for (Recipe recipe : recipes) {
        for (Alien alien : group.aliens) {
          if (alien.visTime >= recipe.startTime && alien.visTime <= recipe.endTime) {
            watched[i][j] = 1;
          }
        }

        j++;
      }
      i++;
    }

    for (k = 0; k < watched.length; k++) {
      int result = 0;
      for (l = 0; l < watched[0].length; l++) {
        result += watched[k][l];
      }
      System.out.println(result);
    }
  }
}

class Alien
{
  public int visTime;

  Alien(int visTime)
  {
    this.visTime = visTime;
  }
}

class Group
{
  public ArrayList<Alien> aliens;

  Group(String[] aliens)
  {
    int l = Integer.parseInt(aliens[0]);
    this.aliens = new ArrayList<Alien>(l);

    for (int i = 1; i <= l; i++) {
      this.aliens.add(new Alien(Integer.parseInt(aliens[i])));
    }
  }
}

class Recipe
{
  public int startTime;
  public int endTime;

  Recipe(String[] lane)
  {
    this(Integer.parseInt(lane[0]), Integer.parseInt(lane[1]));
  }

  Recipe(int startTime, int endTime)
  {
    this.startTime = startTime;
    this.endTime = endTime;
  }
}
