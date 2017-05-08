import java.util.List;

/**
 * Created by Ivan on 08.05.2017.
 */
public interface Node {
    public int ArityOfOperation();
    public String getText(int depth) throws CalculationException;
    public double getResult() throws CalculationException;
    public boolean isReachable(int depth);
    public List<Node> getAdjacentNodes();
    public String getTitle();
}
