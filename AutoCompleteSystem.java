import java.util.*;

public class AutoCompleteSystem {
    class Node{
        boolean isWord;
        String word;
        int freq; 
        Node[] children = null;
        
        public Node()
        {
            children = new Node[26];
        }
    }
    
    Node root = null;
    
    public AutoCompleteSystem() {
    	root = new Node();
    }
    
    public void add(String word) {
        Node cur = root;
        //System.out.println(root.children.length);
        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            if(cur.children[ch - 'a'] == null) // new node
            {
               cur.children[ch - 'a'] = new Node();              
            }
            
            cur = cur.children[ch - 'a'];
        }
        
        cur.isWord = true;
        cur.freq++;
        cur.word = word;
    }
    
    private void dfs(Node root, Map<String, Integer> wordmap)
    {
        if(root == null)
            return;
        Node cur = root;  
        if(cur.isWord == true)
        	wordmap.put(cur.word, cur.freq);
        	
        for(int i = 0; i < 26; i++)
        {
            if(cur.children[i] != null)
            {
                if(cur.children[i].isWord == true)
                {
                    wordmap.put(cur.children[i].word, cur.children[i].freq);
                }
                
                dfs(cur.children[i], wordmap);
            }
        }
    }

    
    public List<String> match(String prefix) {
        Node cur = root;
        List<String> res = new LinkedList<>();
        for(int i = 0; i < prefix.length(); i++)
        {
            char ch = prefix.charAt(i);
            if(cur.children[ch - 'a'] == null)
                return null;    // prefix doesn't exist
            else    
             cur = cur.children[ch - 'a'];
        }        
        
        // search the subtree of the cur node, get the freq count and generate result
        Map<String, Integer> wordmap = new HashMap<>();
        dfs(cur, wordmap);
        List<Map.Entry<String, Integer>> list = new LinkedList<>(wordmap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b)
            {
                return b.getValue() - a.getValue();   // sort using frequency
            }
        });
        
        for(Map.Entry<String, Integer> entry : list)
        	res.add(entry.getKey());
        return res;
    }
    
    public static void main(String[] args)
    {
    	AutoCompleteSystem obj = new AutoCompleteSystem();
    	
    	obj.add("cat");
    	System.out.println(obj.match("ca"));
    	obj.add("cave");
    	System.out.println(obj.match("ca"));
    	obj.add("cat");  
    	System.out.println(obj.match("ca"));
    	obj.add("cab");
    	obj.add("car");
    	obj.add("cat");
    	obj.add("cab"); 
    	obj.add("carl");
    	obj.add("catalog");
    	System.out.println(obj.match("cat"));
    }
}
