import java.util.*;
class Feb8_2025 {
    Map<Integer, Integer> map;
    Map<Integer, PriorityQueue<Integer>> smallmap;
    public Feb8_2025() {
        map=new HashMap<>();
        smallmap=new HashMap<>();
    }
    
    public void change(int index, int number) {
        map.put(index,number);
        if(smallmap.containsKey(number)){
            smallmap.get(number).add(index);
        }else{
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(index);
            smallmap.put(number, pq);
        }
    }
    
    //lazy deletion method, delete if invalid index is found
    public int find(int number) {
        if(!smallmap.containsKey(number)){
            return -1;
        }else{
            PriorityQueue<Integer> indices = smallmap.get(number);
            while(!indices.isEmpty()){
                int idx=indices.peek();
                if(map.get(idx)==number){
                    return idx;
                }else{
                    indices.poll();
                }
            }
            return -1;
        }
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */