import java.io.*;
import java.util.Stack;

/**
 * <h1>ONP</h1>
 * <h2>Introduction</h2>
 * Reverse Polish Notation (RPN) is a mathematical notation where every operator follows all of its operands. For instance, to add three and four, one would write "3 4 +" rather than "3 + 4". If there are multiple operations, the operator is given immediately after its second operand; so the expression written "3 - 4 + 5" would be written "3 4 - 5 +" first subtract 4 from 3, then add 5 to that.
 * Transform the algebraic expression with brackets into RPN form.
 * You can assume that for the test cases below only single letters will be used, brackets [] will not be used and each expression has only one RPN form (no expressions like a*b*c)
 * <h2>Input</h2>
 * The first line contains t, the number of test cases (less then 100).
 * Followed by t lines, containing an expression to be translated to RPN form, where the length of the expression is less then 400.
 * <h2>Output</h2>
 * The expressions in RPN form, one per line.
 * Input:
 * 3
 * (a+(b*c))
 * ((a+b)*(z+x))
 * ((a+t)*((b+(a+c))^(c+d)))
 * Output:
 * abc*+
 * ab+zx+*
 * at+bac++cd+^* *
 *
 * @author codeland
 * @version 1.0
 * @see <a href='http://www.codechef.com/problems/ONP'>Transform the Expression</a>
 */
public class Main
{
  static BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException
  {
    int N = Integer.parseInt(in.readLine());

    for (int i = 0; i < N; i++) {
      String lane = in.readLine();
      String rpn = parseInput(lane);
      out.write(rpn);
      out.newLine();
    }

    out.close();
  }

  /**
   * @param expression String
   *
   * @return String Translate into RPN
   */
  private static String parseInput(String expression)
  {
    char x;
    StringBuilder rpn = new StringBuilder(expression.length());
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < expression.length(); i++) {
      x = expression.charAt(i);
      switch (x) {
        case '(':
          stack.push(x);
          break;
        case ')':
          while (stack.peek() != '(') {
            rpn.append(stack.pop());
          }
          stack.pop();
          break;
        case '+':
        case '-':
        case '*':
        case '/':
        case '^':
          if (stack.peek() != '(') {
            rpn.append(stack.pop());
          }
          stack.push(x);
          break;
        default:
          rpn.append(x);
          break;
      }
    }

    return rpn.toString();
  }
}
