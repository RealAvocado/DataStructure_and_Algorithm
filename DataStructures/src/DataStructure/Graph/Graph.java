package DataStructure.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 图 无向图&有向图
 */
public class Graph {
    private ArrayList<String> vertexList; //用字符串存储顶点集合
    private int[][] edges;
    private int numOfEdges;
    private boolean[] isVisited; //记录一个节点是否被访问过了，用于DFS和BFS算法

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //得到第一个邻结点的下标
    /**
     * @param index
     * @return 如果存在连通的邻结点就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbour(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //寻找此邻接结点之后的下一个可以被连通的邻接结点
    /**
     * @param v1 当前节点
     * @param v2 当前节点的当前邻接结点
     * @return
     */
    public int getNextNeighbour(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法，i是结点的下标，第一次是0
    private void dfs(boolean[] isVisited, int i) {
        //先访问该结点，然后输出（第一次访问从初始结点开始）
        System.out.print(getValueByIndex(i) + "->");
        //将结点设置为已被访问
        isVisited[i] = true;
        //查找结点i的第一个邻接结点w
        int w = getFirstNeighbour(i);
        while (w != -1) { //如果i的邻接结点存在
            if (!isVisited[w]) { //如果该邻接结点未被访问
                dfs(isVisited, w);
            }
            //如果w结点已经被访问过
            w = getNextNeighbour(i, w);
        }
        //这个方法到这里为止只对第一个起始节点v进行了深度遍历，遍历到w==-1时就停止了，
        //但是我们还需要对“v的下一个邻接结点v2作为起始节点进行一个新的深度遍历”的情况进行计算，所以需要对dfs方法进行一个重载
    }

    //dfs方法重载，遍历所有节点，每个节点都进行dfs
    public void dfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i); //调用了上面写的单趟dfs
            }
        }
    }

    //对一个结点进行广度优先遍历
    private void bfs(boolean[] isVisited, int i) {
        int u;//队列的头结点对应的下标
        int w;//邻接结点w
        LinkedList queue = new LinkedList();
        isVisited[i] = true;
        queue.addLast(i);
        System.out.print(getValueByIndex(i) + "->");
        while (!queue.isEmpty()) {
            u = (Integer) queue.removeFirst();
            w = getFirstNeighbour(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w)+"->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbour(u, w);
            }
        }
    }

    //bfs重载
    public void bfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i（下标）对应的数据 即结点的名字
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回下标v1和v2之间的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示图
    public void showGraph() {
        for (int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * @param v1     表示点的下标（第几个顶点）
     * @param v2     同上
     * @param weight 表示权值 数字1表明是连接的 0表明没有连接
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public static void main(String[] args) {
        int n = 9;
        String Vertexes[] = {"A", "B", "C", "D", "E","F","G","H","I"};
        Graph graph = new Graph(n);
        for (String vertex : Vertexes) {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(0, 3, 1);
        graph.insertEdge(0, 4, 1);
        graph.insertEdge(1, 5, 1);
        graph.insertEdge(5, 7, 1);
        graph.insertEdge(3, 6, 1);
        graph.insertEdge(6, 8, 1);
        graph.showGraph();
        System.out.println("深度遍历：");
        graph.dfs();
        System.out.println();
        System.out.println("广度遍历：");
        graph.bfs();
    }
}
