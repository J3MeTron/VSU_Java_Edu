package petrov;

public interface Graph {
    void addEdge(int source, int destination);

    boolean satisfiesHandshakingTheory(int N);
}
