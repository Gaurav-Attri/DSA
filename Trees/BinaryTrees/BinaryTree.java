import java.util.Scanner;
public class BinaryTree{
    private class Node{
        int val;
        Node left;
        Node right;

        Node(int val){this.val = val;}
    }

    private Node root;

    public BinaryTree(){
        this.root = fillTree();
    }

    private Node fillTree(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of the node: ");
        Node node = new Node(input.nextInt());

        System.out.print("Does " + node.val + " have a left child?: ");
        boolean hasLeft = input.nextBoolean();
        if(hasLeft) node.left = fillTree();

        System.out.print("Does " + node.val + " have a right child?: ");
        boolean hasRight = input.nextBoolean();
        if(hasRight) node.right = fillTree();

        return node;
    }

    public void display(){
        display(this.root, "");
    }

    private void display(Node root, String indent){
        if(root == null) return;
        System.out.println(indent + root.val);
        display(root.left, indent+"\t");
        display(root.right, indent+"\t");
    }

    public void prettyDisplay(){
        prettyDisplay(this.root, 0);
    }
     

    public void prettyDisplay(Node root, int level){
        if(root == null) return;

        prettyDisplay(root.right, level+1);

        if(level != 0){
            for(int i = 0; i < level-1; i++){
                System.out.print("|\t");
            }
            System.out.println("|-------->" + root.val);
        }
        else{
            System.out.println(root.val);
        }

        prettyDisplay(root.left, level+1);
    }
}   