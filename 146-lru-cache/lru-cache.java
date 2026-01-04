class LRUCache {

    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    Node head =new Node(-1,-1);
    Node tail=new Node(-1,-1);
    int cap;
    Map<Integer,Node>mp=new HashMap<>();

    public LRUCache(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    private void addNode(Node newnode){
        Node temp=head.next;
        newnode.next=temp;
        newnode.prev=head;
        head.next=newnode;
        temp.prev=newnode;
    }
    private void deletenode(Node delnode){
        Node prevv=delnode.prev;
        Node nextt=delnode.next;
        prevv.next=nextt;
        nextt.prev=prevv;
    }
    public int get(int key) {
            if(mp.containsKey(key)){
            Node resnode=mp.get(key);
            int ans=resnode.val;
            mp.remove(key);
            deletenode(resnode);
            addNode(resnode);
            mp.put(key,head.next);
            return ans;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node curr=mp.get(key);
            mp.remove(key);
            deletenode(curr);
        }
      if(mp.size()==cap){
        mp.remove(tail.prev.key);
        deletenode(tail.prev);
      }
      addNode(new Node(key,value));
      mp.put(key,head.next);
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */