import Utility.BinaryTreeNode;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*System.out.println("Hello world!");
        Main.primzahlprüfung(8);
        System.out.println(Main.checkIsAnagram("listen","silent"));
        System.out.println();*/
         BinaryTreeNode<Integer> _4 = new BinaryTreeNode<>(4);
        _4 = BinaryTreeNode.insert(_4,2);
        _4 = BinaryTreeNode.insert(_4,1);
        _4 = BinaryTreeNode.insert(_4,3);
        _4 = BinaryTreeNode.insert(_4,6);
        _4 = BinaryTreeNode.insert(_4,5);
        _4 = BinaryTreeNode.insert(_4,7);

        /*System.out.println("PREORDER:");
        BinaryTreeNode.preorder(_4,System.out::println);
        System.out.println("INORDER:");
        BinaryTreeNode.inorder(_4,System.out::println);
        System.out.println("POSTORDER:");
        BinaryTreeNode.postorder(_4,System.out::println);*/
        //_4.preorderIterativ(_4);
        //_4.inorderIterativUpdate(_4);
        _4.postorderIterativ(_4);
    }

   static boolean primzahlprüfung(int überprüfendeZahl){
        for(int i = 2; i < überprüfendeZahl; i++){
            if (überprüfendeZahl % i == 0)
                return false;
        }
        return true;
    }

    static boolean checkIsAnagram(String word1, String word2){
        if (word1.length() != word2.length())
            return false;

       char[] word1Char = word1.toLowerCase().toCharArray();
       char[] word2Char = word2.toLowerCase().toCharArray();
        Arrays.sort(word1Char);
        Arrays.sort(word2Char);
       return Arrays.equals(word1Char, word2Char);
    }

}