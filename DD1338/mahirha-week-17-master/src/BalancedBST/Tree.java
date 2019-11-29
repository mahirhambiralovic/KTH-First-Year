import java.util.Random;

public class TreeOriginalimport java.lang.Comparable;
        import java.util.LinkedList;
        import java.util.Random;
        import java.util.Stack;
        import java.lang.Math;

public class Tree <T extends Comparable> {

    /**
     * MAX-HEAP - Highest priority on top!
     */

    private Node root;
    private int size;
    private int height;
    private int leaves;
    private Random randomizer;
    private int counter;

    public class Node<T> {
        public T key;
        public int priority;
        public Node lc;
        public Node rc;
        public Node parent;
    }

    // Initiate with null root
    public Tree(){
        root = null;
        size = 0;
        height = 0;
        leaves = 0;
        // TO BE USED FOR PRIORITY!!!
        randomizer = new Random();
    }

    public static void main(String[] args){
        Tree<Integer> tree = new Tree<>();


        /*
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        System.out.println(tree.toString());

         */



    }

    public boolean search(T elem){
        // Start from root node
        Node currentNode = root;

        // Något som itererar (while has child?)
        while(currentNode != null){
            // If equal, found it!
            if (elem.compareTo(currentNode.key) == 0) {
                return true;
            }
            // If elem is greater than current node, and it has a right child, go to the right child
            else if (elem.compareTo(currentNode.key) > 0 && currentNode.rc != null) {
                currentNode = currentNode.rc;
                continue;
            }
            // If elem is less than current node, and it has a left child, go to the left child
            else if (elem.compareTo(currentNode.key) < 0 && currentNode.lc != null) {
                currentNode = currentNode.lc;
                continue;
            }
            // Not found
            else {return false;}
        }
        return false;
    }

    /**
     * Insert element as a node into tree, left child if key is smaller, right child if greater
     * @param elem to be inserted
     * @return boolean if successfully added
     */
    public boolean insert(T elem){
        // Put elem into a new node
        Node newNode = new Node();
        newNode.key = elem;
        // CREATE RANDOM (POSITIVE) INT FOR PRIORITY
        newNode.priority = Math.abs(randomizer.nextInt());

        // If empty, set newNode to root
        if(root == null){
            root = newNode;
            size++;
            leaves++;
            return true;
        }

        /**
         * Look for correct position. Start from root.
         */
        Node currentNode = root;
        int currentHeight = 0;

        while(true) {
            // If elem is greater than current node
            if (elem.compareTo(currentNode.key) > 0) {

                // If has right child, enter and restart search
                if(currentNode.rc != null){
                    currentNode = currentNode.rc;
                    currentHeight++;
                    continue;
                }
                else{
                    // ELSE add it to right child
                    currentNode.rc = newNode;
                    newNode.parent = currentNode;
                    size++;
                    currentHeight++;

                    counter += currentHeight;
                    // Check if we want to update height
                    if(height < currentHeight){
                        height = currentHeight;
                    }

                    // Check if we want to add number of leaves (when there is one child(lc) already present)
                    if(currentNode.lc != null){
                        leaves++;
                    }

                    // Done, newNode is now a leaf

                    // Now time for rotation!!
                    while(newNode.parent != null && newNode.parent.priority < newNode.priority){
                        if(newNode.parent.lc == newNode){
                            rotateRight(newNode);
                        }
                        else{
                            rotateLeft(newNode);
                        }
                    }

                    // Finito
                    System.out.println(counter);

                    return true;
                }


            }

            // If elem is less than current node
            if (elem.compareTo(currentNode.key) < 0) {

                // If has left child, enter and restart search
                if(currentNode.lc != null){
                    currentNode = currentNode.lc;
                    currentHeight++;
                    continue;
                }

                // ELSE add it to left child
                currentNode.lc = newNode;
                newNode.parent = currentNode;
                size++;
                currentHeight++;

                counter += currentHeight;
                // Check if we want to update height
                if(height < currentHeight){
                    height = currentHeight;
                }

                // Check if we want to add number of leaves (when there is one child(rc) already present)
                if(currentNode.rc != null){
                    leaves++;
                }

                // Now time for rotation!!
                while(newNode.parent != null && newNode.parent.priority < newNode.priority){
                    if(newNode.parent.lc == newNode){
                        rotateRight(newNode);
                    }
                    else{
                        rotateLeft(newNode);
                    }
                }
                System.out.println(counter);

                return true;
            }
            // If equal, do nothing and return false
            if (elem.compareTo(currentNode.key) == 0) {
                System.err.println(elem + " element already exists");
                return false;
            }
            else{throw new NullPointerException("Item is not greater, less or equal to comparable.");}
        }


    }

