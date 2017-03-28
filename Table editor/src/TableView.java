import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;
import java.util.List;

/**
 * Created by Ivan on 21.03.2017.
 */
public class TableView {
    private JFrame mainFrame;
    private JPanel workingArea;
    private List<JButton> toolPanelButtons;
    private JDialog activeDialog;


    TableView() {
        toolPanelButtons = new ArrayList<>();
        setFrame();
        addWorkingArea();
        createTable(null);
    }


    private void setFrame() {
        this.mainFrame = new JFrame("TableEditor");
        this.mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addFrameListener();
        addToolPanel();

        this.mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.mainFrame.setVisible(true);
    }

    private void addToolPanel() {
        JToolBar toolBar = new JToolBar();
        toolBar.setPreferredSize(new Dimension(mainFrame.getWidth(), 48));
        toolBar.setFloatable(false);
        Box buttonsBox = Box.createHorizontalBox();
        toolBar.setBackground(new Color(94, 115, 232));
        setButtons(buttonsBox);
        toolBar.add(buttonsBox);
        mainFrame.add(toolBar, BorderLayout.NORTH);

    }

    private void setButtons(Box buttonsBox) {
        addButton("img/save.png", buttonsBox);
        addButton("img/open.png", buttonsBox);
        addButton("img/add-user.png", buttonsBox);
        addButton("img/remove-user.png", buttonsBox);
        addButton("img/search-user.png", buttonsBox);
    }

    private void addButton(String filename, Box buttonsBox) {
        JButton button = new JButton(new ImageIcon(filename));
        button.setBackground(null);
        button.setPreferredSize(new Dimension(40, 40));
        buttonsBox.add(button);
        buttonsBox.add(Box.createHorizontalStrut(32));
        toolPanelButtons.add(button);
    }

    private void addWorkingArea() {
        workingArea = new JPanel();
        workingArea.setBackground(new Color(175, 205, 231));
        workingArea.setLayout(new BorderLayout());
        mainFrame.add(workingArea);
    }


    public void createTable(List<TableRow> table) {
        //TODO: add ammount of rows depanding from page
        workingArea.removeAll();
        GridBagLayout tableLayout = new GridBagLayout();
        Container tableContainer = new Container();
        tableContainer.setLayout(tableLayout);
        printTableHeader(tableContainer);
        if(table != null)printTableBody(table,tableContainer);
        workingArea.add(tableContainer,BorderLayout.NORTH);
        mainFrame.setVisible(false);
        mainFrame.setVisible(true);
    }

    private void printTableBody(List<TableRow> table,Container tableContainer){
        GridBagConstraints cell =  new GridBagConstraints();

        cell.anchor = GridBagConstraints.CENTER;
        cell.fill = GridBagConstraints.BOTH;

        cell.gridy = 2;
        for(TableRow row : table){
            cell.gridheight = 1;
            cell.gridwidth = 1;
            cell.weightx = 1;
            cell.gridx = GridBagConstraints.RELATIVE;
            cell.gridy++;
            tableContainer.add(addLabe(row.studentName), cell);
            tableContainer.add(addLabe(String.valueOf(row.group)), cell);
            for(Exam exam : row.exams){
                tableContainer.add(addLabe(exam.getExam()), cell);
                tableContainer.add(addLabe(String.valueOf(exam.getExamResult())), cell);
            }
        }
    }

    private void printTableHeader(Container tableContainer){
        GridBagConstraints cell =  new GridBagConstraints();

        cell.anchor = GridBagConstraints.CENTER;
        cell.fill = GridBagConstraints.BOTH;
        cell.gridheight = 3;
        cell.gridwidth = 1;
        cell.weightx = 1;
        cell.gridx = 0;
        cell.gridy = 0;
        tableContainer.add(addLabe("фио студента"), cell);

        cell.gridx = GridBagConstraints.RELATIVE;
        tableContainer.add(addLabe("группа"), cell);

        cell.gridwidth = 10;
        cell.gridheight = 1;
        tableContainer.add(addLabe("Экзамены"), cell);

        cell.gridx = 1;
        for (int index = 0; index < 5; index++){
            cell.gridx = GridBagConstraints.RELATIVE;
            cell.gridy = 1;
            cell.gridwidth = 2;
            tableContainer.add(addLabe(String.valueOf(index+1)), cell);

            cell.gridwidth = 1;
            cell.gridy = 2;
            tableContainer.add(addLabe("Наименование"), cell);

            cell.gridx = GridBagConstraints.RELATIVE;
            tableContainer.add(addLabe("Результат"), cell);
        }

    }

    private JLabel addLabe(String name){
        JLabel newLabel = new JLabel(name, SwingConstants.CENTER);
        newLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
        return newLabel;
    }

    public void addDialog(JDialog dialog){

        dialog.setLocationRelativeTo(workingArea);
    }

    private void addFrameListener() {
        this.mainFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                Object[] options = {"Exit", "Cancel"};
                int n = JOptionPane
                        .showOptionDialog(e.getWindow(), "Are you sure you want to exit?",
                                "Submit", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options,
                                options[0]);
                if (n == 0) {
                    e.getWindow().setVisible(false);
                    System.exit(0);
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }


    public List<JButton> getToolPanelButtons() {
        return toolPanelButtons;
    }
}
