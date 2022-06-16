//TC : O(m * n) // m = source string length and n = target string length
//SC : O(1)
/*
class Solution {
    public int shortestWay(String source, String target) {
        
        if(source == null || target == null)    return -1;
        int t = 0;
        
        int count = 0;
        
        while(t < target.length()){
            int s = 0;
            count++;
            int currT = t;
            while(s < source.length() && t < target.length()){
                if(source.charAt(s) == target.charAt(t)){
                    s++; t++;
                }else{
                    s++;
                }
            }
            if(currT == t)  return -1;
        }
        return count;
    }
}
*/


//TC : O(Log m  * n) // m = source string length and n = target string length
//SC : O(n) // size of hashmap


class Solution {
    public int shortestWay(String source, String target) {
        if(source == null || target == null)    return -1;
        
        HashMap<Character, List<Integer> > map = new HashMap<>();
        
        for(int i = 0; i< source.length(); i++){ // We will store indices of charaacters in source string
            if(!map.containsKey( source.charAt(i) )){
                map.put(source.charAt(i), new ArrayList<>());
            }
            map.get(source.charAt(i)).add(i);
        }
        
        int t = 0, count = 1;
        //index on target string
        int index = 0; //index on source string
        
        while(t < target.length()){
            char ch = target.charAt(t);
            if(!map.containsKey(ch))    return -1;
            List<Integer> list = map.get(ch);
            
            int el = Collections.binarySearch(list, index);
            
            if(el < 0){ // POsition where next element should ne there
                el = -el - 1;
            } 
            
            if(el == list.size()){
                index = 0; // Reset index to 0
                count++; // increementing the usage of source string
            }
            else{
                index = list.get(el); // actual index for char in source
                index++;
                t++;
            }
            
        }
        
        return count;
    }
}