    /**
     *
     *       parent
     *        /   \
     *    rotator  z
     *      / \
     *     x   y
     *
     *
     *
     * (2)
     *
     *                  parent
     *                   /  \
     *                  y    z
     *
     *      rotator
     *       /
     *      x
     *
     * (3)
     *       rotator
     *        /   \
     *       x    parent
     *              /  \
     *             y    z
     *
     */
    private void rotateRight(Node rotator){
        Node parent = rotator.parent;
        Node grandparrent = parent.parent;
        Node x = rotator.lc;
        Node y = rotator.rc;
        Node z = parent.rc;

        // Split tree up and set y as lc of parent(2)
        if (y != null) {
            parent.lc = y;
            y.parent = parent;
            rotator.rc = null;
        }
        else{
            parent.lc = null;
        }

        // Make parent rc of rotator
        // While also making parent parent updated
        rotator.parent = grandparrent;
        // If there is a grandparrent, make it rotators parent
        if (grandparrent != null) {
            if(grandparrent.lc == parent){
                grandparrent.lc = rotator;
            } else{
                grandparrent.rc = rotator;
            }
        }
        // Else, it is the root
        else{
            root = rotator;
        }

        rotator.rc = parent;
        parent.parent = rotator;
    }

    /**
     *       parent
     *        /   \
     *       x    rotator
     *              /  \
     *             y    z
     *
     *
     * (2)
     *      parent
     *       /  \
     *      x    y      rotator
     *                     \
     *                      z
     *
     *
     * (3)
     *       rotator
     *        /   \
     *    parent   z
     *      / \
     *     x   y
     *
     */
    private void rotateLeft(Node rotator){
        Node parent = rotator.parent;
        Node grandparrent = parent.parent;
        Node x = parent.lc;
        Node y = rotator.lc;
        Node z = rotator.rc;


        // Split tree up and set y as rc of parent(2)
        if (y != null) {
            parent.rc = y;
            y.parent = parent;
            rotator.lc = null;
        }
        else{
            parent.rc = null;
        }

        // Make parent lc of rotator
        rotator.parent = grandparrent;
        // If there is a grandparrent, make it rotators parent
        if (grandparrent != null) {
            if(grandparrent.lc == parent){
                grandparrent.lc = rotator;
            } else{
                grandparrent.rc = rotator;
            }
        }
        // Else, it is the root
        else{
            root = rotator;
        }

        rotator.lc = parent;
        parent.parent = rotator;

    }


    public int size(){return size;}
    public int height(){return height;}
    public int leaves(){return leaves;}

    /**
     public String toString(){
     if(root == null){
     return "";
     }

     StringBuilder string = new StringBuilder();
     Stack<Node> stack = new Stack<>();
     Node currentNode = root;


     while(true){
     stack.push(currentNode);
     while (currentNode.lc != null) {
     currentNode = currentNode.lc;
     stack.push(currentNode);
     if (currentNode.lc == null && !stack.empty()) {
     string.append(stack.pop().key);
     currentNode = currentNode.parent;
     if(currentNode.rc != null){
     currentNode = currentNode.rc;
     }
     }

     }



     while(!stack.empty()){
     while (currentNode.lc != null) {
     currentNode = currentNode.lc;
     stack.push(currentNode);
     }
     if (!stack.empty()) {
     string.append(stack.pop().key);
     currentNode = currentNode.parent;
     if(currentNode.rc != null){
     currentNode = currentNode.rc;
     }
     }
     }

     return string.toString();


     }
     */
    public String toString(){
        return toString(root);
    }
    private String toString(Node root){
        StringBuilder builder = new StringBuilder();
        if (root == null)
            return "";
        builder.append(toString(root.lc));
        builder.append(toString(root.rc));
        return builder.append(root.key.toString() + "\n").toString();
    }
}
 {
}
