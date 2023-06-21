package petrov.task5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeBuilderUI extends JFrame {
    private TreePanel canvasPanel;
    private JButton buildButton;
    private JButton flipButton;
    private JTextField inputField;
    private Tree<Object> tree;

    public TreeBuilderUI() {
        setTitle("Tree Builder");
        tree = new Tree<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        canvasPanel = new TreePanel();
        add(canvasPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        inputField = new JTextField(30);
        controlPanel.add(inputField);
        JButton buildButton = new JButton("Build Tree");

        buildButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                Tree.TreeNode<Object> rootNode = parseTree(input);
                tree.root = rootNode; // Assign the root node to the tree
                canvasPanel.repaint();
            }
        });
        controlPanel.add(buildButton);

        flipButton = new JButton("Flip Tree");
        flipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tree != null) {
                    tree.flipTree();
                    canvasPanel.repaint();
                }
            }
        });
        controlPanel.add(flipButton);

        add(controlPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class TreePanel extends JPanel {
        private static final int NODE_WIDTH = 40;
        private static final int NODE_HEIGHT = 40;
        private static final int HORIZONTAL_GAP = 30;
        private static final int VERTICAL_GAP = 60;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (tree != null) {
                drawTree(g, tree.root, getWidth() / 2, 50, NODE_WIDTH, NODE_HEIGHT);
            }
        }

        private void drawTree(Graphics g, Tree.TreeNode<Object> node, int x, int y, int width, int height) {
            g.setColor(Color.BLACK);
            g.drawOval(x - width / 2, y - height / 2, width, height);
            g.drawString(node.value.toString(), x - 5, y + 5);

            List<Tree.TreeNode<Object>> children = node.getChildren();
            int childCount = children.size();
            if (childCount > 0) {
                int startX = x - (childCount * width + (childCount - 1) * HORIZONTAL_GAP) / 2;
                int startY = y + height / 2 + VERTICAL_GAP;

                for (Tree.TreeNode<Object> child : children) {
                    int childX = startX + width / 2;
                    int childY = startY + height / 2;

                    g.drawLine(x, y + height / 2, childX, childY);

                    drawTree(g, child, childX, childY, width, height);

                    startX += width + HORIZONTAL_GAP;
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 600);
        }
    }

    private Tree.TreeNode<Object> parseTree(String input) {
        input = input.trim();

        if (input.isEmpty()) {
            return null;
        }

        Stack<Tree.TreeNode<Object>> stack = new Stack<>();
        Tree.TreeNode<Object> root = null;
        int i = 0;

        while (i < input.length()) {
            char c = input.charAt(i);

            if (c == '(') {
                i++;
                int j = i;
                int parenthesesCount = 1;

                while (parenthesesCount > 0 && j < input.length()) {
                    if (input.charAt(j) == '(') {
                        parenthesesCount++;
                    } else if (input.charAt(j) == ')') {
                        parenthesesCount--;
                    }
                    j++;
                }

                String childInput = input.substring(i, j);
                Tree.TreeNode<Object> child = parseTree(childInput);

                if (stack.isEmpty()) {
                    root = child;
                } else {
                    Tree.TreeNode<Object> parent = stack.peek();
                    parent.addChild(child);
                }

                i = j;
            } else if (c == ',' || c == ')') {
                i++;
            } else {
                int j = i;
                while (j < input.length() && input.charAt(j) != '(' && input.charAt(j) != ')' && input.charAt(j) != ',') {
                    j++;
                }

                String valueStr = input.substring(i, j).trim();
                Tree.TreeNode<Object> node = new Tree.TreeNode<>(valueStr);

                if (stack.isEmpty()) {
                    root = node;
                } else {
                    Tree.TreeNode<Object> parent = stack.peek();
                    parent.addChild(node);
                }

                i = j;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TreeBuilderUI();
            }
        });
    }
}
