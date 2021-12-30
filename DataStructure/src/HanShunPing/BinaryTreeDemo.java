package HanShunPing;

import javax.xml.bind.Binder;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        //����Ҫ����һ�Ŷ�����
        BinaryTree binaryTree = new BinaryTree();
        //������Ҫ�Ľ��
        HeroNode root = new HeroNode(1, "�ν�");
        HeroNode node2 = new HeroNode(2, "����");
        HeroNode node3 = new HeroNode(3, "¬����");
        HeroNode node4 = new HeroNode(4, "�ֳ�");
        HeroNode node5 = new HeroNode(5, "��ʤ");

        //˵�������ֶ������ö�������������ѧϰʹ�õݹ鷽ʽ����������
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        //����
        System.out.println("ǰ�����");//1,2,3,4
        //1,2,3,5,4
        binaryTree.preOrder();
        //����
        System.out.println("�������");//2,1,3,4
        //21534
        binaryTree.infixOrder();
        //����
        System.out.println("�������");//2,4,3,1
        //25431
        binaryTree.postOrder();

//        //ǰ�����
//        //ǰ����ң�4��
//        System.out.println("ǰ�������ʽ~~~");
//        int number = 5;
//        HeroNode resNode = binaryTree.preOrderSearch(number);
//        if (resNode != null) {
//            System.out.printf("�ҵ��ˣ���Ϣλno=%d name=%s", resNode.getNo(), resNode.getName());
//        } else {
//            System.out.printf("û���ҵ�no=%d��Ӣ��", number);
//
//        }

//        //�������
//        //������ң�3��
////        System.out.println("���������������");
////        ��Ҫ���ڵ�һ�У�Ҫ�����жϵ�ǰ�ڵ��ǲ��ǵ�ǰ��һ��
//        System.out.println("���������ʽ~~~");
//        int number = 5;
//        HeroNode resNode = binaryTree.infixOrderSearch(number);
//        if (resNode != null) {
//            System.out.printf("�ҵ��ˣ���Ϣλno=%d name=%s", resNode.getNo(), resNode.getName());
//        } else {
//            System.out.printf("û���ҵ�no=%d��Ӣ��", number);
//
//        }

//        //�������
//        //������ң�2��
////        System.out.println("���������������");
////        ��Ҫ���ڵ�һ�У�Ҫ�����жϵ�ǰ�ڵ��ǲ��ǵ�ǰ��һ��
//        System.out.println("���������ʽ~~~");
//        int number = 5;
//        HeroNode resNode = binaryTree.postOrderSearch(number);
//        if (resNode != null) {
//            System.out.printf("�ҵ��ˣ���Ϣλno=%d name=%s", resNode.getNo(), resNode.getName());
//        } else {
//            System.out.printf("û���ҵ�no=%d��Ӣ��", number);
//
//        }

//        //ɾ��ǰ
//        System.out.println("ɾ��ǰ��ǰ�������");
//        binaryTree.preOrder();
//        binaryTree.delNode(3);
//        System.out.println("ɾ����ǰ�������");
//        binaryTree.preOrder();

    }
}

//����BinaryTree������
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //ɾ�����
    public void delNode(int no) {
        if (root != null) {
            //���ֻ��һ��root��㣬���������ж�root�ǲ���Ҫɾ���Ľ��
            if (root.getNo() == no) {
                root = null;
            } else {
                //�ݹ�ɾ��
                root.delNode(no);
            }
        } else {
            System.out.println("����������ɾ��~");
        }
    }

    //ǰ�����
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

    //�������
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

    //�������
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }
    }

    //ǰ�����
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //�������
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //�������
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }
}

