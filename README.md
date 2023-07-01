# Dijkstra-Search
Algoritmo de busca por custo uniforme utilizado para resolver o problema das cidades feito em Java
<img src='https://github.com/LeonardoFariaOliveira/Breadth-Search/assets/66142358/e4f1aed1-1857-45f5-840a-cf4ba27374d0'/>


# Problema
O problema consistia em encontrar o menor caminho possível para a cidade indicada, recebendo a cidade de início(s) e fim(e) no parametro na hora de executar
conforme as cidades do mapa utilizando o custo associado para encontra o caminho menor

# Solução
Primeiro mapeei o mapa em grafos, onde cada cidade é um nó e possui nós vizinhos(adjacentes). Sendo assim criei uma classe Nó que possui:
* nodeName(nome do nó atual)
* cityName(o nome do vizinho)
* weight(peso para ir para o vizinho)
* pos(posição do vizinho)
  
Sendo assim se um nó possui 4 vizinhos, eu crio 4 objetos nó com o mesmo nodeName porém com cityName, pos e weight diferentes. Exemplo:
Arad possui 3 vizinhos então crio 3 objetos passando o mesmo nome e a mesma posição no array de nós
<img src='https://github.com/LeonardoFariaOliveira/Dijkstra-Search/assets/66142358/7599c022-b66d-4943-8299-bd73e2642d1b'/>


Depois de criar o grafo, apliquei o algoritmo de busca por custo uniforme usando as classes: ListIterator, LinkedList e Queue do Java

## Instalação

```bash
$ git clone https://github.com/LeonardoFariaOliveira/Dijkstra-Search
$ cd Dijkstra-Search
```

## Running the app

```bash
$ javac Main.java
# java Main <cidade-de-partida> <cidade-de-destino>
$ java Main Arad Bucharest
```
