package petrov;

import java.util.*;

public class HandshakingGraph implements Graph {
    private int vertices; // количество вершин в графе
    private List<List<Integer>> adjacencyList; // список смежности для хранения связей

    public HandshakingGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    public boolean hasEdge(int source, int destination) {
        return adjacencyList.get(source).contains(destination);
    }

    public boolean satisfiesHandshakingTheory(int N) {
        // Проверяем для каждой вершины в графе
        for (int vertex = 0; vertex < vertices; vertex++) {
            // Создаем массив для отслеживания посещенных вершин
            boolean[] visited = new boolean[vertices];
            // Создаем очередь для обхода графа в ширину
            Queue<Integer> queue = new LinkedList<>();
            // Добавляем текущую вершину в очередь и помечаем ее как посещенную
            queue.add(vertex);
            visited[vertex] = true;
            int level = 0; // текущий уровень

            while (!queue.isEmpty()) {
                int size = queue.size();
                // Обрабатываем все вершины текущего уровня
                while (size > 0) {
                    int currentVertex = queue.poll();
                    // Проверяем, если уровень текущей вершины превышает N-1, возвращаем false
                    if (level > N - 1) {
                        return false;
                    }
                    // Добавляем всех непосещенных соседей текущей вершины в очередь
                    for (int neighbor : adjacencyList.get(currentVertex)) {
                        if (!visited[neighbor]) {
                            queue.add(neighbor);
                            visited[neighbor] = true;
                        }
                    }
                    size--;
                }
                level++;
            }
            // Проверяем, что все вершины были достигнуты
            for (boolean v : visited) {
                if (!v) {
                    return false;
                }
            }
        }
        return true;
    }
}