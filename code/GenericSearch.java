package code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

public abstract class GenericSearch {

    public int[][] map;


    public abstract String solve(Node n, Strategy strat, Node target);

}
