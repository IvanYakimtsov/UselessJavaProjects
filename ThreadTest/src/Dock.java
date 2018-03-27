import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class Dock implements Flow.Subscriber<Object> {
    private String title;
    private int demand;

    public Dock(String title, int demand){
        this.title = title;
        this.demand = demand;
    }

    private Flow.Subscription subscription;

    private List<Object> cargo = new ArrayList<>();

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        //не вызывается при подписке. Странно...
        System.out.println("subscribe " + title);
        this.subscription = subscription;
        subscription.request(demand);
    }

    @Override
    public void onNext(Object item) {
        System.out.println(title + " add item");
        cargo.add(item);
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }

}
