package com.pearz.data_structure.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        TreeNode root = new TreeNode(1, "pearz");
        TreeNode redz = new TreeNode(2, "redz");
        TreeNode tx = new TreeNode(3, "tx");
        TreeNode ll = new TreeNode(5, "ll");

        bt.setRoot(root);
        root.setLeft(redz);
        root.setRight(tx);
        tx.setRight(ll);

        bt.preOrder(bt.getRoot());
//        inOrder(bt.getRoot());
//        postOrder(bt.getRoot());
        System.out.println();

//        System.out.println(preOrderSearch(root, 1));
//        System.out.println(inOrderSearch(root, 1));
//        System.out.println(postOrderSearch(root, 1));

        bt.delNode(bt.getRoot(), 99);

        bt.inOrder(bt.getRoot());

    }


}

class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root);
            if (root.getLeft() != null) {
                preOrder(root.getLeft());
            }
            if (root.getRight() != null) {
                preOrder(root.getRight());
            }
        }
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            if (root.getLeft() != null) {
                inOrder(root.getLeft());
            }
            System.out.println(root);
            if (root.getRight() != null) {
                inOrder(root.getRight());
            }
        }
    }

    public void postOrder(TreeNode root) {
        if (root != null) {
            if (root.getLeft() != null) {
                postOrder(root.getLeft());
            }
            if (root.getRight() != null) {
                postOrder(root.getRight());
            }
            System.out.println(root);
        }
    }

    public TreeNode preOrderSearch(TreeNode root, int no) {
        if (root != null) {
            if (root.getNo() == no) {
                return root;
            }
            TreeNode resNode = null;
            if (root.getLeft() != null) {
                resNode = preOrderSearch(root.getLeft(), no);
            }
            if (resNode != null) {
                return resNode;
            }
            if (root.getRight() != null) {
                resNode = preOrderSearch(root.getRight(), no);
            }
            return resNode;
        }
        return null;
    }

    public TreeNode inOrderSearch(TreeNode root, int no) {
        if (root != null) {
            TreeNode resNode = null;
            if (root.getLeft() != null) {
                resNode = inOrderSearch(root.getLeft(), no);
            }
            if (resNode != null) {
                return resNode;
            }
            if (root.getNo() == no) {
                return root;
            }
            if (root.getRight() != null) {
                resNode = inOrderSearch(root.getRight(), no);
            }
            return resNode;
        }
        return null;
    }

    public TreeNode postOrderSearch(TreeNode root, int no) {
        if (root != null) {
            TreeNode resNode = null;
            if (root.getLeft() != null) {
                resNode = postOrderSearch(root.getLeft(), no);
            }
            if (resNode != null) {
                return resNode;
            }
            if (root.getRight() != null) {
                resNode = postOrderSearch(root.getRight(), no);
            }
            if (resNode != null) {
                return resNode;
            }
            if (root.getNo() == no) {
                return root;
            }
            return null;
        }
        return null;
    }

    public void delNode(TreeNode root, int no) {
        if (root == null) {
            return;
        }
        if (root.getNo() == no) {
            this.setRoot(null);
//            root = null;//????????
            return;
        }
        TreeNode temp = root;
        if (temp.getLeft() != null && temp.getLeft().getNo() == no) {
            temp.setLeft(null);
            return;
        }
        if (temp.getRight() != null && temp.getRight().getNo() == no) {
            temp.setRight(null);
            return;
        }
        if (temp.getLeft() != null) {
            delNode(temp.getLeft(), no);
        }
        if (temp.getRight() != null) {
            delNode(temp.getRight(), no);
        }
    }
}

class TreeNode {
    private int no;
    private String name;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
