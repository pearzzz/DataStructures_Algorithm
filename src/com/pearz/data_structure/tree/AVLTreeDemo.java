package com.pearz.data_structure.tree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 15, 20, 6, 90, 120};

        AVLTree tree = new AVLTree();

        for (int value : arr) {
            tree.add(new AVLNode(value));
        }

        tree.inOrder(tree.root);
        System.out.println(tree.height(tree.root.left));
        System.out.println(tree.height(tree.root.right));

        System.out.println(tree.root.right.right.left);
    }
}

class AVLTree {
    AVLNode root;

    //中序遍历
    public void inOrder(AVLNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root);
            inOrder(root.right);
        }
    }

    //添加节点
    public void add(AVLNode node) {
        if (root == null) {
            root = node;
        } else {
            AVLNode temp = root;
            while (true) {
                if (node.value < temp.value) {
                    if (temp.left == null) {
                        temp.left = node;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else {
                    if (temp.right == null) {
                        temp.right = node;
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
        }

        adjust(root);
    }

    //寻找待删除节点
    public AVLNode search(int value) {
        if (root == null) {
            return null;
        }
        AVLNode temp = root;
        while (temp != null) {
            if (temp.value == value) {
                return temp;
            } else if (temp.value > value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return null;
    }

    //寻找待删除节点的父节点
    public AVLNode searchParent(int value) {
        if (root == null || root.value == value) {
            return null;
        }
        AVLNode temp = root;
        while (temp != null) {
            if ((temp.left != null && temp.left.value == value) || (temp.right != null && temp.right.value == value)) {
                return temp;
            } else if (temp.value > value) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return null;
    }

    //寻找子树的最小值节点
    public AVLNode searchMin(AVLNode node) {
        if (node == null) {
            return null;
        }
        AVLNode temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    //删除节点
    public void delNode(int value) {
        if (root == null) {
            return;
        }
        AVLNode target = search(value), parent = searchParent(value);
        //没有值为value的点
        if (target == null) {
            //存在值为value的节点，但没有父节点
        } else if (parent == null) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left != null && root.right == null) {
                root = root.left;
            } else if (root.left == null && root.right != null) {
                root = root.right;
            } else {
                AVLNode min = searchMin(target.right);
                AVLNode minParent = searchParent(min.value);
                if (minParent.left == min) {
                    minParent.left = null;
                } else {
                    minParent.right = null;
                }
                min.left = root.left;
                min.right = root.right;
                root = min;
            }
        } else {
            //value为叶子节点
            if (target.left == null && target.right == null) {
                if (parent.left == target) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                //value有两个子节点
            } else if (target.left != null && target.right != null) {
                AVLNode min = searchMin(target.right);
                AVLNode minParent = searchParent(min.value);
                if (minParent.left == min) {
                    minParent.left = null;
                } else {
                    minParent.right = null;
                }
                min.left = target.left;
                min.right = target.right;
                if (parent.left == target) {
                    parent.left = min;
                } else {
                    parent.right = min;
                }
                //value有一个子节点
            } else {
                if (parent.left == target) {
                    if (target.left != null) {
                        parent.left = target.left;
                    } else {
                        parent.left = target.right;
                    }
                } else {
                    if (target.left != null) {
                        parent.right = target.left;
                    } else {
                        parent.right = target.right;
                    }
                }
            }
        }

    }

    //从某一结点求树高
    public int height(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max((node.left == null ? 0 : height(node.left)), (node.right == null ? 0 : height(node.right))) + 1;
    }

    //左旋，画图理解再写代码
    public void leftRotate(AVLNode node) {
        AVLNode newNode = new AVLNode(node.value);
        newNode.left = node.left;
        newNode.right = node.right.left;
        node.value = node.right.value;
        node.left = newNode;
        node.right = node.right.right;
    }

    //右旋
    public void rightRotate(AVLNode node) {
        AVLNode newNode = new AVLNode(node.value);
        newNode.right = node.right;
        newNode.left = node.left.right;
        node.value = node.left.value;
        node.right = newNode;
        node.left = node.left.left;
    }

    //调整节点
    public void adjust(AVLNode node) {
        if (node.left != null) {
            adjust(node.left);
        }
        if (node.right != null) {
            adjust(node.right);
        }
        if (height(node.right) - height(node.left) > 1) {
            if (height(node.right.left) > height(node.right.right)) {
                rightRotate(node.right);
            }
            leftRotate(node);
            return;
        }

        if (height(node.left) - height(node.right) > 1) {
            if (height(node.left.right) > height(node.left.left)) {
                leftRotate(node.left);
            }
            rightRotate(node);
        }
    }
}

class AVLNode {
    int value;
    AVLNode left;
    AVLNode right;

    public AVLNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "value=" + value +
                '}';
    }
}
