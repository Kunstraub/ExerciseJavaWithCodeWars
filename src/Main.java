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
       // _4.postorderIterativ(_4);
       // System.out.println(lengthOfLongestSubstring("ohomm"));
        //System.out.println(reverse(120));
        System.out.println(longestPalindrome("cbbd"));

    }

    public static String longestPalindromeChatGptSolution(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLen = 1;

        // Jeder einzelne Buchstabe ist ein Palindrom
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Überprüfung der Palindrome für Substrings der Länge 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // Überprüfung der Palindrome für Substrings der Länge > 2
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    public static String longestPalindrome(String s){

        int biggest = 0;
        String biggestPalindrom = Character.valueOf(s.toCharArray()[0]).toString();
       /* if (s.length() == 1 || s.length() == 2){
            char[] two = s.toCharArray();
            biggestPalindrom = Character.valueOf(two[0]).toString();
        }*/


        for (int i = 2; i <= s.length(); i++){
         for (int j = 0; j <= s.length()-i; j++){
           String substring = s.substring(j, j+i);
           StringBuilder sb = new StringBuilder(substring);
           if (substring.equals(sb.reverse().toString())){
               if (substring.length() > biggest){
                   biggest = substring.length();
                   biggestPalindrom = substring;
               }
           }
         }
        }

        return biggestPalindrom;
    }
    public static int reverse(int x) {
        if(x > 2147483647 || x < -2147483648 )
            return 0;
       String num = Integer.valueOf(x).toString();
       String sign = "";
       if (x < 0){
           num = num.replace("-","");
           sign = "-";
       }

       num = num.replaceFirst("^0+(?!$)", "").replaceAll("0+$", "");
      StringBuilder sb = new StringBuilder(num);
      try{
         return Integer.valueOf(sign.concat(sb.reverse().toString()));
      }catch (NumberFormatException e){
          return 0;
      }

    }
    public static int lengthOfLongestSubstring(String input) {

        if (input.equals(""))
            return 0;

       char[] inputArr = input.toCharArray();
       Set<Character> inputSet = new LinkedHashSet<>();
       inputSet.add(inputArr[0]);
       int biggest = inputSet.size();
       int sum;

       for (int i = 1; i <= inputArr.length-1; i++){

           if (inputSet.contains(inputArr[i])){
               List<Character> characterList = new ArrayList<>(inputSet);
               int index = characterList.indexOf(inputArr[i])+1;
               List<Character> partList = characterList.subList(index, characterList.size());
               inputSet.clear();
               inputSet.addAll(partList);
               inputSet.add(inputArr[i]);

           }
           else {
               inputSet.add(inputArr[i]);
               sum = inputSet.size();
               if (sum > biggest)
                   biggest = sum;
           }
       }
       return biggest;
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