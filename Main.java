public class Main{
    public static void main(String[] args) {

        Graph g = new Graph(21);

        //Init - 0
        g.addEdge(0, "Oradea", 1, 0);

        //Oradea - 1
        g.addEdge(1, "Zerind", 2, 71);
        g.addEdge(1, "Sibiu", 3, 151);

        //Zerind - 2
        g.addEdge(2, "Arad", 4, 75);
        g.addEdge(2, "Oradea", 1, 71);

        //Sibiu - 3
        g.addEdge(3, "Rimnicu Vilcea", 6, 80);
        g.addEdge(3, "Fagaras", 7, 99);
        g.addEdge(3, "Arad", 4, 140);
        g.addEdge(3, "Oradea", 1, 151);

        //Arad - 4
        g.addEdge(4, "Timisoara", 5, 118);
        g.addEdge(4, "Zerind", 2, 75);
        g.addEdge(4, "Sibiu", 3, 140);

        //Timisoara - 5
        g.addEdge(5, "Arad", 4, 118);
        g.addEdge(5, "Lugoj", 8, 111);

        //Rimnicu Vilcea - 6
        g.addEdge(6, "Craiova", 9, 146);
        g.addEdge(6, "Sibiu", 3, 80);
        g.addEdge(6, "Pitesti", 10, 97);

        //Fagaras - 7
        g.addEdge(7, "Sibiu", 3, 99);
        g.addEdge(7, "Bucharest", 11, 211);

        //Lugoj - 8
        g.addEdge(8, "Timisoara", 5, 111);
        g.addEdge(8, "Mehadia", 12, 70);

        //Craiova - 9
        g.addEdge(9, "Pitesti", 10, 138);
        g.addEdge(9, "Rimnicu Vilcea", 6, 146);
        g.addEdge(9, "Dobreta", 15, 120);

        //Pitesti - 10
        g.addEdge(10, "Rimnicu Vilcea", 6, 97);
        g.addEdge(10, "Craiova", 9, 138);
        g.addEdge(10, "Bucharest", 11, 101);

        //Bucharest - 11
        g.addEdge(11, "Fagaras", 7, 211);
        g.addEdge(11, "Pitesti", 10, 101);
        g.addEdge(11, "Giurgiu", 13, 90);
        g.addEdge(11, "Urziceni", 14, 85);

        //Mehadia - 12
        g.addEdge(12, "Lugoj", 8, 70);
        g.addEdge(12, "Dobreta", 15, 75);

        //Giurgiu - 13
        g.addEdge(13, "Bucharest", 11, 90);

        //Urziceni - 14
        g.addEdge(14, "Bucharest", 11, 85);
        g.addEdge(14, "Hirsova", 16, 98);
        g.addEdge(14, "Vaslui", 17, 142);

        //Dobreta - 15
        g.addEdge(15, "Mehadia", 12, 75);
        g.addEdge(15, "Craiova", 9, 120);

        //Hirsova - 16
        g.addEdge(16, "Urziceni", 14, 98);
        g.addEdge(16, "Eforie", 18, 86);

        //Vaslui - 17
        g.addEdge(17, "Urziceni", 14, 142);
        g.addEdge(17, "Iasi", 19, 92);

        //Eforie - 18
        g.addEdge(18, "Hirsova", 16, 86);

        //Iasi - 19
        g.addEdge(19, "Vaslui", 17, 92);
        g.addEdge(19, "Neamt", 20, 87);

        //Neamt - 20
        g.addEdge(20, "Iasi", 19, 87);

        String start =args[0];
        String end = args[1];
        System.out.println(start + " - "+ end);
        // try{
            if(g.findEdge(start) == 0 || g.findEdge(end) == 0){
                System.out.println("Cidade não encontrada");
            }
            else{
                g.BFS(start, end);
            }
        // }catch(Exception e){
        //     System.out.println(e);
        // }
        

        
             
    }

}