import java.lang.reflect.Array;

import static java.lang.Math.abs;

public class Node {

    private Node[] children;
    private int x;
    private int y;

    public int calculateDistance(Node n){
        return abs(n.x - this.x) + abs(n.y - this.y);
    }
}
