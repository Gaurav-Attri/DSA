public class SegmentTree{

    private class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }

        Node(int data, int startInterval, int endInterval){
            this.data = data;
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }

        Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private Node root;

    public SegmentTree(int[] arr){
        root = construct(arr, 0, arr.length-1);
    }

    private Node construct(int[] arr, int start, int end){
        if(start == end){
            Node leaf = new Node(arr[start], start, end);
            return leaf;
        }

        Node node = new Node(start, end);

        int mid = (start+end)/2;

        node.left = construct(arr, start, mid);
        node.right = construct(arr, mid+1, end);

        node.data = node.left.data + node.right.data;

        return node;

    }

    public void display(){
        display(root);
    }

    private void display(Node node){
        String str = "";

        // for the left child
        if(node.left != null){
            str = str + "Interval: [" + node.left.startInterval + "-" + node.left.endInterval + "] and data is: " + node.left.data + " => "; 
        }
        else{
            str = str + "No left child ";
        }

        // for the current node
        str = str + "Interval: [" + node.startInterval + "-" + node.endInterval + "] and data is: " + node.data;

        // for the right child
        if(node.right != null){
            str = str + " <= Interval: [" + node.right.startInterval + "-" + node.right.endInterval + "] and data is: " + node.right.data;
        }
        else{
            str = str + " No right child ";
        }

        System.out.println(str + '\n');

        if(node.left != null) display(node.left);
        if(node.right != null) display(node.right);
    }

    public int query(int qsi, int qei){
        return query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei){
        // When the node interval lies within the query interval
        if(node.startInterval >= qsi && node.endInterval <= qei) return node.data;

        // When node interval is completely outside the query interval
        else if(node.startInterval > qei || node.endInterval < qsi) return 0;

        // When the node interval is overlapping with the query interval
        else{
            return query(node.left, qsi, qei) + query(node.right, qsi, qei);
        }
    }

    public void update(int index, int value){
        this.root.data = update(this.root, index, value);
    }

    private int update(Node node, int index, int value){
        if(index >= node.startInterval && index <= node.endInterval){
            if(index == node.startInterval && index == node.endInterval){
                node.data = value;
                return node.data;
            }

            else{
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }

        return node.data;
    }
}