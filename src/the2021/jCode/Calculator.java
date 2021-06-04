package the2021.jCode;

import java.util.List;

public class Calculator {

    private List<String> listForEvaluation;

    Calculator(List<String> prepareListWhichContainsExpression) {
        this.listForEvaluation = prepareListWhichContainsExpression;
        doCalculation();
    }

    public void doCalculation() {

        for (int firstCycleValue = 0; firstCycleValue < listForEvaluation.size(); firstCycleValue ++ ) {
            if (listForEvaluation.get(firstCycleValue).equals("*")){
                prepareExpressionForEvaluation(listForEvaluation.indexOf(listForEvaluation.get(firstCycleValue)),
                        listForEvaluation.get(firstCycleValue));
                firstCycleValue--;
            }
            if (listForEvaluation.get(firstCycleValue).equals("/")) {
                prepareExpressionForEvaluation(listForEvaluation.indexOf(listForEvaluation.get(firstCycleValue)),
                        listForEvaluation.get(firstCycleValue));
                firstCycleValue--;
            }
        }

        for (int secondCycleValue = 0; secondCycleValue < listForEvaluation.size(); secondCycleValue++) {
            if (listForEvaluation.get(secondCycleValue).equals("+")){
                prepareExpressionForEvaluation(listForEvaluation.indexOf(listForEvaluation.get(secondCycleValue)),
                        listForEvaluation.get(secondCycleValue));
                secondCycleValue--;
            }
            if (listForEvaluation.get(secondCycleValue).equals("-")){
                prepareExpressionForEvaluation(listForEvaluation.indexOf(listForEvaluation.get(secondCycleValue)),
                        listForEvaluation.get(secondCycleValue));
                secondCycleValue--;
            }
        }
        System.out.println("Result: " + listForEvaluation);
    }

    public List<String> prepareExpressionForEvaluation(int indexOfSign, String getSign) {

        int valueBeforeIndex = Integer.parseInt(listForEvaluation.get(indexOfSign - 1));
        int valueAfterIndex = Integer.parseInt(listForEvaluation.get(indexOfSign + 1));

        int result = evaluation(getSign, valueBeforeIndex, valueAfterIndex);

        listForEvaluation.set(indexOfSign +1, String.valueOf(result));
        listForEvaluation.remove(indexOfSign);
        listForEvaluation.remove(indexOfSign -1);

        return listForEvaluation;
    }

    private int returnValue;
    public int evaluation(String indexOfSign, int valueBeforeIndex, int valueAfterIndex) {
        if (indexOfSign.equals("/"))
            returnValue = valueBeforeIndex / valueAfterIndex;
        if (indexOfSign.equals("*"))
            returnValue = valueBeforeIndex * valueAfterIndex;
        if (indexOfSign.equals("+"))
            returnValue = valueBeforeIndex + valueAfterIndex;
        if (indexOfSign.equals("-"))
            returnValue = valueBeforeIndex - valueAfterIndex;
        return returnValue;
    }
}
