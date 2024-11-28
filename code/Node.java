package code;

import java.util.*;

import static java.lang.Math.abs;

public class Node {

    private final Path[] paths;
    private final int x;
    private final int y;
    private Path parent;
    /// TO TEST ///
    ///         ///
    public int cost; // cost so far for this node
    public LinkedList<String> plan; // Path taken to reach this node


    public Node(int x, int y, int cost, LinkedList<String> plan, Path[] paths, Path parent){
        this.x= x;
        this.y= y;
        this.paths = paths;
        this.parent = parent;
        this.cost = cost;
        this.plan = plan;
    }

    public int calculateManhattanDistance(Node n){
        return abs(n.x - this.x) + abs(n.y - this.y);
    }

    public int calculateEuclideanDistance(Node n){
        double distance = Math.sqrt(Math.pow(this.x - n.x, 2) + Math.pow(this.y - n.y, 2));
        return (int) Math.round(distance);
    }

    public Path[] getPaths() {
        return paths;
    }

    public boolean isGoal(){
        return true; //TODO
    }

    public ArrayList<Path> expand(){

        ArrayList<Path> result = new ArrayList<>(this.paths.length);

        result.addAll(Arrays.asList(paths));

        return result;
    }

    public Node move(Node n , Action a){



        Node Next = n;

        if (a == Action.UP){
            //Next = new Node(n.x, n.y+1, n.cost, n.plan);

        }
        if (a == Action.DOWN){
            //Next = new Node(n.x, n.y-1, n.cost, n.plan);
        }
        if (a == Action.LEFT){
            //Next = new Node(n.x-1, n.y, n.cost, n.plan);
        }
        if (a == Action.RIGHT){
            //Next = new Node(n.x+1, n.y, n.cost, n.plan);
        }
        if (a == Action.TUNNEL){
           // Next = new Node(n.x, n.y+1, n.cost, n.plan);
        }
        return Next;
    }

    public void setParent(Path parent) {
        this.parent = parent;
    }

    public Path getParent(){
        return parent;
    }
}
