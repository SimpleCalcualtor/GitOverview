package the2021.jCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Keyboard {

    private List<String> listContainsExpression = new LinkedList<>();

    public void insertExpression() throws IOException {
        System.out.println("Insert an expression: ");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String expressionContainer = in.readLine();
        castExpressionIntoList(expressionContainer);
    }

    public void castExpressionIntoList(String expressionContainer) throws IOException {
        listContainsExpression.addAll(Arrays.asList(expressionContainer.split("")));
        checkIfExpressionIsRight();
    }

    public void checkIfExpressionIsRight() throws IOException {
        for (String value: listContainsExpression) {
            if (value.equals("+") || value.equals("-") || value.equals("/") ||
                value.equals("*") || value.equals("(") || value.equals(")")) {
                continue;
            }
            try {
                Integer.valueOf(value);
            }catch (NumberFormatException ex) {
                System.out.println("Expression is incorrect, try again");
                listContainsExpression.clear();
                insertExpression();
                System.exit(0);
            }
         }
        checkIfBracketsIsRight();
    }

    public void checkIfBracketsIsRight() throws IOException {
    List<String> copyListOfExpression = new LinkedList<>(listContainsExpression);
    Collections.copy(listContainsExpression, copyListOfExpression);

        for (int closeBracket =0; closeBracket < copyListOfExpression.size(); closeBracket++) {
            if (copyListOfExpression.get(closeBracket).equals(")")) {
                for (int openBracket = closeBracket; openBracket >=0; openBracket--) {
                    if (copyListOfExpression.get(openBracket).equals("("))
                    {
                        copyListOfExpression.set(closeBracket, " ");
                        copyListOfExpression.set(openBracket, " ");
                    }
                }
            }
        }

        for (String checkSingleBracket: copyListOfExpression) {
            if (checkSingleBracket.equals("(")|| checkSingleBracket.equals(")")) {
                System.out.println("Expression is incorrect, try again");
                listContainsExpression.clear();
                insertExpression();
                System.exit(0);
            }
        }
        new PrepareList(listContainsExpression);
    }
}
