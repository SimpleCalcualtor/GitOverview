package the2021.jCode;

import java.util.LinkedList;
import java.util.List;

public class PrepareList {

    private List<String> listContainsExpression;
    private List<String> prepareListWhichContainsExpression = new LinkedList<>();
    private String bufferForNumbers = "";
    private String bufferForSign = "";

    public PrepareList(List<String> listContainsExpression) {
        this.listContainsExpression = listContainsExpression;
        convertListOfExpressionToPreparedListOfExpressionForCalculation();
    }

    public void convertListOfExpressionToPreparedListOfExpressionForCalculation() {

        for (int i = 0; i < listContainsExpression.size(); i++) {

            try {
                Integer.valueOf(listContainsExpression.get(i));
                bufferForNumbers = bufferForNumbers + listContainsExpression.get(i);
            } catch (NumberFormatException ex) {
                bufferForSign = listContainsExpression.get(i);
                addNewValuesForPreparedList(bufferForNumbers, bufferForSign);
            }
        }
        addNewValuesForPreparedList(bufferForNumbers);
    }

    public void addNewValuesForPreparedList(String bufferForNumbers, String bufferForSign) {
        prepareListWhichContainsExpression.add(bufferForNumbers);
        prepareListWhichContainsExpression.add(bufferForSign);
        this.bufferForNumbers = "";
        this.bufferForSign = "";
    }

    public void addNewValuesForPreparedList(String singleValueBuffer){
        prepareListWhichContainsExpression.add(singleValueBuffer);
        this.bufferForNumbers = "";
        this.bufferForSign = "";
        new Calculator(prepareListWhichContainsExpression);
    }
}
