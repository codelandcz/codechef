import java.io.*;

/**
 * <h2>Introduction</h2>
 * Alice and Bob play the following game. They choose a number N to play with. The rules are as follows :
 * 1) Alice plays first, and the two players alternate.
 * 2) In his/her turn, a player can subtract from N any proper divisor (not equal to N) of N. The number thus obtained is the new N.
 * 3) The person who cannot make a move in his/her turn loses the game.
 * Assuming both play optimally, who wins the game ?
 * Note : For the first test case, Alice cannot make any move and hence Bob wins the game. For the second test case, Alice subtracts 1 from N. Now, Bob cannot make a move and loses the game.
 * <h2>Input</h2>
 * The first line contains the number of test cases T. Each of the next T lines contains an integer N.
 * <h2>Output</h2>
 * Output T lines, one for each test case, containing "ALICE" if Alice wins the game, or "BOB" otherwise.
 * <h2>Example</h2>
 * Sample Input :
 * 2
 * 1
 * 2
 * Sample Output :
 * BOB
 * ALICE
 * Constraints :
 * 1 <= T <= 10000
 * 1 <= N <= 1000000000
 *
 * @author codeland
 * @version 1.0
 * @see <a href='http://www.codechef.com/problems/ONP'>Yet Another Number Game</a>
 */
public class Main
{
  static BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

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
    boolean winnerAlice = true;

    if (Integer.parseInt(lane) % 2 == 1) winnerAlice = !winnerAlice;

    return (winnerAlice) ? "ALICE" : "BOB";
  }

}

//remember that every player WILL play optimally 1.we know that if any player gets 1,he/she loses 2.if any player gets 2,he/she will subtract 1 and hence win 3.if any player gets 3,he/she has no choice but to subtract 1 and hence will lose. 4.i a player gets 4,he/she will subtract 1 and win(optimal choice) Hence if a player gets even number,he/she wins and loses if he/she gets an odd number Hence if N is even,Alice wins otherwise Bob wins
//If a player has an odd number, they CAN'T make another odd number by any move. That would require an even divisor. They can only make even numbers for the other player. If a player has an even number, they can always make an odd number for the other player by subtracting 1. Given that 1 is odd and always a losing number, the player that gets the first odd number will be "locked in" for the rest of the round, as long as the other player "plays optimally" and ensures they stay there for the rest of the round.
//Both wants to have an even number to play with and would make the number odd for the opponent.. N could be odd or even, ket it be odd say 25..factors would always be odd(1,3,5 in this case) after subtracting an even is obtained so the other player gets an even number(24 or 22 or 20) he would have various factors in all cases(1,2,4,6,12 factors or 1,2,11 or 1,4,5,10,20) he would make an "optimal" subtraction..(here optimal means making number odd) which he would do by an odd number.
// Vysledek u 8->7, BOB nema jinou sanci nez hrat -1
/*
8
 4
  210
  3210
 6
  3210
  4
   210
   3210
  54
    210
    3210
 7
  6
   3210
   4
    210
    3210
   54
     210
     3210
ababababa
*/