class StrStrSolution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */

	/*	My code, which is not cool
    public int strStr(String source, String target) {
        //index pointer for source, target and return
        int ps;
        int pt = 0;
        int ret = -1;
        //flag indicates if comparison starts
        boolean flag =  false;
        
        //validate input parameters
        if(source == null)
        {
            return -1;
        }
        else if(target == null)
        {
            return -1;
        }
        else if(target.length() > source.length())
        {
        	return -1;
        }
        else if(target.length() == 0)
        {
            return 0;
        }
        
        for(ps = 0; ps < source.length();ps++)
        {
            if(flag == true)
            {
                if(pt < target.length() -1)
                {
                    pt++;
                }
                else
                {
                    return ret;
                }
            }
            
            if(source.charAt(ps) == target.charAt(pt))
            {
                flag = true; 
                if(ret == -1)
                {
                    ret = ps;
                }
            }
            else
            {
            	//this one is tricky. Need to consider corner case, i.e, ["tartarget","target"] 
                if(flag == true)
                {
                    ps--;
                }
                //reset tracking variables
                flag = false;
                ret = -1;
                pt = 0;                
            }
        }
        
        if(pt == target.length() - 1)
        {	
        	return ret;
        }
        else
        {
        	return -1;
        }	
    }
*/
	/*reference code, which is cool*/
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            // finished loop, target found
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args)
    {
        String source = "abcdabcdefg";
        String target = "efg";
        StrStrSolution s = new StrStrSolution();
        
        int firstIdx = s.strStr(source, target);
        if( firstIdx == -1)
        {
            System.out.println("Target doesn't exist in source string!");
        }
        else
        {
            System.out.println("The first index of target string in source string is " + firstIdx);
        }    
    }
}