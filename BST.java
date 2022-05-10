import java.security.InvalidParameterException;

public class BST<K extends Comparable <K>, V> {
    private Node root;
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        public Node (K key, V val){
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key, V val){
        Node m = new Node(key,val);

        if(root == null){
            root = m;
        } else {
            isMore(root, m);
        }
    }
    public Node isMore(Node root, Node node){
        if(root == null){
            return root;
        }
        else{
            if(root.key.compareTo(node.key)>=0){
                return isMore(root.left, node);
            }
            if(root.key.compareTo(node.key)<0){
                return isMore(root.right, node);
            }
        }
        return root;
    }

    public V get (K key) {
        if(root == null){
            return null;
        } else {
            return root.getValue();
        }

    }
    //changed from void to Node
    public Node delete (K key) {
        if (key == null){
            throw new InvalidParameterException("Key equals to nothing");
        }
        if (root.left == null && root.right == null){
            return null;
        }
        if (root.left == null && root.right != null) {
            return root.right;
        }
        if (root.left != null && root.right == null) {
            return root.left;
        }
    }

    public Iterable<K> iterator() {
        return null; //don't know
    }
}
