public class AVLTree{
    private class Node{
        private int value;
        private int height;
        private Node left;
        private  Node right;

        Node(int value){
            this.value = value;
        }
    }

    private Node root;
    
    public int height(){
        return height(root);
    }

    private int height(Node node){
        if(node == null) return -1;
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void display(){
        display(root, "Root Node: ");
    }

    private void display(Node node, String details){
        if(node == null) return;

        System.out.println(details + node.value);

        display(node.left, " left child of " + node.value + ": ");
        display(node.right," right child of " + node.value + ": ");
    }

    // MI --> My Implementation
    public void insertMI(int value){
        if(root == null){
            root = new Node(value);
            return;
        }
        insertMI(root, value);
    }

    // MI --> My Implementation
    private void insertMI(Node node, int value){
        if(node.value < value){
            if(node.right == null){
                node.right = new Node(value);
                return;
            }
            else insertMI(node.right, value);
        }
        else{
            if(node.left == null){
                node.left = new Node(value);
                return;
            }
            else insertMI(node.left, value);
        }
    }

    public void insert(int value){
        this.root = insert(this.root, value);
    }

    private Node insert(Node node, int value){
        if(node == null) return new Node(value);
        if(node.value < value) node.right = insert(node.right, value);
        else node.left = insert(node.left, value);

        node.height = Math.max(height(node.left), height(node.right))+1;

        return rotate(node);
    }

    private Node rotate(Node node){
        if(height(node.left) - height(node.right) > 1){ // left heavy subtree: height of left subtree is more than that of right subtree
            if(height(node.left.left) - height(node.left.right) > 0){ // left-left case 
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0){ // left-right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.left) - height(node.right) < -1){// right heavy subtree: height of right subtree is more than that of left subtree
            if(height(node.right.left) - height(node.right.right) < 0){ // right-right case
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0){ // right-left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node leftRotate(Node node){
        Node c = node.right;
        Node t = c.left;

        c.left = node;
        node.right = t;

        node.height = Math.max(height(node.left), height(node.right))+1;
        c.height = Math.max(height(c.left), height(c.right))+1;

        return c;
    }

    private Node rightRotate(Node node){
        Node c = node.left;
        Node t = c.right;

        c.right = node;
        node.left = t;

        node.height = Math.max(height(node.left), height(node.right))+1;
        c.height = Math.max(height(c.left), height(c.right))+1;

        return c;
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if(node == null) return true;
        return Math.abs(height(node.left)-height(node.right)) <=1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public void populate(int[] arr){
        for(int i = 0; i < arr.length; i++){
            insert(arr[i]);
        }
    }

    public void insertSortedInput(int[] arr){
        insertSortedInput(arr, 0, arr.length-1);
    }

    private void insertSortedInput(int[] arr, int s, int e){
        if(s > e) return;
        int mid = (s+e)/2;
        insert(arr[mid]);
        insertSortedInput(arr, s, mid-1); // Calling for left
        insertSortedInput(arr, mid+1, e); // Calling for right;
    }

    public void preOrder(){
        preOrder(root);
        System.out.println();
    }
    
    private void preOrder(Node node){
        if(node == null) return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }


    
}