
import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class Graph {
    private int V; // No. of vertices
    public int dist[];
    public LinkedList<No>[] adj; // Adjacency Lists
    private boolean[] visited;
    public int finalWeight;
    // private No[] parent;
    

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[V];
        visited = new boolean[V];
        dist = new int[V];
        // No[] parent = new No[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<No>();
            visited[i] = false;
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, String s, int ni, int w) {
        adj[v].add(new No(ni, s, w));
    }

    // Function to find an edge from the graph
    int findEdge(String s) {
        // System.out.println(s);
        for(int i = 0; i < adj.length; i++){
            if(adj[i].element().cityName.equals(s)){
                return adj[i].element().pos;
            }
        }
        return 0;
    }

        // Function to add an edge into the graph
        No findNode(String s) {
            for(int i = 0; i <= adj.length; i++){
                if(adj[i].element().cityName.equals(s)){
                    return adj[i].element();
                }
            }
            return null;
        }

    // prints BFS traversal from a given source s
    void BFS(String s, String e) {
        // Mark all the vertices as not visited(By default
        // set as false)
        for (int i = 0; i < V; i++)
        dist[i] = Integer.MAX_VALUE;

        No[] parent = new No[V];
        No aux_parent;
        boolean find = false;
        // Stack<No> pilha = new Stack<No>();
        // Stack<No> path = new Stack<No>();


        // Create a queue for BFS
        Queue<No> queue = new LinkedList<No>();
        No h;
        int p = findEdge(s);
        System.out.println(p);
        No no = findNode(s);
        // System.out.println("Posição inicio"+p+"");
        // Mark the current node as visited and enqueue it
        visited[p] = true;
        queue.add(no);
        parent[p] = no;

        // Distance to the source is 0
        dist[p] = 0;
        
        System.out.print("Buscas: [");
        while (!queue.isEmpty() && !find) {
            // Dequeue a vertex from queue and print it    
            no = queue.poll();
            // pilha.add(no);
            finalWeight = dist[no.pos];
            System.out.print(no.cityName + "-");
            p = findEdge(no.cityName);
            aux_parent = no;


            if (no.cityName.equals(e)) {
                // h = parent[no.pos];
                // for (int i = 0; i < V; i++) {
                    
                // }
                // path.add(pilha.lastElement());
                // while(!pilha.isEmpty()){
                //     h = parent[path.lastElement().pos];
                //     if(pilha.lastElement().cityName == h.cityName){
                //         path.add(h);
                //     }
                //     pilha.pop();
                    
                // }

                find = true;

            } else {
                // Get all adjacent vertices of the dequeued vertex s
                // If a adjacent has not been visited, then mark it
                // visited and enqueue it
                // No maior = null;
                int edgeDistance = -1;
                int newDistance = -1;
                Iterator<No> i = adj[p].listIterator();
                while (i.hasNext()) {
                    No n = i.next();
                    
                    if (visited[n.pos] == false || dist[n.pos] > dist[p] +n.weight) {

                        edgeDistance = n.weight;
                        System.out.println("e:"+edgeDistance);
                        newDistance = dist[p] + edgeDistance;
                        System.out.println("j:"+newDistance);
                        // If new distance is cheaper in cost
                        if (newDistance < dist[n.pos])
                            dist[n.pos] = newDistance;

                        parent[n.pos] = aux_parent;
                        visited[n.pos] = true;
                        // System.out.println(n.weight);
                        queue.add(n);

                    }
                }
            }
        }
        System.out.println("]");
        System.out.println(" ");
        System.out.print("Caminho: [");
        // while(!path.isEmpty()){
        //     System.out.print(path.pop().cityName+ "-");
        // }
        int u =0;
        System.out.print(no.cityName+"-"+finalWeight);
        // System.out.println(no.pos);
        // System.out.println("------------");
        h = parent[no.pos];
        // System.out.println(h.cityName + " - " + s + " - "+ h.cityName.equals(s));
        while( u < V && !h.cityName.equals(s)){
            // System.out.println(h.cityName);
            // System.out.println(u + "-" + h.pos);
            if(u == h.pos){
                System.out.print("-"+h.cityName+"-");
                // System.out.print(dist[h.pos]);
                h = parent[h.pos];
                u=0;
            }
            u++;
        }
        System.out.print("-"+s);
        System.out.print("]");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println("Pesos: ");
        // for(int y = 0; y< dist.length; y++){
        //     System.out.println(s + " -> " + adj[y].element().cityName + " : "+ dist[y]);
        // }
        // System.out.print("]");
    }
}
