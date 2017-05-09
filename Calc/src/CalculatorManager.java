import java.awt.event.*;

/**
 * Created by Ivan on 06.05.2017.
 */
public class CalculatorManager {
    private CalculatorMainFrame calculatorMainFrame;
    private CalculatorData calculatorData;
    public CalculatorManager(CalculatorMainFrame calculatorMainFrame, CalculatorData calculatorData){
        this.calculatorData = calculatorData;
        this.calculatorMainFrame = calculatorMainFrame;
        setListeners();
    }

    private void setListeners(){
        calculatorMainFrame.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    calculatorData.reset();
                    if(calculatorMainFrame.getExpressionPanel().getText().length() != 0)
                    calculatorMainFrame.getResultPanel().setText(
                            String.valueOf(calculatorData.calculate(calculatorMainFrame.getExpressionPanel().getText())));
                    calculatorMainFrame.createTree(calculatorData.getRootNode(),calculatorData.getDepth());
                } catch (CalculationException e1) {
                    e1.printStackTrace();
                    calculatorMainFrame.showMessage(e1.getMessage());

                }
            }
        });

        calculatorMainFrame.getClearButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatorData.reset();
                calculatorMainFrame.reset();
            }
        });

        calculatorMainFrame.getForwardButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(calculatorData.getRootNode() != null){
                        calculatorData.changeDepth(false);
                        calculatorMainFrame.getExpressionPanel().setText(calculatorData.getExpression());
                        calculatorMainFrame.createTree(calculatorData.getRootNode(),calculatorData.getDepth());
                    }
                } catch (CalculationException e1) {
                    e1.printStackTrace();
                    calculatorMainFrame.showMessage(e1.getMessage());
                }
            }
        });

        calculatorMainFrame.getBackwardButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(calculatorData.getRootNode() != null){
                        calculatorData.changeDepth(true);
                        calculatorMainFrame.getExpressionPanel().setText(calculatorData.getExpression());
                        calculatorMainFrame.createTree(calculatorData.getRootNode(),calculatorData.getDepth());
                    }
                } catch (CalculationException e1) {
                    e1.printStackTrace();
                    calculatorMainFrame.showMessage(e1.getMessage());
                }
            }
        });
    }
}
