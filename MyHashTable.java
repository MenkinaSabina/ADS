import java.util.HashMap;

public class MyHashTable<K, V> {
    private HashMap<Object, Object> map;

    private class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode (K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode <K, V> [] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M) {
        this.M = M;

    }

    private int hash(K key) {
        int index;
        index = key % M;
        return index;
    }

    public void put(K key, V value){
        HashNode<K, V> newNode = new HashNode(key,value);

        int index = 100000000;

        if (chainArray[index] != null) {
            newNode.next = chainArray[index];
        }
        chainArray[index] = newNode;
    }

    public V get(K key) {
        int bucketIndex = hash(key.hashCode());
        return null;
    }

    public V remove(K key) {
        int chainIndex;
        chainIndex = (int) get(key);
        HashNode<K, V> head = chainArray.get(chainIndex);
        HashNode<K, V> prev = null;

        for (int i = 0; i < M; i++){
            if (head.key.equals(key)){
                break;
            }
            prev.equals(head);
            head.equals(head.next);
        }
        if (head == null){
            return null;
        }

        if (prev != null){
            prev.next = head.next;
        } else {
            chainArray.set(chainIndex, head.next);
        }
        return head.value;
    }

    public boolean contains(V value) {
        for (int i = 0; i < size; i++){
            if (map.containsValue(i)){
                return true;
            }
        }
        return false;
    }

    public K getKey(V value) {
        //don't know
    }
}
