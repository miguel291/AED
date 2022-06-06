import java.util.*;


// Code based on https://algs4.cs.princeton.edu/33balanced/SplayBST.java.html
class AED33 {

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    String[] instructions;
    AVLTree tree = new AVLTree();
    int end = 0;
    while (scan.hasNextLine() && end == 0) {
      String input = scan.nextLine();
      instructions = input.split(" ");
      switch (instructions[0]) {
        case "FIM":
            end = 1;
            break;
        case "CONSULTA":
           if(tree.get(instructions[1])!=null)
                tree.get(instructions[1]).printNode(1);
            else
                System.out.println("CLIENTE NAO REGISTADO");
          break;
        case "LISTAGEM":
          Node root = tree.getRoot();   // not necessary
          tree.printInOrder();
          System.out.println("FIM");
          break;
        case "CLIENTE":
          if (tree.get(instructions[1]) == null) {
            tree.put(instructions[1],instructions[2] + " " + instructions[3], Integer.parseInt(instructions[4]));
            System.out.println("NOVO CLIENTE INSERIDO");
          }
          else {
              System.out.println("CLIENTE JA EXISTENTE");
          }
          break;
        case "AQUISICAO":
            Node n = tree.get(instructions[1]);
            if (n != null) {
              n.purchasesUpdate(Integer.parseInt(instructions[2]));
              System.out.println("AQUISICAO INSERIDA");
            }
            else
                System.out.println("CLIENTE NAO REGISTADO");
             break;
        case "APAGA":
          if (tree.isEmpty() == true) {
            System.out.println("LISTAGEM DE CLIENTES APAGADA");
          }
          else {
            tree.makeEmpty();
            System.out.println("LISTAGEM DE CLIENTES APAGADA");
          }
          break;
        default:
          System.out.println("Instrucao invalida");
        }
    }
  }
}


class Node {
        String name , address;
        int purchases;
        Node left;
        Node right;
        int height = 0;

        Node(String name, String address,int purchases) {
            this.name = name;
            this.address = address;
            this.purchases = purchases;
            right = null;
            left = null;
        }
        void printNode(int flag ) {
            System.out.println(name + " " + address + " " + purchases);
            if (flag == 1)
                System.out.println("FIM");
            else
                ;
        }

        void purchasesUpdate(int value) {
            purchases += value;
        }


}

class AVLTree {
      Node root;

      AVLTree() {
       root = null;
     }

     boolean isEmpty() {
       return root == null;
     }

     void makeEmpty() {
         root = null;
     }

      Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }

      Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
    }

      void printInOrder() {
       printInOrder(root);
     }

      void printInOrder(Node root) {
         if (root!= null) {
            printInOrder(root.left);
            root.printNode(0);
            printInOrder(root.right);
         }
     }

      Node getRoot() {
         return root;
     }

     Node get(String name) {
        root = splay(root, name);
        int cmp = -1;
        if (root != null)
            cmp = name.compareTo(root.name);
        if (cmp == 0)
            return root;
        else
            return null;
    }

    void put(String name, String address,int purchases) {
        if (root == null) {
            root = new Node(name, address,purchases);
            return;
        }

        root = splay(root, name);

        int cmp = name.compareTo(root.name);

        if (cmp < 0) {
            Node n = new Node(name, address,purchases);
            n.left = root.left;
            n.right = root;
            root.left = null;
            root = n;
        }

        else if (cmp > 0) {
            Node n = new Node(name,address,purchases);
            n.right = root.right;
            n.left = root;
            root.right = null;
            root = n;
        }

        else {
            root.name = name;
        }

    }

    Node splay(Node h, String name) {
        if (h == null) return null;

        int cmp1 = name.compareTo(h.name);

        if (cmp1 < 0) {
            if (h.left == null) {
                return h;
            }
            int cmp2 = name.compareTo(h.left.name);
            if (cmp2 < 0) {
                h.left.left = splay(h.left.left, name);
                h = rotateRight(h);
            }
            else if (cmp2 > 0) {
                h.left.right = splay(h.left.right, name);
                if (h.left.right != null)
                    h.left = rotateLeft(h.left);
            }

            if (h.left == null) return h;
            else                return rotateRight(h);
        }

        else if (cmp1 > 0) {
            if (h.right == null) {
                return h;
            }

            int cmp2 = name.compareTo(h.right.name);
            if (cmp2 < 0) {
                h.right.left  = splay(h.right.left, name);
                if (h.right.left != null)
                    h.right = rotateRight(h.right);
            }
            else if (cmp2 > 0) {
                h.right.right = splay(h.right.right, name);
                h = rotateLeft(h);
            }

            if (h.right == null) return h;
            else                 return rotateLeft(h);
        }

        else return h;
    }
}
