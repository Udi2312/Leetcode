class LRUCache {
    List<Pair> arr;
    int size;
    class Pair{
        int k;
        int v;
        Pair(int k, int v){
            this.k = k;
            this.v = v;
        }
    }
    public LRUCache(int capacity) {
        arr = new ArrayList<>();
        size = capacity;
    }
    
    public int get(int key) {
        for(int i = 0; i<arr.size(); i++){
            if(arr.get(i).k == key){
                Pair p = arr.remove(i);
                arr.add(p);
                return p.v;
            }
    }
             return -1;
    }
    public void put(int key, int value) {
        for(int i = 0; i<arr.size(); i++){
            if(arr.get(i).k == key){
               arr.remove(i);
               arr.add(new Pair(key,value));
               return;
            }
        }
        if(arr.size() == size) arr.remove(0);
        arr.add(new Pair(key,value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */