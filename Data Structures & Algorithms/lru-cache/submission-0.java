
class LRUCache {
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    private int cap; //size of cache
    private Map<Integer,Node> map; //hashmap
    private Node left;
    private Node right;

    public LRUCache(int cap) {
        this.cap=cap;
        map=new HashMap<>();
        //Dummy nodes
        left=new Node(0,0);
        right=new Node(0,0);

        left.next=right;
        right.prev=left;
    }

    //Remove a node from the linked list
    private void remove(Node node){
        Node previous=node.prev;
        Node nxtNode=node.next;

        previous.next=nxtNode;
        nxtNode.prev=previous;
    }

    //Insert a node just before the right dummy(MRU)
    private void insert(Node node){
        Node previous=right.prev;

        previous.next=node;
        node.prev=previous;

        node.next=right;
        right.prev=node;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);

            remove(node);
            insert(node);

            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);

            //update the value
            node.value=value;

            remove(node);
            insert(node);
        }
        else{
            Node node=new Node(key,value);

            map.put(key,node);
            insert(node);
            if(map.size()>cap){
                Node lru=left.next;
                remove(lru);
                map.remove(lru.key);
            }
        }
    }
}
