import java.util.*;

class AED2{                                         //funçao para imprimir info
                                                    //imprimir tudo com lista .feito
  public static void main(String args[]){           //adicionar vacinas novas
    Scanner scan = new Scanner(System.in);          //mudar data vacinas
    String[] instructions;
    AVLTree tree = new AVLTree();
    while (scan.hasNextLine()){
      String input = scan.nextLine();
      instructions = input.split(" ");
      switch (instructions[0]) {
        case "CONSULTA":
           tree.search(Integer.parseInt(instructions[1]));
          break;
        case "LISTA":
          Node root = tree.getRoot();
          tree.printInOrder();
          System.out.println("FIM");
          break;
        case "ACRESCENTA":
          if (tree.search(Integer.parseInt(instructions[1]))==false){
            Vacine v = new Vacine(instructions[2], instructions[3]);
            tree.insert(Integer.parseInt(instructions[1]),v);
            System.out.println("NOVO UTENTE CRIADO");
          }
          else{}
          break;
        case "APAGA":
          if (tree.isEmpty()==true){
            System.out.println("LISTAGEM DE NOMES VAZIA");
          }
          else{
            tree.makeEmpty();
            System.out.println("LISTAGEM DE NOMES VAZIA");
          }
          break;
        default:
          System.out.println("Instrução inválida");
        }

    }
  }
}

class Node {
        int num;
        ArrayList<Vacine> listVax = new ArrayList<Vacine>();
        Node left;
        Node right;
        int height = 0;

        Node(int num, Vacine vax) {
            this.num = num;
            listVax.add(vax);
            right = null;
            left = null;
        }
        void printNode(){
          for (Vacine v : listVax){
            System.out.println(num + " " + v.vaxName + " " +v.date);
          }
        }

        void vaxCheck(String name ,String date) {
            for (Vacine v : listVax) {
                if (name.equals(v.vaxName)) {
                    v.date = date;
                    break;
                }
            }
            Vacine v = new Vacine(name,date);
            listVax.add(v);
        }

}

class Vacine {
      String date;
      String vaxName;

      Vacine(String vaxName, String date){
        this.vaxName = vaxName;
        this.date = date;
      }

      Vacine returnVax() {
        return(this);
      }
}

class AVLTree{
      Node root;

      AVLTree(){
       root = null;
     }
     /* Function to check if tree is empty */
     public boolean isEmpty(){
       return root == null;
     }
     /* Make the tree logically empty */
     public void makeEmpty()
     {
         root = null;
     }

     /* Function to insert data */
     public void insert(int num, Vacine vax)
     {
         root = insert( num, vax, root);
     }
     /* Function to get height of node */
     private int height(Node t )
     {
         return t == null ? -1 : t.height;
     }
     /* Function to max of left/right node */
     private int max(int lhs, int rhs)
     {
         return lhs > rhs ? lhs : rhs;
     }
     /* Function to insert data recursively */
     private Node insert(int num, Vacine vax, Node t)
     {
         if (t == null)
             t = new Node(num,vax);
         else if (num<t.num)
         {
             t.left = insert( num,vax, t.left );
             if( height( t.left ) - height( t.right ) == 2 )
                 if( num<t.num )
                     t = rotateWithLeftChild( t );
                 else
                     t = doubleWithLeftChild( t );
         }
         else if( num>t.num)
         {
             t.right = insert( num, vax,t.right );
             if( height( t.right ) - height( t.left ) == 2 )
                 if( num>t.right.num)
                     t = rotateWithRightChild( t );
                 else
                     t = doubleWithRightChild( t );
         }
         else
           ;  // Duplicate; do nothing
         t.height = max( height( t.left ), height( t.right ) ) + 1;
         return t;
     }
     /* Rotate binary tree node with left child */
     private Node rotateWithLeftChild(Node k2)
     {
         Node k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
         k1.height = max( height( k1.left ), k2.height ) + 1;
         return k1;
     }

     /* Rotate binary tree node with right child */
     private Node rotateWithRightChild(Node k1)
     {
         Node k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
         k2.height = max( height( k2.right ), k1.height ) + 1;
         return k2;
     }
     /**
      * Double rotate binary tree node: first left child
      * with its right child; then node k3 with new left child */
     private Node doubleWithLeftChild(Node k3)
     {
         k3.left = rotateWithRightChild( k3.left );
         return rotateWithLeftChild( k3 );
     }
     /**
      * Double rotate binary tree node: first right child
      * with its left child; then node k1 with new right child */
     private Node doubleWithRightChild(Node k1)
     {
         k1.right = rotateWithLeftChild( k1.right );
         return rotateWithRightChild( k1 );
     }
     /* Functions to count number of nodes */
     public int countNodes()
     {
         return countNodes(root);
     }
     private int countNodes(Node r)
     {
         if (r == null)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.left);
             l += countNodes(r.right);
             return l;
         }
     }
     /* Functions to search for an element */
      public boolean search(int val)
     {
         return search(root, val);
     }
     private boolean search(Node r, int val)
     {
         boolean found = false;
         while ((r != null) && !found)
         {
             int rval = r.num;
             if (val<rval)
                 r = r.left;
             else if (val>rval)
                 r = r.right;
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }

     public void printInOrder()
     {
       printInOrder(root);
     }

     public void printInOrder(Node root)
     {
         if (root!= null)
         {
            printInOrder(root.left);
            root.printNode();
            printInOrder(root.right);
         }
     }
     public Node getRoot()
     {
         return root;
     }
}
