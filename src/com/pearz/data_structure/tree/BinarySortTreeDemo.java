package com.pearz.data_structure.tree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree tree = new BinarySortTree();
        for (int i : arr) {
            tree.add(new BinarySortTreeNode(i));
        }

        tree.inOrder(tree.root);
        System.out.println();

        tree.delNode(7);

        tree.inOrder(tree.root);
    }
}

class BinarySortTree {
    BinarySortTreeNode root;

    //中序遍历
    public void inOrder(BinarySortTreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root);
            inOrder(root.right);
        }
    }

    //添加节点
    public void add(BinarySortTreeNode node) {
        if (root == null) {
            root = node;
        } else {
            BinarySortTreeNode temp = root;
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
    }

    //寻找待删除节点
    public BinarySortTreeNode search(int value) {
        if (root == null) {
            return null;
        }
        BinarySortTreeNode temp = root;
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
    public BinarySortTreeNode searchParent(int value) {
        if (root == null || root.value == value) {
            return null;
        }
        BinarySortTreeNode temp = root;
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
    public BinarySortTreeNode searchMin(BinarySortTreeNode node) {
        if (node == null) {
            return null;
        }
        BinarySortTreeNode temp = node;
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
        BinarySortTreeNode target = search(value), parent = searchParent(value);
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
                BinarySortTreeNode min = searchMin(target.right);
                BinarySortTreeNode minParent = searchParent(min.value);
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
                BinarySortTreeNode min = searchMin(target.right);
                BinarySortTreeNode minParent = searchParent(min.value);
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
}

class BinarySortTreeNode {
    int value;
    BinarySortTreeNode left;
    BinarySortTreeNode right;

    public BinarySortTreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinarySortTreeNode{" +
                "value=" + value +
                '}';
    }
}
