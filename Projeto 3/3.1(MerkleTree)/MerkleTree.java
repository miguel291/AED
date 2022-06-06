import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
public class MerkleTree {
//Merkle Tree
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int folhas = scan.nextInt();
        int niveis = (int) Math.ceil(Math.log(folhas)/Math.log(2));
        System.out.println(niveis);
        ArrayList<Long> dados =  new ArrayList<>();

        for (int i = 0; i<folhas; i++){
          dados.add(scan.nextLong());
        }
        Node.leafMaker(dados,folhas);
       /* for (long f : dados){
            BinaryNode tree = new BinaryNode(dados);
            tree.printInOrder();
        }*/

      //  BinaryNode tree = new BinaryTree(2);
      //  BinaryNode tree1 = new BinaryNode(5);
       // tree.printInOrder();
       // System.out.println(BinaryNode.size(tree));

    }

     static long hashcode(long x) {
            return x % 1000000007;
        }

     static long hashcode(long x, long y) {
        int mod = 1000000007;
        return ((x % mod) + (y % mod)) % mod;
    }
}

    class Node {
        long value;
        Node left;
        Node right;

        Node(long value) {
            this.value = value;
            right = null;
            left = null;
        }


// Function to insert leaves in the tree
    static void leafMaker(ArrayList<Long> arr,int folhas)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        // Base case for recursion
        for (int i = 0; i<folhas;i+=2 ){
            long m = arr.get(i);
            long n = arr.get(i+1);
            Node root = new Node(MerkleTree.hashcode(m,n));
            root.left = new Node(MerkleTree.hashcode(m));
            root.right = new Node (MerkleTree.hashcode(n));
            nodes.add(root);
            System.out.print("Este é a interação do leafMaker: " +i +"\nLeft: "+root.left.value +"\nRight: "+root.right.value+"\n");
        }
        System.out.println("Vamos passar para o treeMaker !!!!\n\n");
        treeMaker(nodes,(int) Math.ceil(Math.log(folhas)/Math.log(2))-1);

    }

    static void treeMaker(ArrayList<Node> arr, int niveis)
    {

        if (niveis>0){
            ArrayList<Node> nodes = new ArrayList<Node>();
            for (int i = 0; i<niveis; i++ ){
                // Base case for recursion
                long m = arr.get(i).value;
                long n = arr.get(i+1).value;
                Node root = new Node(MerkleTree.hashcode(m,n));
                root.left = arr.get(i);
                root.right = arr.get(i+1);
                nodes.add(root);
                System.out.print("Este é a interação do treeMaker: " +i +"\nLeft: "+root.left.value +"\nRight: "+root.right.value+"\n");
                if(niveis==1)
                    System.out.println("\nSou a raiz: "+root.value);

            }
            treeMaker(nodes,niveis-1);
        }
    }

    }
