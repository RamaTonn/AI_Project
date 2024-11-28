package code;

public class Path {
    private final int cost;
    private final Node target;
    private final Node home;
    private final Action action;

    public Path(int cost, Node target, Node home, Action action){
        this.cost = cost;
        this.target = target;
        this.home = home;
        this.action = action;
    }

    public int getCost() {
        return cost;
    }


    public Node getTarget() {
        return target;
    }

    public Node getHome() {
        return home;
    }

    public Action getAction() {
        return action;
    }
}
