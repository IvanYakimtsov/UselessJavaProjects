import java.util.*;
import java.lang.*;
import java.io.*;

public class Generator {
	private double mistakes;
	private Random random = new Random(System.currentTimeMillis());
	static private StringBuilder staticSb = new StringBuilder();
	private ArrayList<String> names = new ArrayList<String>();
	private	ArrayList<String> phones = new ArrayList<String>();
	private	ArrayList<String> address = new ArrayList<String>();
	
	
	private void chooseName(String file)throws Exception{
		File listOfNames=new File("D:\\JavaProjects\\task2\\"+file);  
		FileReader reader = new FileReader(listOfNames);
		char[] buffer = new char[(int)listOfNames.length()];
		reader.read(buffer);
		String b = new String(buffer);
		String[] name = b.split("\n");
		for(int i=0;i<name.length;i++) {
			names.add(name[i].substring(0, name[i].length()-1));
		}
	}
	
	private void chooseAdress(String file)throws Exception{
        File listOfAddress=new File("D:\\JavaProjects\\task2\\"+file);  	
		FileReader reader = new FileReader(listOfAddress);
		char[] buffer = new char[(int)listOfAddress.length()];
		reader.read(buffer);
		String b = new String(buffer);
		String[] addresstmp = b.split("\n");
		for(int i=0;i<addresstmp.length;i++) {
			address.add(addresstmp[i].substring(0, addresstmp[i].length()-1));
		}
	}
	
	
	private void loadPhones()throws Exception{
		File listOfPhones=new File("D:\\JavaProjects\\task2\\phone.txt");  	
	    FileReader reader = new FileReader(listOfPhones);
		char[] buffer = new char[(int)listOfPhones.length()];
		reader.read(buffer);
		String b = new String(buffer);
		String[] phone = b.split("\n");
		for(int i=0;i<phone.length;i++) {
			phones.add(phone[i].substring(0, phone[i].length()-1));
		}
	}
	
	private void generateMistakes(int length,StringBuilder sb){
				 char c = sb.charAt(random.nextInt(length));
				if(c!=' '){
				sb.setCharAt(random.nextInt(length),c);	
				}else {
				sb.setCharAt(random.nextInt(length),sb.charAt(1));	
				}			
	}
	
	private void createMistakes(String input){
		 int length=input.length();
		 StringBuilder sb = new StringBuilder(input);
		 if(mistakes>0.99){
			for(int i=0;i<(int)mistakes;i++){
				generateMistakes(length,sb);
			}
		 } else{
			 generateMistakes(length,sb);
		 }
		 System.out.println(sb);
	}
	
	
	public void chooseRegion(String language) throws Exception{
		chooseName(language + "_name.txt");
		chooseAdress(language + "_address.txt");
		loadPhones();
	}
	
	public void startCalc(int ammount){
		String tmp=" ";
		for(int i=0;i< ammount;i++){
		staticSb.delete(0, staticSb.length());
		createMistakes(staticSb.append(names.get(random.nextInt(500))).append(tmp).append(phones.get(random.nextInt(200))).append(tmp)
		.append(address.get(random.nextInt(500))).toString());
		}
	}
	
    public static void main(String[] args) throws Exception{
		Generator gen = new Generator();
		gen.mistakes = Double.parseDouble(args[1]);
		gen.chooseRegion(args[0]);
		gen.startCalc(Integer.parseInt(args[2]));
		}
		
        }
    
