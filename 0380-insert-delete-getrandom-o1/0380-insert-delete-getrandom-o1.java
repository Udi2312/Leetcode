class RandomizedSet {
    Map<Integer , Integer> mp = new HashMap<>();
    List<Integer> arr = new ArrayList<>();
    public RandomizedSet() {
        mp =  new HashMap<>();
        arr =  new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(mp.containsKey(val)){
            return false;
        }
        arr.add(val);
        mp.put(val , arr.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
         if (!mp.containsKey(val)) {
            return false;
        }

        int index = mp.get(val);
        int last = arr.get(arr.size() - 1);
        arr.set(index, last);
        mp.put(last, index);
        arr.remove(arr.size() - 1);
        mp.remove(val);

        return true;
    }
    
    public int getRandom() {
         int index = (int)(Math.random() * arr.size());
        return arr.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */