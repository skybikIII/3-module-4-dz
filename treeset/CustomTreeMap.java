package treeset;

import tree.Node;

public class CustomTreeMap<K, V> {

    private Node root = null;
    private int size = 0;

    class Node {
        public K key;
        public V value;
        public Node left = null;
        public Node right = null;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    /*private boolean containsNodeRecursive(Node current, int data) {
      *  if (current == null)
      *      return false;
      *  if (data == current.data)
      *      return true;
      *  return data < current.data
      *          ? containsNodeRecursive(current.left, data)
      *          : containsNodeRecursive(current.right, data);
    }*/

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object get(K key) {
        Node node = findNode(key);
        return node.value;
    }


    private Node findNode(K key) {
        if (key == null)
            throw new NullPointerException();
        Comparable<? super K> k = (Comparable<? super K>) key;

        Node node = root;
        while (node != null) {
            int cmp = k.compareTo(key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else
                return node;
        }
        return null;
    }

    public Object put(K key, V value) {
        if (key == null)
            throw new NullPointerException();
        if (root == null) {
            root = new Node(key, value);
            size++;
            return value;
        }
        return putHelper(root, key, value);
    }

    private V putHelper(Node node, K key, V value) {
        Comparable<? super K> k = (Comparable<? super K>) key;
        int cmp = k.compareTo(node.key);
        if (cmp < 0) {
            if (node.left == null) {
                node.left =  new Node(key, value);
                size++;
                return node.left.value;
            } else {
                return putHelper(node.left, key, value);
            }
        }
        if (cmp > 0) {
            if (node.right == null) {
                node.right =  new Node(key, value);
                size++;
                return node.right.value;
            } else {
                return putHelper(node.right, key, value);
            }
        }
        V oldValue = node.value;
        node.value = value;
        return oldValue;
    }

    public V remove(K key) {
        V value = (V) get(key);
        root = removeRecursive(key);
        return value;
    }

    private  Node removeRecursive(K key) {
        Node node = findNode(key);
        if(node.left == null && node.right == null) {
            node = null;
            size--;
            return node;
        }
        if(node.right == null) {
            node = node.left;
            size--;
            return node;
        }
        if(node.left == null) {
            node = node.right;
            size--;
            return node;
        }
        node = findMin(node.right);
        size--;
        return node;
    }

    private Node findMin(Node root) {
       return root.left == null ? root : findMin(root.left);
    }

    public void clear() {
        size = 0;
        root = null;
    }

}
