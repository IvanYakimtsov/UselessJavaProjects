/**
 * Created by Ivan on 27.04.2017.
 */

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Generator {
    int amount;
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<String> surnames = new ArrayList<String>();
    private ArrayList<String> lastNames = new ArrayList<String>();
    private ArrayList<String> examsTitles = new ArrayList<String>();
    private Random random;

    Generator(int amount) throws Exception {
        this.amount = amount;
        examsTitles.add("Моис");
        examsTitles.add("Гео");
        examsTitles.add("Ппвис");
        examsTitles.add("Мрз");
        examsTitles.add("Отс");
        chooseFile("names.txt", names);
        chooseFile("surnames.txt", surnames);
        chooseFile("lastNames.txt", lastNames);
        this.random = new Random(System.currentTimeMillis());
        saveAction(System.getProperty("user.dir") + "\\dataBase.xml");

    }


    public void saveAction(String path) throws TransformerException, IOException {
        writeParamXML(paramLangXML(), path);
    }


    private DocumentBuilder paramLangXML() {
        DocumentBuilder builder = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return builder;
    }

    private void writeParamXML(DocumentBuilder builder, String path) throws TransformerException, IOException {

        Document document = builder.newDocument();
        Element RootElement = document.createElement("studentsList");

        for (int i = 0; i < amount; i++) {
            Element tableRow = document.createElement("student");

            Element studentSurname = document.createElement("studentSurname");
            studentSurname.appendChild(document.createTextNode(surnames.get(random.nextInt(surnames.size()))));
            tableRow.appendChild(studentSurname);

            Element studentName = document.createElement("studentName");
            studentName.appendChild(document.createTextNode(names.get(random.nextInt(names.size()))));
            tableRow.appendChild(studentName);


            Element studentPatronymic = document.createElement("studentPatronymic");
            studentPatronymic.appendChild(document.createTextNode(lastNames.get(random.nextInt(lastNames.size()))));
            tableRow.appendChild(studentPatronymic);

            Element group = document.createElement("group");
            int groupNumber = random.nextInt(400000) + 600000;
            group.appendChild(document.createTextNode(String.valueOf(groupNumber)));
            tableRow.appendChild(group);

            Element exams = document.createElement("exams");

            for (int j = 0; j < 5; j++) {
                Element examElement = document.createElement("exam");


                Element examTitle = document.createElement("examTitle");
                examTitle.appendChild(document.createTextNode(examsTitles.get(j)));
                examElement.appendChild(examTitle);

                Element examResult = document.createElement("examResult");
                examResult.appendChild(document.createTextNode(String.valueOf(random.nextInt(10))));
                examElement.appendChild(examResult);

                exams.appendChild(examElement);
            }

            tableRow.appendChild(exams);

            RootElement.appendChild(tableRow);
        }

        document.appendChild(RootElement);

        Transformer t = TransformerFactory.newInstance().newTransformer();
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        t.transform(new DOMSource(document), new StreamResult(fileOutputStream));
        fileOutputStream.close();

    }

    private void chooseFile(String file, ArrayList<String> list) throws Exception {
        File listOfAddress = new File(System.getProperty("user.dir")+"\\"+ file);
        FileReader reader = new FileReader(listOfAddress);
        char[] buffer = new char[(int) listOfAddress.length()];
        reader.read(buffer);
        String b = new String(buffer);
        String[] addresstmp = b.split("\n");
        for (int i = 0; i < 200; i++) {
            list.add(addresstmp[i].substring(0, addresstmp[i].length() - 1).trim());
        }
    }
}
