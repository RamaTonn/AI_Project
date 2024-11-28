package code;

import java.util.*;

public class DeliverySearch extends GenericSearch{

    public String solve(Node truck, Strategy strat, Node product) {
        String result = "";

        switch(strat){
            case BF -> {
                return breadthFirst(truck);
            }
            case DF -> {
                return depthFirst(truck);
            }
            case ID -> {
                return iterativeDepth(truck);
            }
            case UC -> {
                return uniformCost(truck);
            }
            case GR1 -> {
                return greedy(truck, truck.calculateEuclideanDistance(product));
            }
            case GR2 -> {
                return greedy(truck, truck.calculateManhattanDistance(product));
            }
            case AS1 -> {
                return aStar(truck, truck.calculateEuclideanDistance(product));
            }
            case AS2 -> {
                return aStar(truck, truck.calculateManhattanDistance(product));
            }
        }
        return "";
    }

    private static String getPath(Node n){
        Path p;
        StringBuilder result = new StringBuilder();
        if (n.getParent() == null){
            return "";
        }
        p = n.getParent();
        while(p != null){
            result.append(p.getAction().toString()).append(",");
            p = p.getHome().getParent();
        }
        return result.substring(0, result.length()-1);
    }

    //Queue
    private static String breadthFirst(Node start){
        ArrayDeque<Node> nodes = new ArrayDeque<>();
        nodes.addLast(start);
        while(true){
            if(nodes.isEmpty()){
                return "";
            }
            Node topNode = nodes.pollFirst();
            if (topNode.isGoal()){
                return getPath(topNode);//TODO create result path
            }

            ArrayList<Path> next = topNode.expand();

            if(!next.isEmpty()){
                for (Path path: next){
                    nodes.addLast(path.getTarget());
                    path.getTarget().setParent(path);
                }
            }

        }
    }

    //Stack
    private static String depthFirst(Node start){
        Stack<Node> nodes = new Stack<>();
        nodes.push(start);
        while(true){
            if(nodes.isEmpty()){
                return "";
            }
            Node topNode = nodes.pop();
            if (topNode.isGoal()){
                return getPath(topNode);//TODO create result path
            }
            ArrayList<Path> next = topNode.expand();
            if(!next.isEmpty()){
                for (Path path: next){
                    nodes.push(path.getTarget());
                    path.getTarget().setParent(path);
                }
            }
        }
    }

    //Priority Queue K = cost
    private static String uniformCost(Node start){
        PriorityQueue<Node> nodes = new PriorityQueue<Node>();
        nodes.add(start);
        while(true){
            if(nodes.isEmpty()){
                return "";
            }
            Node topNode = nodes.poll();
            if (topNode.isGoal()){
                return "";//TODO create result path
            }
            ArrayList<Path> next = topNode.expand();
            if(!next.isEmpty()){
                for (Path path: next){
                    nodes.add(path.getTarget());
                }
            }
        }
    }


    private static String iterativeDepth(Node n){
        return "";
    }

    //Priority Queue K = cost + heuristic
    private static String aStar(Node n, int h){
        return "";
    }

    //Priority Queue K = heuristic
    private static String greedy(Node n, int h){
        return "";
    }
}
