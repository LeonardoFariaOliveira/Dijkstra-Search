
import java.util.*;


class Graph {
    public int V; // Numero de nós que o grafo irá possuir
    public int dist[]; //Array que armazena as distancias
    public LinkedList<No>[] adj; // Lista dos nós vizinho, ou seja aqueles que virão depois
    public boolean[] visited; //Lista de visitados
    public int finalWeight; //Peso final somado

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[V];
        visited = new boolean[V];
        dist = new int[V];
        // No[] parent = new No[V];
        for (int i = 0; i < V; i++) {
            //Seta a lista adjacente como um nó vazio
            adj[i] = new LinkedList<No>();

            //Seta a lista de nós visitados inteira como false
            visited[i] = false;

            //Seta todas as posições do vetor de distancias com o maior valor que um 
            //inteiro consegue armazenar
            //como se fosse infinito
            dist[i] = Integer.MAX_VALUE;
        }
    }

    // Função que adiciona um nó ao grafo
    void addEdge(int v, String nodeName, String cityName, int nextIndex, int weight) {
        adj[v].add(new No(nextIndex, nodeName, cityName, weight));
    }


    // Função que procura a posição do vetor de nós apartir do nome de uma cidade
    int findEdgePos(String s) {
        // System.out.println(s);
        for(int i = 0; i <= adj.length; i++){
            if(adj[i].element().nodeName.equals(s)){
                return i;
            }
        }
        return 0;
    }

    // Função que busca o nó atual a partir do nome de uma cidade
    No findNode(String s) {
        for(int i = 0; i <= adj.length; i++){
            if(adj[i].element().nodeName.equals(s)){
                return adj[i].element();
            }
        }
        return null;
    }

    // Função que aplica o algoritmo de Dijkstra(busca de custo uniforme) no grafo a partir do nome das cidades
    void DKS(String s, String e) { 

        //Seta a lista de pais que será usada para descobrir o caminho certo
        No[] parent = new No[V];

        //Seta o auxiliar que será usado para atualizar a lista de pais
        No aux_parent;

        //Seta esse auxiliar que indica se já chegou ao objetivo
        boolean find = false;

        //Seta essa pilha que guardará todos os nós visitados
        Stack<No> pilha = new Stack<No>();

        //Seta esse auxiliar que ajudará a montar a variável que exibirá o caminho
        Stack<No> auxPath = new Stack<No>();

        //Pilha que exibirá o caminho
        Stack<String> path = new Stack<String>();

        //Seta a variável pathNo para usa-la ao inserir o caminho na variável path
        No pathNo;
        
        // Create a queue for BFS
        Queue<No> queue = new LinkedList<No>();
        
        // System.out.println(p);
        No no = findNode(s);

        //Encontra a posição do nó atual
        int nodePos = findEdgePos(no.nodeName);

        // Marca o nó atual como visitado
        visited[nodePos] = true;

        //Adiciona o nó atual na fila de nós
        queue.add(no);

        //Seta que o pai do proximo nó a ser visitado é o atual
        parent[no.pos] = no;

        // Seta distancia do primeiro nó até o proximo como 0
        dist[no.pos] = 0;
        
        System.out.print("Buscas: [");
        //Enquanto ainda tiver nós a serem visitados e a cidade não for encontrada ele executará
        while (!queue.isEmpty() && !find) {

            //Remove o topo da fila  para buscar o proximo nó
            no = queue.poll();

            //Adiciona ele na pilha
            pilha.add(no);

            //Seta o peso final como o peso até o proximo nó
            finalWeight = dist[no.pos];

            //Exibe para possuir uma referência nas buscas
            System.out.print(no.cityName + "-");

            //Atribui o no ao auxiliar para poder utiliza-lo depois
            aux_parent = no;

            //Verifica se o caminho foi encontrado
            if (no.cityName.equals(e)) {
                
                //Adiciona o último elemento visitado no auxiliar para poder usa-lo
                auxPath.add(pilha.lastElement());

                //Adiciona o ultimo elemento na pilha do caminho pois será guardado e exbido ao contrario
                path.add(e);

                //Enquanto ainda tiver visitados executará
                while(!pilha.isEmpty()){

                    //Atribui o pai do ultimo elemento da pilha auxiliar na variável pathNo
                    pathNo = parent[auxPath.lastElement().pos];

                    //Se o ultimo elemento na pilha de visitados for igual ao filho do pai setado na variável pathNo
                    if(pilha.lastElement().cityName.equals(pathNo.cityName)){
                        //Adiciona ao authPath para atualizar a variavel pathNo
                        auxPath.add(pathNo);

                        //Adiciona à variável que exibirá o caminho
                        path.add(pathNo.cityName);
                    }
                    //Desempilha a pilha de visitados
                    pilha.pop();
                    
                    //Resumo -> Ele verifica todos os visitados
                    //       -> Identifica o pai do ultimo elemento visitado
                    //       -> Filtra dos pais visitados qual deles é igual ao pai do ultimo elemento viitado 
                    //       -> Atribui esse pai para atualizar o valor da variável pathNo
                    //       -> Atribui o pai ao caminho certo
                    //       -> Tira esse elemento verificado da pilha de visitados
                
                }
                
                //Depois de adiciona o caminho inverso, ele adiciona por onde começou para exibir invertido depois
                path.add(s);

                //Seta a variável auxiliar find como verdadeiro para indicar que a cidade foi encontrada
                find = true;

            } else {

                //Seta a distancia para o nó como -1
                int edgeDistance = -1;

                //Seta a nova distancia para -1
                int newDistance = -1;

                //Pega todos os nós vizinho do proximo no
                Iterator<No> i = adj[no.pos].listIterator();

                //Enquanto ainda houver nós vizinho
                while (i.hasNext()) {

                    //Atribui o proximo nó vizinho na variável auxiliar n
                    No n = i.next();
                    
                    //Se o proximo nó não tiver sido visitado ou 
                    //a distancia do proximo nó vizinho
                    //for maior que a distancia do seu pai + seu peso
                    if (visited[n.pos] == false || dist[n.pos] > dist[no.pos] + n.weight) {

                        //Seta a distancia para o nó como o peso do proximo nó vizinho
                        edgeDistance = n.weight;
                        
                        //Seta a nova distancia como a distancia do nó pai + a distancia para o nó
                        newDistance = dist[no.pos] + edgeDistance;

                        //Se essa nova distancia for menor que a distancia para o nó
                        if (newDistance < dist[n.pos])
                            //Seta a distancia para o nó como essa nova distancia
                            dist[n.pos] = newDistance;
                        

                        //Diz que o no atual(aux_parent) é pai do proximo nó a ser visitado(n)
                        parent[n.pos] = aux_parent;

                        //Seta o proximo nó como visitado para não voltarmos a verificar esse novamente
                        visited[n.pos] = true;

                        //Adiciona na fila para ser visitado
                        queue.add(n);

                    }
                }
            }
        }
        System.out.println("]");
        System.out.println(" ");
        
        System.out.print("Caminho: [ ");
        //Enquanto todos os elementos do caminho não tiverem sido exibidos
        while(!path.isEmpty()){
            //Exibe e já desempilha para exibir o caminho inverso
            System.out.print(path.pop() + " ");
        }
        System.out.print("]");
    }
}
