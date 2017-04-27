/**
 * Created by Ivan on 27.04.2017.
 */
import java.io.*;
public class GeneratorStarter {
    public static void main(String []args) throws Exception{
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        try {
            String  ammount = keyboard.readLine();
            new Generator(Integer.valueOf(ammount));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
