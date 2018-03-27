import java.util.concurrent.*;

public class Main {

    public static void main(String... args) {
        Dock dockA = new Dock("A",1);
        Dock dockB = new Dock("B",2);
        SubmissionPublisher<Object> publisher = new SubmissionPublisher<>();
        //подписывае А на издателя
        publisher.subscribe(dockA);
        //А подписан проверяем
        System.out.println(publisher.isSubscribed(dockA));

        publisher.subscribe(dockB);
        //Проверяем, у издателя два подписчика
        System.out.println(publisher.getNumberOfSubscribers());
        //В подписчиках не вызван метод onSubscribe, ледовательно они не получили подписку
        // и не могут запросить объекты demand = 0
        System.out.println(publisher.estimateMinimumDemand());
        publisher.submit(new Object());
        publisher.submit(new Object());
        publisher.submit(new Object());

    }
}
