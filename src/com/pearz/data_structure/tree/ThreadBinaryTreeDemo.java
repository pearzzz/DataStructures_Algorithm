package com.pearz.data_structure.tree;

public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {
        InThreadBinaryTree tbt = new InThreadBinaryTree();

        ThreadBinaryTreeNode root = new ThreadBinaryTreeNode(1, "pearz");
        ThreadBinaryTreeNode redz = new ThreadBinaryTreeNode(2, "redz");
        ThreadBinaryTreeNode tx = new ThreadBinaryTreeNode(3, "tx");
        ThreadBinaryTreeNode ll = new ThreadBinaryTreeNode(5, "ll");

        tbt.setRoot(root);
        root.setLeft(redz);
        root.setRight(tx);
        tx.setRight(ll);

        tbt.inThread(root);
        System.out.println(tx.getLeft());
        System.out.println();

        tbt.inOrderByThread(root);
    }
}

class InThreadBinaryTree extends ThreadBinaryTree {
    ThreadBinaryTreeNode pre = null;

    public InThreadBinaryTree() {
    }

    public InThreadBinaryTree(ThreadBinaryTreeNode root) {
        super(root);
    }

    public void inThread(ThreadBinaryTreeNode node) {
        if (node != null) {

            inThread(node.getLeft());

            if (node.getLeft() == null) {
                node.setLeft(pre);
                node.setLeftThread(true);
            }
            if (pre != null && pre.getRight() == null) {
                pre.setRight(node);
                pre.setRightThread(true);
            }
            pre = node;

            inThread(node.getRight());
        }
    }

    public void inOrderByThread(ThreadBinaryTreeNode root) {
        if (root != null) {
            ThreadBinaryTreeNode node = root;
            while (node != null) {
                while (!node.isLeftThread()) {
                    node = node.getLeft();
                }
                System.out.println(node);
                while (node.isRightThread()) {
                    node = node.getRight();
                    System.out.println(node);
                }
                node = node.getRight();
            }
        }
    }
}

class ThreadBinaryTree {
    private ThreadBinaryTreeNode root;

    public ThreadBinaryTree() {
    }

    public ThreadBinaryTree(ThreadBinaryTreeNode root) {
        this.root = root;
    }

    public ThreadBinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(ThreadBinaryTreeNode root) {
        this.root = root;
    }

    public void preOrder(ThreadBinaryTreeNode root) {
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

    public void inOrder(ThreadBinaryTreeNode root) {
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

    public void postOrder(ThreadBinaryTreeNode root) {
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

    public ThreadBinaryTreeNode preOrderSearch(ThreadBinaryTreeNode root, int no) {
        if (root != null) {
            if (root.getNo() == no) {
                return root;
            }
            ThreadBinaryTreeNode resNode = null;
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

    public ThreadBinaryTreeNode inOrderSearch(ThreadBinaryTreeNode root, int no) {
        if (root != null) {
            ThreadBinaryTreeNode resNode = null;
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

    public ThreadBinaryTreeNode postOrderSearch(ThreadBinaryTreeNode root, int no) {
        if (root != null) {
            ThreadBinaryTreeNode resNode = null;
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

    public void delNode(ThreadBinaryTreeNode root, int no) {
        if (root == null) {
            return;
        }
        if (root.getNo() == no) {
            this.setRoot(null);
//            root = null;//????????
            return;
        }
        ThreadBinaryTreeNode temp = root;
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

class ThreadBinaryTreeNode {
    private int no;
    private String name;
    private ThreadBinaryTreeNode left;
    private ThreadBinaryTreeNode right;

    private boolean isLeftThread;
    private boolean isRightThread;

    public ThreadBinaryTreeNode() {
    }

    public ThreadBinaryTreeNode(int no, String name) {
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

    public ThreadBinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(ThreadBinaryTreeNode left) {
        this.left = left;
    }

    public ThreadBinaryTreeNode getRight() {
        return right;
    }

    public void setRight(ThreadBinaryTreeNode right) {
        this.right = right;
    }

    public boolean isLeftThread() {
        return isLeftThread;
    }

    public void setLeftThread(boolean leftThread) {
        isLeftThread = leftThread;
    }

    public boolean isRightThread() {
        return isRightThread;
    }

    public void setRightThread(boolean rightThread) {
        isRightThread = rightThread;
    }

    @Override
    public String toString() {
        return "ThreadBinaryTreeNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}