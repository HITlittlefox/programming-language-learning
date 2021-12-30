package HanShunPing;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        //1,2,4,5,3,6,7
        System.out.println("==============================");
        arrBinaryTree.preOrder();
        System.out.println("==============================");
        arrBinaryTree.infixOrder();
        System.out.println("==============================");
        arrBinaryTree.postOrder();


    }
}

//��дһ��ArrayBinaryTree��ʵ��˳��洢����������
class ArrBinaryTree {
    public int[] arr;//�洢���ݽڵ������

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //����preOrder
    public void preOrder() {
        this.preOrder(0);
    }

    //����infixOrder
    public void infixOrder() {
        this.infixOrder(0);
    }

    //����postOrder
    public void postOrder() {
        this.postOrder(0);
    }
    //��дһ�����������˳��洢��������ǰ�����

    /**
     * @param index ������±�
     */
    public void preOrder(int index) {
        //�������Ϊ�գ�����arr.length=0
        if (arr == null || arr.length == 0) {
            System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
            return;
        }
        //�����ǰ���Ԫ��
        System.out.println(arr[index]);
        //����ݹ����
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }

        //���ҵݹ����
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    //��дһ�����������˳��洢���������������

    /**
     * @param index ������±�
     */
    public void infixOrder(int index) {

        //����ݹ����
        if ((index * 2 + 1) < arr.length) {
            infixOrder(index * 2 + 1);
        }
        //�������Ϊ�գ�����arr.length=0
        if (arr == null || arr.length == 0) {
            System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
            return;
        }
        //�����ǰ���Ԫ��
        System.out.println(arr[index]);
        //���ҵݹ����
        if ((index * 2 + 2) < arr.length) {
            infixOrder(index * 2 + 2);
        }
    }

    //��дһ�����������˳��洢���������������

    /**
     * @param index ������±�
     */
    public void postOrder(int index) {

        //����ݹ����
        if ((index * 2 + 1) < arr.length) {
            postOrder(index * 2 + 1);
        }

        //���ҵݹ����
        if ((index * 2 + 2) < arr.length) {
            postOrder(index * 2 + 2);
        }

        //�������Ϊ�գ�����arr.length=0
        if (arr == null || arr.length == 0) {
            System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
            return;
        }
        //�����ǰ���Ԫ��
        System.out.println(arr[index]);
    }

}
