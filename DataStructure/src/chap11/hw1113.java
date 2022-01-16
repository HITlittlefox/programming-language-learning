package chap11;

//11-13��ϣ������ơ�Ҫ��:
//(1)��ϣ�������ó�������������ϣ��ͻ�����������Ϊ������ϣ��ͻ�Ĳ�ͬ��ͬ��ʽ�����ͬ�ĵ���������
//(2�����һ�����Գ�����в��ԡ�

//1��������������ȡ�ؼ��ֱ�ĳ��������ɢ�б��m����p�������õ�����Ϊɢ�е�ַ���� H(key) = key MOD p,p<=m��
//2������̽����ɢ�У�Hi=(H(key) + di) MOD m,i=1,2������k(k<=m-1��������H(key��Ϊɢ�к�����mΪɢ�б���di=1,2,3������m-1

public class hw1113 {
    static int key[] = {47, 7, 29, 11, 16, 22, 92, 3, 8, 22};
    static int N = key.length;    //ɢ�б���
    static int ht[] = new int[N];

    public static void main(String[] args) {
        for (int i = 0; i < ht.length; i++) {
            ht[i] = -1;    //��ʼ�����ɸ���ʵ�������ʼ��
        }
        //	System.out.println(N);
        System.out.print("ɢ�е�ַ:	");
        for (int i = 0; i < ht.length; i++) {
            System.out.print(i + "	");
        }

        for (int i = 0; i < key.length; i++) {
            hashSearch(ht, N, key[i]);
        }

        System.out.println();
        System.out.print("�ؼ���:	");
        for (int i = 0; i < ht.length; i++) {
            System.out.print(ht[i] + "	");
        }

    }

    //ɢ�б��±�
    static int h(int v) {
        return v % N;
    }

    static int hashSearch(int ht[], int len, int k) {
        int j = h(k);
        if (ht[j] == k) {//���ҳɹ�
            return j;
        } else if (ht[j] == -1) {//��λ��Ϊ�գ����룬����
            ht[j] = k;
            return j;
        }
        int i = (j + 1) % N;
        while (ht[i] != -1 && i != j) {//ѭ������ɢ�б�
            if (ht[i] == k) {
                return i;
            } else {
                i = (++i) % N;
            }
        }
        if (i == j) {//����ɢ�б�һ�飬û�ҵ�����
            System.err.println("��ϣ�������");
        } else {
            ht[i] = k;
            return i;
        }
        return 0;
    }

}
