public class BST{
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

    public int height(Node node){
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

        return node;
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