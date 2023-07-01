public class Main{
    public static void main(String[] args) {

        Graph g = new Graph(21);

        //Init - 0
        g.addEdge(0, "Init", "Oradea", 1, 0);

        //Oradea - 1
        g.addEdge(1, "Oradea", "Sibiu", 3, 151);
        g.addEdge(1, "Oradea", "Zerind", 2, 71);

        //Zerind - 2
        g.addEdge(2, "Zerind", "Arad", 4, 75);
        g.addEdge(2, "Zerind", "Oradea", 1, 71);

        //Sibiu - 3
        g.addEdge(3, "Sibiu", "Rimnicu Vilcea", 6, 80);
        g.addEdge(3, "Sibiu", "Arad", 4, 140);
        g.addEdge(3, "Sibiu", "Fagaras", 7, 99);
        g.addEdge(3, "Sibiu", "Oradea", 1, 151);

        //Arad - 4
        g.addEdge(4, "Arad", "Sibiu", 3, 140);
        g.addEdge(4, "Arad", "Timisoara", 5, 118);
        g.addEdge(4, "Arad", "Zerind", 2, 75);

        //Timisoara - 5
        g.addEdge(5, "Timisoara", "Arad", 4, 118);
        g.addEdge(5, "Timisoara", "Lugoj", 8, 111);

        //Rimnicu Vilcea - 6
        g.addEdge(6, "Rimnicu Vilcea", "Craiova", 9, 146);
        g.addEdge(6, "Rimnicu Vilcea", "Pitesti", 10, 97);
        g.addEdge(6, "Rimnicu Vilcea", "Sibiu", 3, 80);

        //Fagaras - 7
        g.addEdge(7, "Fagaras", "Bucharest", 11, 211);
        g.addEdge(7, "Fagaras", "Sibiu", 3, 99);

        //Lugoj - 8
        g.addEdge(8, "Lugoj", "Mehadia", 12, 70);
        g.addEdge(8, "Lugoj", "Timisoara", 5, 111);

        //Craiova - 9
        g.addEdge(9, "Craiova", "Dobreta", 15, 120);
        g.addEdge(9, "Craiova", "Pitesti", 10, 138);
        g.addEdge(9, "Craiova", "Rimnicu Vilcea", 6, 146);

        //Pitesti - 10
        g.addEdge(10, "Pitesti", "Bucharest", 11, 101);
        g.addEdge(10, "Pitesti", "Craiova", 9, 138);
        g.addEdge(10, "Pitesti", "Rimnicu Vilcea", 6, 97);

        //Bucharest - 11
        g.addEdge(11, "Bucharest", "Fagaras", 7, 211);
        g.addEdge(11, "Bucharest", "Giurgiu", 13, 90);
        g.addEdge(11, "Bucharest", "Pitesti", 10, 101);
        g.addEdge(11, "Bucharest", "Urziceni", 14, 85);

        //Mehadia - 12
        g.addEdge(12, "Mehadia", "Dobreta", 15, 75);
        g.addEdge(12, "Mehadia", "Lugoj", 8, 70);

        //Giurgiu - 13
        g.addEdge(13, "Giurgiu", "Bucharest", 11, 90);

        //Urziceni - 14
        g.addEdge(14, "Urziceni", "Bucharest", 11, 85);
        g.addEdge(14, "Urziceni", "Hirsova", 16, 98);
        g.addEdge(14, "Urziceni", "Vaslui", 17, 142);

        //Dobreta - 15
        g.addEdge(15, "Dobreta", "Craiova", 9, 120);
        g.addEdge(15, "Dobreta", "Mehadia", 12, 75);

        //Hirsova - 16
        g.addEdge(16, "Hirsova", "Eforie", 18, 86);
        g.addEdge(16, "Hirsova", "Urziceni", 14, 98);

        //Vaslui - 17
        g.addEdge(17, "Vaslui", "Iasi", 19, 92);
        g.addEdge(17, "Vaslui", "Urziceni", 14, 142);

        //Eforie - 18
        g.addEdge(18, "Eforie", "Hirsova", 16, 86);

        //Iasi - 19
        g.addEdge(19, "Iasi", "Neamt", 20, 87);
        g.addEdge(19, "Iasi", "Vaslui", 17, 92);

        //Neamt - 20
        g.addEdge(20, "Neamt", "Iasi", 19, 87);

        String start =args[0];
        String end = args[1];
        System.out.println(start + " -> "+ end);
        
        if(g.findNode(start).pos == 0 || g.findNode(end).pos == 0){
            System.out.println("Cidade não encontrada");
        }
        else{
            g.DKS(start, end);
        }
        
        

        
             
    }

}