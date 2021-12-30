package HanShunPing.threadedbinarytree;

import chap2.SingleList.Node;

//应用案例说明:将下面的二叉树，进行中序线索二叉树。
// 中序遍历的数列为{8,3,10,1,14,6}
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //=0表示表示有左右孩子指针 =1表示设置为前驱或后驱
        // 测试一把中序线索二叉树的功能
//        HeroNode root = new HeroNode(1, "tom");
//        HeroNode node2 = new HeroNode(3, "jack");
//        HeroNode node3 = new HeroNode(6, "smith");
//        HeroNode node4 = new HeroNode(8, "mary");
//        HeroNode node5 = new HeroNode(10, "king");
//        HeroNode node6 = new HeroNode(14, "dim");
        HeroNode root = new HeroNode(1, "1");
        HeroNode node2 = new HeroNode(3, "3");
        HeroNode node3 = new HeroNode(6, "6");
        HeroNode node4 = new HeroNode(8, "8");
        HeroNode node5 = new HeroNode(10, "10");
        HeroNode node6 = new HeroNode(14, "14");

        // 二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        // 测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        // 测试: 以10号节点测试
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是 =" + leftNode); // 3
        System.out.println("10号结点的后继结点是=" + rightNode); // 1

        //当线索化二叉树后，不能使用原来的遍历方法
        System.out.println("使用线索化的方式遍历 线索化二叉树");
        threadedBinaryTree.threadedList();//8 3 10 1 14 6
//        // 测试中序线索化遍历
//        System.out.println("-------美丽的分割线------------");
//        threadedBinaryTree.threadedList();// 8,3,10,1,14,6
    }
}


//先创建HeroNode结点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return RightType;
    }

    public void setRightType(int rightType) {
        RightType = rightType;
    }

    //说明
    //1. 如果leftType == 0 表示指向的是左子树，如果1则表示指向前驱结点
    //2. 如果rightType == 0 表示指向的是右子树，如果1表示指向后继结点
    private int leftType;
    private int RightType;


    public HeroNode(int no, String name) {
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name='" + name + '\'' + '}';
    }

    //递归删除结点
    //1. 如果删除的结点是叶子节点，则删除该结点
    //2. 如果删除的结点是非叶子节点，则删除该子树
    public void delNode(int no) {
        //思路

        /*
         1. 因为我们的二叉树是单向的，所以我们是判断"当前结点的子结点"是否需要删除结点，而不能去判断"当前这个结点"是不是需要删除结点
         2. 如果当前结点的左子结点不为空，并且左子结点就是要删除结点，就将this.left = null;并且就返回(结束递归删除)
         3. 如果当前结点的右子结点不为空，并且右子结点就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
         4. 如果第2和第3步没有删除结点,那么我们就需要向左子树进行递归删除
         5. 如果第4步也没有删除结点,则应当向右子树进行递归删除。
         */


        // 2. 如果当前结点的左子结点不为空，并且左子结点就是要删除结点，就将this.left = null;并且就返回(结束递归删除)

        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        // 3. 如果当前结点的右子结点不为空，并且右子结点就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        // 4. 我们就需要向左子树进行递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }
        // 5. 我们就需要向右子树进行递归删除
        if (this.right != null) {
            this.right.delNode(no);
        }


    }


    //编写前序遍历的方法
    public void preOrder() {
        //先输出父节点
        System.out.println(this);
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //判断，递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {

        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        //判断，递归向右子树中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }

    /**
     * @param no 查找no
     * @return 如果找到就返回该Node，否则返回null
     */
    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序遍历查找");
        //比较当前结点是不 是
        if (this.no == no) {
            return this;
        }
        //则判断当前结点的左子结点是否为空，如果不为空，则递归前序查找
        //如果左递归前序查找，找到结点，则返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            //说明我们左子树找到了
            return resNode;
        }
        //如果左递归前序查找，找到结点，则返回，否则继续判断
        //当前结点的右子结点是否为空，如果不空，则继续向右递归前序查找
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        //则判断当前结点的左子结点是否为空，如果不为空，则递归前序查找
        //如果左递归前序查找，找到结点，则返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            //说明我们左子树找到了
            return resNode;
        }
        //比较当前结点是不是，如果找到，则返回，如果没有找到，就和当前结点比较，如果是则返回当前结点
        System.out.println("进入中序遍历查找");
        //不要放在第一行，要放在判断当前节点是不是的前面一行
        if (this.no == no) {
            return this;
        }
        //否则继续进行右递归的中序查找
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        //则判断当前结点的左子结点是否为空，如果不为空，则递归前序查找
        //如果左递归前序查找，找到结点，则返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            //说明我们左子树找到了
            return resNode;
        }
        //如果左子树没有找到，则向右子树递归进行后序遍历查找
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
//            return resNode;
        }

        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入后序遍历查找");
        //不要放在第一行，要放在判断当前节点是不是的前面一行
        //如果左右子树都没有找到，就比较当前结点是不是
        if (this.no == no) {
            return this;
        }
        return resNode;
    }


}


//定义ThreadedBinaryTree二叉树
//实现线索化功能的二叉树
class ThreadedBinaryTree {
    private HeroNode root;

    // 重载方便调用
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    //1. 为了实现线索化，需要创建一个指向当前结点的前驱结点的指针
    //2. 在递归进行线索化时，pre总是保留前一个结点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }


    //遍历线索化二叉树的方法（中序）
    //=0表示表示有左右孩子指针 =1表示设置为前驱或后驱
    public void threadedList() {
        //定义一个变量，存储当前遍历的结点，从root开始
        HeroNode node = root;
        while (node != null) {
            //循环的找到leftType == 1 的结点，第一个找到的就是8结点
            //后面随着遍历而变化，因为当leftType == 1时，说明该节点是按照线索化处理后的有效结点
            //一直去找左孩子
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            //打印当前这个结点
            System.out.println(node);
            //如果当前结点的右指针指向的是后继结点，就一直输出
            //如果找到右线索，就继续找
            while (node.getRightType() == 1) {
                //获取到当前结点的后继结点
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个遍历的结点
            node = node.getRight();
        }


    }
    //编写对二叉树进行中序线索化的方法

    /**
     * @param node 当前需要线索化的结点
     */
    public void threadedNodes(HeroNode node) {
        //如果当前结点为空，就无法线索化
        if (node == null) {
            return;
        }

        //然后对于right：让当前节点node的前驱节点pre的右指针指向当前节点node


        //(一)先线索化左子树
        threadedNodes(node.getLeft());
        //(二)线索化当前结点
        //以8结点来理解
        //8结点的.left=null,8结点的.leftType=1
        if (node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的做指针的类型，指向前驱结点
            node.setLeftType(1);
        }

        //处理后继节点
        if (pre != null && pre.getRight() == null) {
            //让前驱节点的右指针指向当前结点
            pre.setRight(node);
            //修改前驱结点的右指针类型
            pre.setRightType(1);
        }

        //每处理一个节点后，让当前结点时下一个结点的前驱结点
        pre = node;

        //(三)再线索化右子树
        threadedNodes(node.getRight());
    }

    //删除结点
    public void delNode(int no) {
        if (root != null) {
            //如果只有一个root结点，这里立即判断root是不是要删除的结点
            if (root.getNo() == no) {
                root = null;
            } else {
                //递归删除
                root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除~");
        }
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序查找
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序查找
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序查找
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }
}
