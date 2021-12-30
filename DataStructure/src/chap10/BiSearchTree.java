package chap10;
//��ҵ10-9 ��Ƶݹ�ṹ�Ķ������������ҳ�Ա���� searchBST
//��ҵ10-10 ���ѭ���ṹ�Ķ��������������Ա���� insertBST

//������������
public class BiSearchTree {
    //���ڵ�
    private BiTreeNode root;
//    Vector vector = new Vector();

    //����
    private void inOrder(BiTreeNode t, Visit vs) {
        if (t != null) {
            inOrder(t.getLeftChild(), vs);
            vs.print(new Integer(t.getData()));
            inOrder(t.getRightChild(), vs);
        }
    }

    //ǰ��
    private void preOrder(BiTreeNode t, Visit vs) {
        if (t != null) {
            vs.print(new Integer(t.getData()));
            preOrder(t.getLeftChild(), vs);
            preOrder(t.getRightChild(), vs);
        }
    }

    //����
    public BiSearchTree() {
        root = null;
    }

    //�����ڵ㴴����
    public void setRoot(BiTreeNode t) {
        root = t;
    }

    public BiTreeNode getRoot() {
        return root;
    }

    //�������
    public void inOrder(Visit vs) {
        inOrder(root, vs);
    }

    //ǰ�����
    public void preOrder(Visit vs) {
        preOrder(root, vs);
    }

    public BiTreeNode getLeftChild(BiTreeNode current) {
        return current != null ? current.getLeftChild() : null;
    }

    public BiTreeNode getRightChild(BiTreeNode current) {
        return current != null ? current.getRightChild() : null;
    }


    //����(����ѭ���ṹ)
    public BiTreeNode find(int item) {
        if (root != null) {
            BiTreeNode temp = root;
            while (temp != null) {
                if (temp.getData() == item) return temp;//���ҳɹ�

                if (temp.getData() < item)
                    temp = temp.getRightChild();            //������������
                else
                    temp = temp.getLeftChild();            //������������
            }
        }
        return null;                                    //����ʧ��
    }

    //��ҵ10-9 ��Ƶݹ�ṹ�Ķ������������ҳ�Ա����
    //TODO:���Ҹ�дΪ�ݹ�ṹ

    /**
     * �����������Ĳ��� ���ݹ�ʵ�֣�
     * <p>
     * ���ҿ���������ʵ�ַ�����һ���ǵݹ飬һ����while ѭ����
     * �ڲ����ɾ��������Ҳ������Ҫ��ѯ��������ʱʹ��while ѭ���ȽϺã�����֪��Ҫ��ѯ����˫�׽��
     * ���ǵݹ��Ϊ���
     *
     * @param root
     * @param item
     * @return ����
     */
    public boolean searchBST(BiTreeNode root, int item) {
        if (root == null) {
            return false;
        } else if (item == root.getData()) {
            return true;
        } else if (item < root.getData()) {
            return searchBST(root.getLeftChild(), item);
        } else {
            return searchBST(root.getRightChild(), item);
        }
    }

    //��ӣ��ݹ飩
    public void insert(BiTreeNode ptr, int item) {
        if (item < ptr.getData()) {
            if (ptr.getLeftChild() == null) {
                BiTreeNode temp = new BiTreeNode(item);    //�����½��
                temp.setParent(ptr);    //��ptr�����Ϊtemp���ĸ����
                ptr.setLeftChild(temp);    //��temp�����Ϊptr�������ӽ��
            } else insert(ptr.getLeftChild(), item);        //���������ݹ�
        } else if (item > ptr.getData()) {
            if (ptr.getRightChild() == null) {
                BiTreeNode temp = new BiTreeNode(item); //�����½��
                temp.setParent(ptr); //��ptr�����Ϊtemp���ĸ����
                ptr.setRightChild(temp); //��temp�����Ϊptr�����Һ��ӽ��
            } else insert(ptr.getRightChild(), item);        //���������ݹ�
        }
    }

    //TODO:��дΪѭ���ṹ
    //��ҵ10-10 ���ѭ���ṹ�Ķ��������������Ա����

    /**
     * �����������Ĳ���
     *
     * @param key
     */
    public void insertBST(int key) {
        BiTreeNode p = root;
        /**��¼���ҽ���ǰһ�����*/
        BiTreeNode prev = null;
        /**һֱ������ȥ��ֱ���������������Ľ��λ��*/
        while (p != null) {
            prev = p;
            if (key < p.getData())
                p = p.getLeftChild();
            else if (key > p.getData())
                p = p.getRightChild();
            else
                return;
        }
        /**prve��Ҫ���Ž��ĸ��ڵ㣬���ݽ��ֵ�ô�С�����ڶ�Ӧ��λ��*/
        if (root == null)
            root = new BiTreeNode(key);
        else if (key < prev.getData())
            prev.setLeftChild(new BiTreeNode(key));
        else prev.setRightChild(new BiTreeNode(key));
    }

    //ɾ��
    public void delete(BiTreeNode ptr, int item) {
        if (ptr != null) {
            if (item < ptr.getData())
                //���������ݹ�
                delete(ptr.getLeftChild(), item);
            else if (item > ptr.getData())
                //���������ݹ�
                delete(ptr.getRightChild(), item);
            else if (ptr.getLeftChild() != null && ptr.getRightChild() != null) {
                //Ҫɾ�����Ѱ�ҵ�������Ҫɾ������������������ڵ����
                BiTreeNode min;
                min = ptr.getRightChild();            //ȡ��ǰ�����Һ��ӽ��
                while (min.getLeftChild() != null)
                    min = min.getLeftChild();        //minȡ�������ӽ��
                ptr.setData(min.getData());//��min������ֵ����ptr���
                delete(ptr.getRightChild(), min.getData());
                //��ptr�����������еݹ�ɾ��min���
            } else {
                if (ptr.getLeftChild() == null && ptr.getRightChild() != null) {
                    //Ҫɾ�����Ѱ�ҵ�������Ҫɾ�����ֻ�������������
                    ptr.getParent().setRightChild(ptr.getRightChild());
                    //��ptr˫�׵��Һ���ָ��ָ��ptr���Һ��ӽ��
                    ptr.getRightChild().setParent(ptr.getParent());
                    //��ptr�Һ��ӵ�˫��ָ��ptr��˫�׽��
                } else if (ptr.getRightChild() == null && ptr.getLeftChild() != null) {
                    //Ҫɾ�����Ѱ�ҵ�������Ҫɾ�����ֻ�������������
                    ptr.getParent().setLeftChild(ptr.getLeftChild());
                    //��ptr˫�׵����ӽ��ָ��ptr�������ӽ��
                    ptr.getLeftChild().setParent(ptr.getParent());
                    //��ptr���ӵ�˫��ָ��ptr��˫�׽��
                } else {
                    //Ҫɾ�����Ѱ�ҵ�������Ҫɾ�����ΪҶ�������
                    BiTreeNode p = ptr.getParent();
                    if (p.getLeftChild() == ptr)    //��Ҫɾ�������˫�׵�������
                        p.setLeftChild(null);    //��˫�׵������ÿ�
                    else                //��Ҫɾ�������˫�׵��Һ�����
                        p.setRightChild(null);    //��˫�׵��Һ����ÿ�
                }
            }
        }
    }
}
