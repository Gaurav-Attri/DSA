public class BSTClient{
    public static void main(String[] args){
        BST bst = new BST();
        int[] test1 = {50, 30, 70, 10, 40, 60, 80};
        // bst.insert(50);
        // bst.insert(30);
        // bst.insert(70);
        // bst.insert(10);
        // bst.insert(40);
        // bst.insert(60);
        // bst.insert(80);
        // bst.populate(test1);


        int[] test2 = {15, 10, 20, 5, 12, 8};
        // bst.insert(15);
        // bst.insert(10);
        // bst.insert(20);
        // bst.insert(5);
        // bst.insert(12);
        // bst.insert(8);
        // bst.populate(test2);

        int[] test3 = {20, 15, 30, 40, 50, 12, 18, 35, 80, 7};
        // bst.insert(20);
        // bst.insert(15);
        // bst.insert(30);
        // bst.insert(40);
        // bst.insert(50);
        // bst.insert(12);
        // bst.insert(18);
        // bst.insert(35);
        // bst.insert(80);
        // bst.insert(7);
        // bst.populate(test3);

        int[] test4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // bst.populate(test4);
        bst.insertSortedInput(test4);
        bst.display();
        System.out.println("Is the above tree balanced: " + bst.isBalanced());
        bst.preOrder();
        bst.inOrder();
        bst.postOrder();
    }
}