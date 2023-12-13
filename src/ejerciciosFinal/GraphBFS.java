    package ejerciciosFinal;


    import java.util.*;


    class GraphBFS {
        private int vertices;
        private LinkedList<Integer>[] adjacencyList;

        GraphBFS(int vertices) {
            this.vertices = vertices;
            this.adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; ++i) {
                this.adjacencyList[i] = new LinkedList<>();
            }
        }

        void addEdge(int v, int w) {
            this.adjacencyList[v].add(w);
        }

        public static GraphBFS createGraph() {
            GraphBFS graph = new GraphBFS(8);
            graph.addEdge(0, 3);
            graph.addEdge(3, 4);
            graph.addEdge(3, 5);
            graph.addEdge(5, 6);
            graph.addEdge(6, 7);
            graph.addEdge(4, 3);
            graph.addEdge(4, 6);
            graph.addEdge(1, 0);
            graph.addEdge(1, 2);
            graph.addEdge(1, 4);

            return graph;
        }

        void reconstructPath(int startVertex, int goalVertex, Map<Integer, Integer> parent) {
            List<Integer> path = new ArrayList<>();
            int currentVertex = goalVertex;

            while (currentVertex != startVertex) {
                path.add(currentVertex);
                currentVertex = parent.get(currentVertex);
            }

            path.add(startVertex);
            Collections.reverse(path);

            System.out.println("Camino reconstruido: " + path);
        }

        boolean bfs(int startVertex, int goalVertex) {
            Queue<Integer> queue = new LinkedList<>();//Creo una cola
            Set<Integer> visited = new HashSet<>();// creo un conjunto para agregar los visitados
            Map<Integer, Integer> parent = new HashMap<>();//Es un diccionario que almacena el padre de cada nodo

            queue.add(startVertex);//Agrego a la cola al primer nodo
            visited.add(startVertex);//Ya lo marco como visitado

            while (!queue.isEmpty()) {//Mientras la cola no este vacia avanzo.
                int currentVertex = queue.poll();//Desencolo el primer elemento

                if (currentVertex == goalVertex) {//Si este es igual al elemento que estoy buscando retorno True
                    reconstructPath(startVertex, goalVertex, parent);
                    return true;
                }

                LinkedList<Integer> neighbors = adjacencyList[currentVertex];//Me traigo el vecindario del nodo a analizar
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {//aca basicamente me fijo si el vecino este ya se encuentra en visitado, si esta en visitado no lo agrego a la cola. Sino si
                        queue.add(neighbor);//Lo agergo a la cola
                        visited.add(neighbor);//Lo marco como visitado para evitar duplicidad
                        parent.put(neighbor, currentVertex);// Agrego al diccionario el padre
                    }
                }
            }

            System.out.println("No se encontró un camino.");
            return false;
        }




        public static void main(String[] args) {
            GraphBFS graph = createGraph();
            System.out.println("Grafo creado:");
            int startVertex = 0;
            int goalVertex = 6;

            System.out.println("Realizando BFS desde " + startVertex + " hasta " + goalVertex);
            System.out.println(graph.bfs(startVertex, goalVertex));
        }
    }
