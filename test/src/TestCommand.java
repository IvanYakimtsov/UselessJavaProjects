public class TestCommand {
    private String route;
    public void execute(String id, int time) {
        try {
            route = id;
            Thread.sleep(time);
            assert (route.equals(id));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