//�ȴ���HeroNode���
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

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

    //�ݹ�ɾ�����
    //1. ���ɾ���Ľ����Ҷ�ӽڵ㣬��ɾ���ý��
    //2. ���ɾ���Ľ���Ƿ�Ҷ�ӽڵ㣬��ɾ��������
    public void delNode(int no) {
        //˼·

        /*
         1. ��Ϊ���ǵĶ������ǵ���ģ������������ж�"��ǰ�����ӽ��"�Ƿ���Ҫɾ����㣬������ȥ�ж�"��ǰ������"�ǲ�����Ҫɾ�����
         2. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�����Ҫɾ����㣬�ͽ�this.left = null;���Ҿͷ���(�����ݹ�ɾ��)
         3. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�����Ҫɾ����㣬�ͽ�this.right= null ;���Ҿͷ���(�����ݹ�ɾ��)
         4. �����2�͵�3��û��ɾ�����,��ô���Ǿ���Ҫ�����������еݹ�ɾ��
         5. �����4��Ҳû��ɾ�����,��Ӧ�������������еݹ�ɾ����
         */


        // 2. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�����Ҫɾ����㣬�ͽ�this.left = null;���Ҿͷ���(�����ݹ�ɾ��)

        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        // 3. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�����Ҫɾ����㣬�ͽ�this.right= null ;���Ҿͷ���(�����ݹ�ɾ��)
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        // 4. ���Ǿ���Ҫ�����������еݹ�ɾ��
        if (this.left != null) {
            this.left.delNode(no);
        }
        // 5. ���Ǿ���Ҫ�����������еݹ�ɾ��
        if (this.right != null) {
            this.right.delNode(no);
        }


    }


    //��дǰ������ķ���
    public void preOrder() {
        //��������ڵ�
        System.out.println(this);
        //�ݹ���������ǰ�����
        if (this.left != null) {
            this.left.preOrder();
        }
        //�жϣ��ݹ���������ǰ�����
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //�������
    public void infixOrder() {

        //�ݹ����������������
        if (this.left != null) {
            this.left.infixOrder();
        }
        //������ڵ�
        System.out.println(this);
        //�жϣ��ݹ����������������
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //�������
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        //������ڵ�
        System.out.println(this);
    }

    /**
     * @param no ����no
     * @return ����ҵ��ͷ��ظ�Node�����򷵻�null
     */
    //ǰ���������
    public HeroNode preOrderSearch(int no) {
        System.out.println("����ǰ���������");
        //�Ƚϵ�ǰ����ǲ� ��
        if (this.no == no) {
            return this;
        }
        //���жϵ�ǰ�������ӽ���Ƿ�Ϊ�գ������Ϊ�գ���ݹ�ǰ�����
        //�����ݹ�ǰ����ң��ҵ���㣬�򷵻�
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            //˵�������������ҵ���
            return resNode;
        }
        //�����ݹ�ǰ����ң��ҵ���㣬�򷵻أ���������ж�
        //��ǰ�������ӽ���Ƿ�Ϊ�գ�������գ���������ҵݹ�ǰ�����
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //�����������
    public HeroNode infixOrderSearch(int no) {
        //���жϵ�ǰ�������ӽ���Ƿ�Ϊ�գ������Ϊ�գ���ݹ�ǰ�����
        //�����ݹ�ǰ����ң��ҵ���㣬�򷵻�
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            //˵�������������ҵ���
            return resNode;
        }
        //�Ƚϵ�ǰ����ǲ��ǣ�����ҵ����򷵻أ����û���ҵ����ͺ͵�ǰ���Ƚϣ�������򷵻ص�ǰ���
        System.out.println("���������������");
        //��Ҫ���ڵ�һ�У�Ҫ�����жϵ�ǰ�ڵ��ǲ��ǵ�ǰ��һ��
        if (this.no == no) {
            return this;
        }
        //������������ҵݹ���������
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //�����������
    public HeroNode postOrderSearch(int no) {
        //���жϵ�ǰ�������ӽ���Ƿ�Ϊ�գ������Ϊ�գ���ݹ�ǰ�����
        //�����ݹ�ǰ����ң��ҵ���㣬�򷵻�
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            //˵�������������ҵ���
            return resNode;
        }
        //���������û���ҵ��������������ݹ���к����������
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
//            return resNode;
        }

        if (resNode != null) {
            return resNode;
        }
        System.out.println("��������������");
        //��Ҫ���ڵ�һ�У�Ҫ�����жϵ�ǰ�ڵ��ǲ��ǵ�ǰ��һ��
        //�������������û���ҵ����ͱȽϵ�ǰ����ǲ���
        if (this.no == no) {
            return this;
        }
        return resNode;
    }


}
