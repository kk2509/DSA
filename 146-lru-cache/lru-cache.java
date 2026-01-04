class LRUCache {
    private final int capacity;
    private Map<Integer, Integer> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity, 0.16f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e){
                return map.size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */