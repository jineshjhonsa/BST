/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;


import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author Jinesh
 */
public class BST {
    
   
  private static Node root;
      
   
         
   /* public void put(Character key, int val){
        root = put(root,key,val);
    }
    
    
    private  Node put(Node x,Character key,int val){
        
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val = val;
        x.count = 1+size(x.left)+ size(x.right);
        return x;
    }
    
     public int get(String key) {
       return get(root,key);  
     }
    
     private int get(Node x, String key) {
     //   if (x == null) return null;
        int cmp = key.compareTo(x.key.toString());
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }
    /**
     * @param args the command line arguments
     */

    /* public int size()
     {
         return size(root);
     }
     private int size(Node x){
         
         if(x == null ) return 0;
         else return x.count;
     }*/
  @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
          String a = "searchxm";
         BinaryST<Character,Integer> obj = new BinaryST();
        for(int i=0;i< a.length();i++){
       
         
      
         obj.put(a.charAt(i), 1);
            
        }
        
        obj.delete('e');
        obj.inorder();
        
       /* Character  y = 'd';
    //    obj.inorder();
      /* String s = "Call";
       int i = obj.get(y);
       int hash =0;
       Integer  y2k = 10;*/

       /* obj.postorder();
       char flo = obj.floor('g');
       
        char cei = obj.select(4);
       for(char w:obj.keys('e', 'j')){
           System.out.println("keys are "+w);
       }
       //int ran = obj.rank('i');
      System.out.println("floor is "+flo);
     //  System.out.println("rank is "+ran);
        System.out.println("ceiling  is "+ cei);
        
        
     */
      /* for(int xo =0; xo <4;xo++){
           
          char c1 = s.charAt(xo);
          int x = c1;
      hash = x  +(31 * hash);
           
       }
             System.out.println("string hash code  is"+  y2k.hashCode());
        System.out.println("y hash code  is"+  s.hashCode());*/
     //   System.out.println("floor is "+flo);
     
        
            
    }
            

        // TODO code application logic here
    }

/* class Node {
        
         
        Character key;           // sorted by key
        int  val;         // associated data
         Node left, right;  // left and right subtrees
         int count;             // number of nodes in subtree

        public Node(char key, int val) {
            this.key = key;
            this.val = val;
 
        }
        
   
  
    
}*/
