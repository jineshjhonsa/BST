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
      
   
         
 
   
  @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
          String a = "searchxm";
         BinaryST<Character,Integer> obj = new BinaryST();
        for(int i=0;i< a.length();i++){
       
         
      
         obj.put(a.charAt(i), 1);
            
        }
        
        obj.delete('e');
        obj.inorder();
        
   
     
        
            
    }
            

        // TODO code application logic here
    }

