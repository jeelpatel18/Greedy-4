//TC : O(n) - Iterating over tops and bottoms array

//SC : O(1)


class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
       
        if(tops == null || bottoms == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        
        int target1 = checkTarget(tops, bottoms, tops[0]);
        
        if(target1 != -1)
            return target1;
        
        return checkTarget(tops, bottoms, bottoms[0]);
    }
    public int checkTarget(int[] tops, int[] bottoms, int target){
        
        int topCounter = 0, bottomCounter = 0;
        
        for(int i = 0; i< tops.length; i++){
            if(tops[i] != target && bottoms[i] != target)   return -1;
            else if(tops[i] != target){
                topCounter++;
            } else if(bottoms[i] != target){
                bottomCounter++;
            }
        }
        
        
        return Math.min(topCounter, bottomCounter);
    }
}

/*
//TC : O(n + n) === O(n) - Iterating over tops and bottoms array

//SC : O(1) // Constant space even if using map


class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
       
        if(tops == null || bottoms == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        
        int target = -1;
        for(int i = 0; i< tops.length; i++){
            map.put(tops[i], map.getOrDefault (tops[i], 0) + 1 );
            int topCt = map.get(tops[i]);
            
            if(topCt >= tops.length){
                target = tops[i];
                break;
            }
            map.put(bottoms[i], map.getOrDefault (bottoms[i], 0) + 1 );
            int bottomCt = map.get(bottoms[i]);
            
            if(bottomCt >= bottoms.length){
                target = bottoms[i];
                break;
            }

        }
        
        if(target == -1)
            return -1;
        
        int topCounter = 0, bottomCounter = 0;
        
        for(int i = 0; i< tops.length; i++){
            if(tops[i] != target && bottoms[i] != target)   return -1;
            else if(tops[i] != target){
                topCounter++;
            } else if(bottoms[i] != target){
                bottomCounter++;
            }
        }
        
        return Math.min(topCounter, bottomCounter);
    }
}

*/