


// skipping the elements that are not there
// Time: O(m) + O(nlogk)
// Space: O(26) --> O(1) keys; values O(m)

class Solution {
    public int shortestWay(String source, String target) {
        if (source.length() == 0 && target.length() == 0) return -1;
        if (source.equals(target)) return 1;
        HashMap <Character, List<Integer>> hm = new HashMap<>();
        for(int i = 0; i < source.length(); i++){ // O(m)
            char c = source.charAt(i);
            if (!hm.containsKey(c)){
                hm.put(c,new ArrayList<>());
            }
            hm.get(c).add(i);
        }
        
        int s = 0;
        int t = 0;
        int count = 1;
        // O(m) + O(nlogk)
        while (t < target.length()){ // n
            char tChar = target.charAt(t);
            if (!hm.containsKey(tChar)){
                return -1;
            }
            
            List<Integer> li = hm.get(tChar); 
            int k = Collections.binarySearch(li, s);  // log(k), where k is the avg no of indexes in the li
            // only two cases either size (not there) and other is (exact or nearest greater number)
            if (k < 0){
                k = -k-1;
            }
            if (k == li.size()){
                count++;
                s = 0;
            }else{
                s = li.get(k);
                s++;
                t++;
            }
        }
        
        return count;
    }
}




///////////////////

class Solution {
    public int shortestWay(String source, String target) {
        int s = 0;
        int t = 0;
        HashSet <Character> hs = new HashSet<>();
        for (int i = 0; i < source.length(); i++){
            hs.add(source.charAt(i));
        }
        int count = 1;
        while (t < target.length()){
            if (s == source.length()){
                count++;
                s = 0;
            }
            char c = target.charAt(t);
            if (!hs.contains(c)){
                return -1;
            }
            if (source.charAt(s) == target.charAt(t)){
                s++;
                t++;
            }else{
                s++;
            }
            
        }
        return count;
    }
}

///////////////////

class Solution {
    public int shortestWay(String source, String target) {
        int s = 0;
        int t = 0;
        int count = 0;
        double d;
        while (t < target.length()){
            int temp = t;
            count ++;
            while(s < source.length() && t < target.length()){
                if(source.charAt(s) == target.charAt(t)){
                    s++;
                    t++;
                }else{
                    s++;
                }
            }
            if (temp == t){
                return -1;
            }
            s=0;
            
        }
        return count;
    }
}
