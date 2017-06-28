//import java.math.*;

public class Sqrt {
    public int sqrt(int x) {
        // write your code here
        if (x < 0){
            return -1;
        }
        
        long start = 0;
        long end = x;
        long mid = 0;
        
        while (start + 1 < end){
            mid = start + (end - start) / 2;
            
            if (mid * mid >= x){
                end = mid;
            } else {
                start = mid;
            }
        }
        
 /* my original code, but it's not neccessary       
        //check which integer is more close to the target number x
        if (Math.abs(x - (start * start)) <= Math.abs(x - (end * end))){
            return start;
        } else {
            return end;
        }
*/  
        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }
    
    public static void main(String[] args)
    {
    	
    }
}
