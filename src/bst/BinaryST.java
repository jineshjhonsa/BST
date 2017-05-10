/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;
;;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Jinesh
 * @param <key>
 * @param <value>
 */
public class BinaryST<Key extends Comparable<Key>,Value>{
    private Node root;
 
     private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int count;             // number of nodes in subtree

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.count = N;
        }
    }
    ArrayList data = new ArrayList(); 
  
    public void put(Key key, Value val){
        root = put(root,key,val);
    }
    
    
    private  Node put(Node x,Key key,Value val){
       
        if (x == null) return new Node(key, val,1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val =val;
        
        x.count = 1+size(x.left)+ size(x.right);
        return x;
    }
    
     public Value get(Key key) {
       return get(root,key);  
     }
    
     private Value get(Node x, Key key) {
     //   if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }
     
      public void delete(Key key) {
        if (key == null) throw new NullPointerException("argument to delete() is null");
        root = delete(root, key);
        
    }

      public void inorder(){
          inorder(root);
          System.out.println(data.toString());
      }
      private void inorder(Node x){
          if(x==null) return;
          inorder(x.left);
          
          data.add(x.key);
          inorder(x.right);
          
          
      }
    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    } 
    private Node min(Node x) { 
        if (x.left == null) return x; 
        else                return min(x.left); 
    } 
     private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**
     * @param args the command line arguments
     */

     public int size()
     {
         return size(root);
     }
     private int size(Node x){             
         
         if(x == null ) return 0;
         else return x.count;
     }
        //Floor is the largest key less than or equal to key
     public Key floor(Key key) {
        if (key == null) throw new NullPointerException("argument to floor() is null");
         Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    } 

    private Node floor(Node x, Key key) {
                  if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, key);
        Node t = floor(x.right, key); 
        if (t != null) return t;
        else return x; 
    } 
  
      public int rank(Key key) {
        if (key == null) throw new NullPointerException("argument to rank() is null");
       int ft = rank(key, root);
       return ft;
    } 

    // Number of keys in the subtree less than key.
      //if the key is less than x.key get rank from left of it and if it is greater than take the size of the left add 1 and see its rank on the right
    private int rank(Key key, Node x) {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0){
            int lt = rank(key, x.left);
            return lt;
        } 
        else if (cmp > 0){
            int gt = 1 + size(x.left) + rank(key, x.right);
            return gt;
        } 
        else              {
            int eq =  size(x.left);
            return eq;
        } 
    } 
    
    
    /*
    
    Ceiling is equal to key
   key is greater than x then it is in right subtree
    if key is less than x see left subtree and 
    
    */
    
    public Key Ceiling(Key key){
       if (key == null) throw new NullPointerException("argument to rank() is null");
        Node y = ceiling(root,key);
        return y.key;
      
    }
    private Node ceiling(Node x, Key  key ){
        
        if(x == null) return null;
        int i = key.compareTo(x.key);
        if(i>0)  return ceiling(x.right,key);
        if(i==0) return x;
        
            Node t = ceiling(x.left,key);
            if(t!= null) return t;
        else return x;
    }

   /* public boolean delete(Character key){
        
        boolean stat =  delete(root, key);
    }*/
    
    
    /**
     * Return the kth smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the kth smallest key in the symbol table
     * @throws IllegalArgumentException unless <tt>k</tt> is between 0 and
     *        <em>N</em> &minus; 1
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) throw new IllegalArgumentException();
        Node x = select(root, k);
        return x.key;
    }

    // Return key of rank k. 
    private Node select(Node x, int k) {
        if (x == null) return null; 
        int t = size(x.left); 
        
        if      (t > k) return select(x.left,  k); 
        else if (t < k) return select(x.right, k-t-1); 
        else            return x; 
    } 
     public int height() {
        return height(root);
    }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
    
       public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new NullPointerException("first argument to keys() is null");
        if (hi == null) throw new NullPointerException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return (Iterable<Key>) queue;
    } 

       public  void postorder(){
           List<Key> x = postorder(root);
           System.out.println(Arrays.asList(x));
       }
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key); 
        if (cmphi > 0) keys(x.right, queue, lo, hi); 
    } 
    
    private List<Key> postorder(Node root){
         List<Key> res = new ArrayList<Key>();
 
    if(root==null) {
        return res;
    }
 
    Stack<Node> stack = new Stack<Node>();
    stack.push(root);
 
    while(!stack.isEmpty()) {
        
        Node temp = stack.peek();
  //      Node temp = new Node(x1.key,x1.val,x1.count);
        if(temp.left==null && temp.right==null) {
            Node pop = stack.pop();
            res.add (pop.key);
        }
        else {
            if(temp.right!=null) {
                stack.push(temp.right);
                temp.right = null;
            }
 
            if(temp.left!=null) {
                stack.push(temp.left);
                temp.left = null;
            }
        }
    }
 
    return res;
    }
            
}

        
 
    
 