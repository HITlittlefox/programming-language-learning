package chap6.Hw615;

public class NQueen {
    private int n; // �ʺ����
    private int s[]; // ��Ž��һά����
    private int count; // �ڼ�����ͽ���ܸ���

    public NQueen(int i) {
        n = i;
        count = 0;
        s = new int[n];
    }

    // ��ӡ��
    public void print() {
        int i;
        count++;
        System.out.println("��" + count + "���⣬�����ʺ�ڷŵ�����λ�÷ֱ��ǣ�");
        for (i = 0; i < n; i++)
            System.out.print("(" + i + "," + s[i] + ")"); // s[i]��ʾ��i���ʺ�ڷŵ��кš���i�ʺ�ڷ������꣨i,s[i]��λ����
        System.out.println();
    }

    public static int abs(int i) {
        if (i < 0)
            return -i;
        return i;
    }

    public boolean place(int k, int i) {// �жϵ�k�лʺ���ڵ�i��λ���Ƿ����
        for (int j = 0; j < k; j++) // ��������ڵ�k�е�k�ʺ��Ƿ����0~k-1���ϵ�ÿ���ʺ�(��k������ǰk��)��ͻ
            // ���ܶԽ��ߡ���������
            if ((s[j] == i) || (abs(s[j] - i) == abs(j - k)))
                return false;
        return true;
    }

    // ��k�У���i��
    public void NQueens(int k) { // �ڵ�k�еĺ����аڷ�k�ʺ�
        for (int i = 0; i < n; i++) { // �ڵ�k�еĸ�������
            if (place(k, i)) {// �ж��ڵ�k�е�i���Ϸ�k�ʺ� ���ʷ�������ʣ����k�ʺ����i���ϣ������һ�����н�
                s[k] = i;
                if (k == n - 1)
                    print();
                else
                    NQueens(k + 1);
            }
        }
    }
}
