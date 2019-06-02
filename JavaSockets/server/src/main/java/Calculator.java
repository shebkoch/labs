import java.util.Stack;

public class Calculator {
    static private boolean IsDelimeter(char c) {
        return (" =".indexOf(c) != -1);
    }
    static private boolean IsOperator(char с)
    {
        return ("+-/*^()".indexOf(с) != -1);
    }
    static private byte GetPriority(char s)
    {
        switch (s)
        {
            case '(': return 0;
            case ')': return 0;
            case '+': return 1;
            case '-': return 1;
            case '*': return 2;
            case '/': return 2;
            default: return 3;
        }
    }
    static public Double Calculate(String input)
    {
        String output = GetExpression(input);
        double result = Counting(output);
        return result;
    }
    static private String GetExpression(String input)
    {
        StringBuilder buffer = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '-' && (i == 0 || input.charAt(i-1) == '(')) {
                buffer.insert(i,'0');
            }
        }
        input = buffer.toString();
        StringBuilder output = new StringBuilder();
        Stack<Character> operStack = new Stack<>();

        for (int i = 0; i < input.length(); i++)
        {
            if (IsDelimeter(input.charAt(i)))
                continue;

            if (Character.isDigit(input.charAt(i)))
            {
                while (!IsDelimeter(input.charAt(i)) && !IsOperator(input.charAt(i)))
                {
                    output.append(input.charAt(i));
                    i++;
                    if (i == input.length()) break;
                }

                output.append(" ");
                i--;
            }
            if (IsOperator(input.charAt(i)))
            {
                if (input.charAt(i) == '(')
                    operStack.push(input.charAt(i));
                else if (input.charAt(i) == ')')
                {
                    char s = operStack.pop();

                    while (s != '(')
                    {
                        output.append(s).append(" ");
                        s = operStack.pop();
                    }
                }
                else
                {
                    if (!operStack.empty())
                        if (GetPriority(input.charAt(i)) <= GetPriority(operStack.peek()))
                            output.append(operStack.pop().toString()).append(" ");
                    operStack.push(input.charAt(i));
                }
            }
        }

        while (!operStack.empty())
            output.append(operStack.pop()).append(" ");

        return output.toString();
    }
    static private double Counting(String input)
    {
        double result = 0;
        Stack<Double> temp = new Stack<>();

        for (int i = 0; i < input.length(); i++)
        {
            if (Character.isDigit(input.charAt(i)))
            {
                StringBuilder a = new StringBuilder();

                while (!IsDelimeter(input.charAt(i)) && !IsOperator(input.charAt(i)))
                {
                    a.append(input.charAt(i));
                    i++;
                    if (i == input.length()) break;
                }
                temp.push(Double.parseDouble(a.toString()));
                i--;
            }
            else if (IsOperator(input.charAt(i)))
            {
                double a = temp.pop();
                double b = temp.pop();

                switch (input.charAt(i))
                {
                    case '+': result = b + a; break;
                    case '-': result = b - a; break;
                    case '*': result = b * a; break;
                    case '/': result = b / a; break;
                }
                temp.push(result);
            }
        }
        return temp.peek();
    }
}
