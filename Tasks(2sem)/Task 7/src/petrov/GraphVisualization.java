package petrov;

import javax.swing.*;
import java.awt.*;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class GraphVisualization extends JFrame {
    private JTextField verticesField;
    private JTextField edgesField;
    private JTextField nValueField;
    private JTextArea resultArea;
    private mxGraph graph;

    public GraphVisualization() {
        setTitle("petrov.Graph Visualization");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel verticesLabel = new JLabel("Количество вершин:");
        verticesField = new JTextField();
        inputPanel.add(verticesLabel);
        inputPanel.add(verticesField);

        JLabel edgesLabel = new JLabel("Количество ребер:");
        edgesField = new JTextField();
        inputPanel.add(edgesLabel);
        inputPanel.add(edgesField);

        JLabel nValueLabel = new JLabel("Значение N:");
        nValueField = new JTextField();
        inputPanel.add(nValueLabel);
        inputPanel.add(nValueField);

        JButton createGraphButton = new JButton("Создать граф");
        createGraphButton.addActionListener(e -> createGraph());
        inputPanel.add(createGraphButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        graph = new mxGraph();
        mxGraphComponent graphComponent = new mxGraphComponent(graph);

        add(inputPanel, BorderLayout.NORTH);
        add(graphComponent, BorderLayout.CENTER);
        add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        setVisible(true);
    }

    private void createGraph() {
        try {
            int vertices = Integer.parseInt(verticesField.getText());
            int edges = Integer.parseInt(edgesField.getText());
            int nValue = Integer.parseInt(nValueField.getText());

            HandshakingGraph handshakingGraph = new HandshakingGraph(vertices);

            for (int i = 0; i < edges; i++) {
                String input = JOptionPane.showInputDialog("Введите путь (формат: исходный пункт назначения):");
                String[] values = input.split(" ");
                int source = Integer.parseInt(values[0]);
                int destination = Integer.parseInt(values[1]);
                handshakingGraph.addEdge(source, destination);
            }

            boolean satisfiesTheory = handshakingGraph.satisfiesHandshakingTheory(nValue);
            String result = "График удовлетворяет теории рукопожатия для N = " + nValue + ": " + satisfiesTheory;
            resultArea.setText(result);

            graph.getModel().beginUpdate();
            graph.removeCells(graph.getChildCells(graph.getDefaultParent(), true, true));
            Object[] vertexObjects = new Object[vertices];

            for (int i = 0; i < vertices; i++) {
                vertexObjects[i] = graph.insertVertex(graph.getDefaultParent(), null, Integer.toString(i), 20 + i * 80, 150, 30, 30);
            }

            for (int i = 0; i < vertices; i++) {
                for (int j = i + 1; j < vertices; j++) {
                    if (handshakingGraph.hasEdge(i, j) || handshakingGraph.hasEdge(j, i)) {
                        graph.insertEdge(graph.getDefaultParent(), null, "", vertexObjects[i], vertexObjects[j]);
                    }
                }
            }

            graph.getModel().endUpdate();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Неверный ввод! Пожалуйста, введите целочисленные значения для вершин, ребер и N.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Произошла ошибка: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GraphVisualization::new);
    }
}
