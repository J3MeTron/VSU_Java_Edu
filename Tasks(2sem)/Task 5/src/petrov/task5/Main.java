package petrov.task5;

public class Main {
    public static void main(String[] args) {

        Tree<Object> tree = new Tree<>();

// Add some nodes
        Tree.TreeNode<Object> root = new Tree.TreeNode<>("прадед");
        root.addChild(new Tree.TreeNode<>("дед 1"));
        root.addChild(new Tree.TreeNode<>("дед 2"));
        Tree.TreeNode<Object> node4 = new Tree.TreeNode<>("дед 3");
        node4.addChild(new Tree.TreeNode<>("сын 1"));
        root.addChild(node4);
        Tree.TreeNode<Object> node5 = new Tree.TreeNode<>("сын 2");
        node5.addChild(new Tree.TreeNode<>("Внук 1"));
        node5.addChild(new Tree.TreeNode<>("Внук 2"));
        node5.addChild(new Tree.TreeNode<>("Внук 3"));
        node4.addChild(node5);
        Tree.TreeNode<Object> node6 = new Tree.TreeNode<>(1900);
        root.addChild(node6);

        tree.root = root;
        tree.outputTree();
        System.out.print("_________________________________\n");
// Flip the tree
        tree.flipTree();

// Print the tree
        tree.outputTree();
    }
}