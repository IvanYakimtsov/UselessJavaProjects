import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Ivan on 29.03.2017.
 */
public class SearchPersonDialog {

    public static final int ID_SEARCH_OPTION_1 = 1;
    public static final int ID_SEARCH_OPTION_2 = 2;
    public static final int ID_SEARCH_OPTION_3 = 3;
    public static final int ID_CANCEL = 0;

    private int exitCode = ID_CANCEL;

    private JDialog searchPersonDialog;


    final JTabbedPane tabbedPane = new JTabbedPane();

    private String studentSurname;
    private int group;
    private int maxResult;
    private int minResult;
    private String exam;


    private String dialogTitle;


    public SearchPersonDialog(String dialogTitle) {
        this.searchPersonDialog = new JDialog();
        this.dialogTitle = dialogTitle;
        createGUI();


    }


    private void createGUI() {
        searchPersonDialog.setPreferredSize(new Dimension(600, 400));
        searchPersonDialog.setTitle(dialogTitle);
        setTabs();
        searchPersonDialog.pack();
    }


    private void setTabs(){
        setFirstSearchOptionTab();
        setSecondSearchOptionTab();
        setThirdSearchOptionTab();

        searchPersonDialog.add(tabbedPane);
    }

    private void setFirstSearchOptionTab(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        java.util.List<JTextField> textFieldList = new ArrayList<>();
        GridBagConstraints cell =  new GridBagConstraints();
        Container dialogBody = new Container();
        dialogBody.setLayout(new GridBagLayout());
        cell.anchor = GridBagConstraints.CENTER;
        cell.gridheight = 1;
        cell.insets = new Insets(20, 20, 0, 0);

        addLabel("фaмилия студента",cell,dialogBody,1,0,0);
        addTextField(textFieldList,cell,dialogBody,1,1,0);

        addLabel("группа",cell,dialogBody,1,0,1);
        addTextField(textFieldList,cell,dialogBody,1,1,1);
        addFirstButton(dialogBody,textFieldList);
        panel.add(dialogBody,BorderLayout.NORTH);
        tabbedPane.addTab("группа" , panel);
    }

    private void addFirstButton(Container dialogBody, java.util.List<JTextField> textFieldList){
        JButton button = new JButton(dialogTitle);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentSurname = textFieldList.get(0).getText();
                group = Integer.valueOf(textFieldList.get(1).getText());
                exitCode = SearchPersonDialog.ID_SEARCH_OPTION_1;
                searchPersonDialog.dispose();
            }
        });
        addButton(button,dialogBody);
    }

    private void setSecondSearchOptionTab(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        java.util.List<JTextField> textFieldList = new ArrayList<>();
        GridBagConstraints cell =  new GridBagConstraints();
        Container dialogBody = new Container();
        dialogBody.setLayout(new GridBagLayout());
        cell.anchor = GridBagConstraints.CENTER;
        cell.gridheight = 1;
        cell.insets = new Insets(20, 20, 0, 0);

        addLabel("фaмилия студента",cell,dialogBody,1,0,0);
        addTextField(textFieldList,cell,dialogBody,1,1,0);

        addLabel("минимальный порог",cell,dialogBody,1,0,1);
        addTextField(textFieldList,cell,dialogBody,1,1,1);

        addLabel("максимальный порог",cell,dialogBody,1,0,2);
        addTextField(textFieldList,cell,dialogBody,1,1,2);

        addSecondButton(dialogBody,textFieldList);
        panel.add(dialogBody,BorderLayout.NORTH);
        tabbedPane.addTab("средний балл" , panel);
    }


    private void addSecondButton(Container dialogBody, java.util.List<JTextField> textFieldList){
        JButton button = new JButton(dialogTitle);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentSurname = textFieldList.get(0).getText();
                minResult = Integer.valueOf(textFieldList.get(1).getText());
                maxResult = Integer.valueOf(textFieldList.get(2).getText());
                exitCode = SearchPersonDialog.ID_SEARCH_OPTION_2;
                searchPersonDialog.dispose();
            }
        });
        addButton(button,dialogBody);
    }

    private void setThirdSearchOptionTab(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        java.util.List<JTextField> textFieldList = new ArrayList<>();
        GridBagConstraints cell =  new GridBagConstraints();
        Container dialogBody = new Container();
        dialogBody.setLayout(new GridBagLayout());
        cell.anchor = GridBagConstraints.CENTER;
        cell.gridheight = 1;
        cell.insets = new Insets(20, 20, 0, 0);

        addLabel("фaмилия студента",cell,dialogBody,1,0,0);
        addTextField(textFieldList,cell,dialogBody,1,1,0);

        addLabel("название экзамена",cell,dialogBody,1,0,1);
        addTextField(textFieldList,cell,dialogBody,1,1,1);

        addLabel("минимальный порог",cell,dialogBody,1,0,2);
        addTextField(textFieldList,cell,dialogBody,1,1,2);

        addLabel("максимальный порог",cell,dialogBody,1,0,3);
        addTextField(textFieldList,cell,dialogBody,1,1,3);

        addThirdButton(dialogBody,textFieldList);

        panel.add(dialogBody,BorderLayout.NORTH);
        tabbedPane.addTab("результат экзамена" , panel);
    }

    private void addThirdButton(Container dialogBody, java.util.List<JTextField> textFieldList){
        JButton button = new JButton(dialogTitle);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentSurname = textFieldList.get(0).getText();
                exam = textFieldList.get(1).getText();
                minResult = Integer.valueOf(textFieldList.get(2).getText());
                maxResult = Integer.valueOf(textFieldList.get(3).getText());
                exitCode = SearchPersonDialog.ID_SEARCH_OPTION_3;
                searchPersonDialog.dispose();
            }
        });
        addButton(button,dialogBody);
    }

    private void addButton(JButton button,Container tableBody){
        GridBagConstraints cell =  new GridBagConstraints();
        cell.gridx = 0;
        cell.gridy = GridBagConstraints.RELATIVE;

        cell.insets = new Insets(20, 20, 0, 0);
        tableBody.add(button,cell);
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

    private void addTextField( java.util.List<JTextField> textFieldList,GridBagConstraints cell,Container dialogBody, int width,int x,int y){
        cell.gridx = x;
        cell.gridy = y;
        cell.ipadx = 100;
        cell.gridwidth = width;
        cell.fill = GridBagConstraints.BOTH;
        JTextField textField = new JTextField(20);
        dialogBody.add(textField,cell);
        textFieldList.add(textField);
    }

    public int startDialog() {
        searchPersonDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        searchPersonDialog.setModal(true);
        searchPersonDialog.setVisible(true);

        return exitCode;
    }


    public JDialog getDialog() {
        return searchPersonDialog;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public int getGroup() {
        return group;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public int getMinResult() {
        return minResult;
    }

    public String getExam() {
        return exam;
    }



}
