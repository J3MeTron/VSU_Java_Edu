package petrov.task5;
import java.util.List;
import java.util.ArrayList;

public class Tree<T> {

    public TreeNode<T> root; //создаем корень

    public static class TreeNode<T> {
        private T value;
        private List<TreeNode<T>> children = new ArrayList<>();

        public TreeNode(T value) {
            this.value = value;
        }

        public void addChild(TreeNode<T> child) {
            children.add(child);
        }

        public List<TreeNode<T>> getChildren() {
            return children;
        }
    }

    public void flipTree() {
        flipNode(root);
    }

    private void flipNode(TreeNode<T> node) {
        List<TreeNode<T>> children = node.getChildren();
        int left = 0;
        int right = children.size() - 1;

        while (left < right) {
            TreeNode<T> temp = children.get(left);
            children.set(left, children.get(right));
            children.set(right, temp);

            left++;
            right--;
        }

        for (TreeNode<T> child : children) {
            flipNode(child);
        }
    }
    public void outputTree() {
        outputNode(root, 0);
    }

    private void outputNode(TreeNode<T> node, int depth) {
        if (node == null) {
            return;
        }

        // Indent based on the depth
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }

        // Print the node value
        System.out.println(node.value);

        // Recursively print the children
        for (TreeNode<T> child : node.getChildren()) {
            outputNode(child, depth + 1);
        }
    }
}