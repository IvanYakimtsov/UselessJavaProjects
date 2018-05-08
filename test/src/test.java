import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class test {
    private static final String CHAR_LIST =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static String generateRandomString(int length) {
        StringBuffer randStr = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    private static int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt == 0) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }

    public static void main(String[] args) {
//        LocalDateTime dateTime = LocalDateTime.now();
//        String date = dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
//        System.out.println(date);
        TestCommand command = new TestCommand();
        for(int i = 0; i < 10000; i++){
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    command.execute(generateRandomString(getRandomNumber()),getRandomNumber());
                }
            }).run();

        }
    }

}
