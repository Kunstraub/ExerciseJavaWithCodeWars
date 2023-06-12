package Utility;

import java.util.Objects;
import java.util.Stack;
import java.util.function.Consumer;

public class BinaryTreeNode<T extends Comparable<T>> {
    public final T item;

    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T item) {
        this.item = item;
    }

  public void inorderIterativ(BinaryTreeNode<T> startNode){
      Stack<BinaryTreeNode<T>> middleStack = new Stack<>();
      Stack<BinaryTreeNode<T>> leftStack = new Stack<>();

      BinaryTreeNode<T> currentNode = startNode;

      while (currentNode != null || !middleStack.empty() || !leftStack.empty()){

          while (currentNode != null){
              if (currentNode.right != null){
                  middleStack.push(currentNode);
              }
              else {
                  leftStack.push(currentNode);
              }
              currentNode = currentNode.left;
          }
          while (!leftStack.empty()){
              currentNode = leftStack.pop();
              System.out.print(currentNode.item+", ");
              currentNode = currentNode.left;
          }
          if (!middleStack.empty()){
              currentNode = middleStack.pop();
              System.out.print(currentNode.item+", ");
              currentNode = currentNode.right;
          }

      }
  }

    public void preorderIterativ(BinaryTreeNode<T> startNode){
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> currentNode = startNode;
        while (currentNode != null || !stack.empty()){
            if (currentNode != null){
                System.out.print(currentNode.item+", ");
                if (currentNode.right != null){
                    stack.push(currentNode.right);
                }
                currentNode = currentNode.left;
            }
            else {
                currentNode = stack.pop();
            }
        }
    }

    public static <T extends Comparable<T>> void preorder(final BinaryTreeNode<T> currentNode, Consumer<T> print){
        if (currentNode != null){
            print.accept(currentNode.item);
            // System.out.println(currentNode.item);
            preorder(currentNode.left,System.out::println);
            preorder(currentNode.right,System.out::println);
        }
    }

    public static <T extends Comparable<T>> void inorder(final BinaryTreeNode<T> currentNode, Consumer<T> print){
        if (currentNode != null){
            inorder(currentNode.left,System.out::println);
            print.accept(currentNode.item);
            //System.out.println(currentNode.item);
            inorder(currentNode.right,System.out::println);
        }
    }

    public static <T extends Comparable<T>> void postorder(final BinaryTreeNode<T> currentNode, Consumer<T> print){
        if (currentNode != null){
            postorder(currentNode.left, System.out::println);
            postorder(currentNode.right, System.out::println);
            print.accept(currentNode.item);
           // System.out.println(currentNode.item);
        }
    }



    <T extends Comparable<T>> BinaryTreeNode<T> find(BinaryTreeNode<T> startNode,T searchFor){
        if (startNode == null) return null;
        final int compareResult = startNode.item.compareTo(searchFor);
        if (compareResult < 0) return find(startNode.right, searchFor);
        if (compareResult > 0) return find(startNode.left, searchFor);
        return startNode;
    }

    public static <T extends Comparable<T>> BinaryTreeNode<T> insert(final BinaryTreeNode<T> root, T value){
        if (root == null) return new BinaryTreeNode<>(value);
        final int compareResult = root.item.compareTo(value);
        if (compareResult < 0) root.right = insert(root.right, value);
        else if (compareResult > 0) root.left = insert(root.left, value);
        return root;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public String toString() {
        return String.format("BinaryTreeNode [item=%s, left=%s, right=%s]", item, left, right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTreeNode<?> that = (BinaryTreeNode<?>) o;
        return Objects.equals(item, that.item) &&
                Objects.equals(left, that.left) &&
                Objects.equals(right, that.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, left, right);
    }

    public int compareTo(BinaryTreeNode<T> other) {
        if (other == null) return 1;
        return this.item.compareTo(other.item);
    }

    public T getItem() {
        return item;
    }
}

