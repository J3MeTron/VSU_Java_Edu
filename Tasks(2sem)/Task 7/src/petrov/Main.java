package petrov;

import javax.swing.*;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    GraphVisualization graphVisualization = new GraphVisualization();
                    graphVisualization.setExtendedState(MAXIMIZED_BOTH);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
//В данном контексте, N обозначает значение,
// которое используется для проверки теории рукопожатий в графе.
// Оно указывает на ограничение на количество уровней обхода графа при проверке,
// что все вершины достижимы друг из друга через N или менее ребер.
// Если граф удовлетворяет теории рукопожатий для заданного значения N,
// это означает, что все вершины связаны друг с другом достаточным количеством ребер.