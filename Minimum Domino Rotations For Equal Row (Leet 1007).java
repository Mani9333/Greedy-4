//Time- O(n)
//Space- O(1)

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if (tops.length != bottoms.length){
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int m = tops.length;
        int n = bottoms.length;
        int maxEle = tops[0];
        for(int i = 0; i < m; i++){
            map.put(tops[i], map.getOrDefault(tops[i],0)+1);
            if (map.get(maxEle) < map.get(tops[i])){
                maxEle = tops[i];
            }
            map.put(bottoms[i], map.getOrDefault(bottoms[i],0)+1);
            if (map.get(maxEle) < map.get(bottoms[i])){
                maxEle = bottoms[i];
            }
            if (map.get(maxEle) >= n){
                break;
            }
        }
        int t = 0;
        int b = 0;
        for(int i =0; i < m; i++){
            if (tops[i] != maxEle && bottoms[i] != maxEle){
                return -1;
            }
            if (tops[i] != maxEle){
                t++;
            }
            if (bottoms[i] != maxEle){
                b++;
            }
        }
        
        return Math.min(t,b);
        
    }
}



//Time- O(n)
//Space- O(1)

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if (tops.length != bottoms.length){
            return -1;
        }
        
        int n = tops.length;
        if (getval(tops, bottoms, tops[0]) != -1){
            return getval(tops, bottoms, tops[0]);
        }
        return getval(tops, bottoms, bottoms[0]);
        
    }
    
    private int getval(int[] tops, int[] bottoms, int target){
        int t = 0;
        int b = 0;
        for(int i = 0; i < tops.length; i++){
            if (tops[i] != target && bottoms[i] != target){
                return -1;
            }
            if (tops[i] != target){
                t++;
            }
            if (bottoms[i] != target){
                b++;
            }
        }
        return Math.min(t,b);
    }
}
