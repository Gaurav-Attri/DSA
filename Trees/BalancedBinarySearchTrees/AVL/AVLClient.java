public class AVLClient{
    public static void main(String[] args){
        AVLTree AVL = new AVLTree();

        for(int i = 0; i < 1000; i++){
            AVL.insert(i);
        }

        System.out.println(AVL.height());
        System.out.println(AVL.isBalanced());
    }
}