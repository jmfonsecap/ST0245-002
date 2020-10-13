
import java.util.ArrayList;
import java.util.HashMap;

public class Main
{
    public static void main() {
        LectorDatos d = new LectorDatos();
        HashMap<Long, Node> nodes = d.readNodes();
        System.out.println(nodes.size());
        ArrayList<Triplet<Long, Long, Double>> edges = d.readEdges();
	}
}