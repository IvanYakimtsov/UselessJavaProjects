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
                    calculatorData.calculate(calculatorMainFrame.getExpressionPanel().getText());
                } catch (CalculationException e1) {
                    System.out.println( e1.getMessage());

                }
            }
        });
    }
}
