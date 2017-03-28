import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by Ivan on 28.03.2017.
 */
public class AddPersonDialog extends JDialog {
    public static final int ID_OK = 1;
    public static final int ID_CANCEL = 0;

    private int exitCode = ID_CANCEL;

    private TableRow tableRow;
    private java.util.List<JTextField> textFieldList;



    public AddPersonDialog() {
        textFieldList = new ArrayList<>();
        createGUI();

    }


    private void createGUI() {
        setPreferredSize(new Dimension(600, 400));
        setTitle("Добавить студента");
        this.setLayout(new BorderLayout());
        createBody();
        pack();
    }

    private void createBody(){
        GridBagConstraints cell =  new GridBagConstraints();
        Container dialogBody = new Container();
        dialogBody.setLayout(new GridBagLayout());
        cell.anchor = GridBagConstraints.CENTER;
        cell.gridheight = 1;
        cell.insets = new Insets(20, 20, 0, 0);

        addLabel("фио студента",cell,dialogBody,1,0,0);
        addTextField(cell,dialogBody,3,1,0);

        addLabel("группа",cell,dialogBody,1,0,1);
        addTextField(cell,dialogBody,3,1,1);

        for (int rowIndex = 2; rowIndex < 7; rowIndex++){
            addLabel("Экзамен",cell,dialogBody,1,0,rowIndex);
            addTextField(cell,dialogBody,1,1,rowIndex);

            addLabel("Результат",cell,dialogBody,1,2,rowIndex);
            addTextField(cell,dialogBody,1,3,rowIndex);
        }

        addOkButton(dialogBody);
        this.add(dialogBody,BorderLayout.NORTH);
    }


    private void addOkButton(Container dialogBody){
        GridBagConstraints cell =  new GridBagConstraints();
        cell.gridx = 0;
        cell.gridy = 7;
        cell.insets = new Insets(20, 40, 0, 0);
        cell.anchor = GridBagConstraints.CENTER;

        JButton okButton = new JButton("Добавить студента");

        AddPersonDialog that = this;



        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<Exam> exams = new ArrayList<>();
                String studentName = textFieldList.get(0).getText();
                int group = Integer.parseInt(textFieldList.get(1).getText());
                for(int index = 2; index < textFieldList.size(); index+=2){
                    String title = textFieldList.get(index).getText();
                    int result = Integer.parseInt(textFieldList.get(index+1).getText());
                    exams.add(new Exam(title,result));
                }
                that.tableRow = new TableRow(studentName,group,exams);

                that.exitCode = ID_OK;
                that.dispose();
            }
        });

        dialogBody.add(okButton,cell);
    }


    private void addLabel(String name,GridBagConstraints cell,Container dialogBody, int width,int x,int y){
        cell.gridx = x;
        cell.gridy = y;
        cell.ipadx = 20;
        cell.gridwidth = width;
        cell.fill = GridBagConstraints.BOTH;
        JLabel label= new JLabel(name, SwingConstants.CENTER);
        dialogBody.add(label,cell);
    }

    private void addTextField(GridBagConstraints cell,Container dialogBody, int width,int x,int y){
        cell.gridx = x;
        cell.gridy = y;
        cell.ipadx = 100;
        cell.gridwidth = width;
        cell.fill = GridBagConstraints.BOTH;
        JTextField textField = new JTextField(20);
        dialogBody.add(textField,cell);
        textFieldList.add(textField);
    }


    @Override
    public void dispose() {
        super.dispose();
    }

    public int doModal() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setVisible(true);

        return exitCode;
    }

    public TableRow getTableRow() {
        return tableRow;
    }

}
