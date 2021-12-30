package chap3;

//从大到小的基数排序
//要求进出桶中的数据元素序列满足先进先出FIFO的原则，所以这里说的桶就是序列
//设计时把所需的10个队列设计成一个队列数组
public class radixSort2 {
    static int[] b = new int[1];

    //a为要排序的数据元素，d为进制的基数，m为数据元素的最大位数
    public static int[] radixSort2(int[] a, int m, int d) throws Exception {
        int n = a.length;

        int i, j, k, k2, l, power = 0;
        LinQueue[] myQueue = new LinQueue[d];


        //把十以内的数字放到最后面
        int i2 = a.length - 1;
        int i3 = 0;
        int temp3 = 0;
        for (i = 0; i < a.length; i++) {
            if (a[i] <= 9) {
                b[i3] = a[i];

                temp3 = a[i];
                a[i] = a[i2];
                a[i2] = temp3;

            }
        }


        int[] a2 = new int[9];
        for (int o = 0; o < a2.length; o++) {

            a2[o] = a[o];
//            System.out.print(a2[o] + ",");
        }
//        System.out.println();

        //创建链式队列数组对象
        for (i = 0; i < a2.length; i++) {
            LinQueue temp = new LinQueue();
            myQueue[i] = temp;
        }

        //百位，获得第一个桶，百位桶
        power = 100;
        //下面的循环是按照某位的情况，按照该数字的某位数字的大小，挨个塞入相应队列，所以进入下面循环之前，就确定了个十百位
        //依次将n个数据元素按第k位的大小放到相应的队列中
        for (j = 0; j < a2.length; j++) {
            //计算k值
            k = a2[j] / power - (a2[j] / (power * d)) * d;
            //a2[j]入队列k
            myQueue[k].append(a2[j]);
        }

        //十位，获得第二个桶，十位桶
        power = 10;
        //下面的循环是按照某位的情况，按照该数字的某位数字的大小，挨个塞入相应队列，所以进入下面循环之前，就确定了个十百位
        //依次将n个数据元素按第k位的大小放到相应的队列中
        for (j = 0; j < a2.length; j++) {
            //通过第二位排序
            if (myQueue[j].front != null && myQueue[j].rear != null) {
//                System.out.println(myQueue[j].front);
//                System.out.println(myQueue[j].rear);
                if ((int) myQueue[j].front.data > (int) myQueue[j].rear.data) {
                    int temp = (int) myQueue[j].front.data;
                    myQueue[j].front.data = (int) myQueue[j].rear.data;
                    myQueue[j].rear.data = (int) temp;
                }
            }
        }

        //顺序回收各队列中的数据元素到数组a2中
        l = 8;

        for (j = 0; j < a2.length; j++) {
            while (myQueue[j].notEmpty()) {
                a2[l] = (Integer) myQueue[j].delete();
                l--;
            }
        }
        return a2;
    }

    public static void main(String[] args) throws Exception {
        int[] a = new int[]{710, 342, 45, 686, 6, 841, 429, 134, 68, 264};
        for (int i : radixSort2(a, 3, 10)) {
            System.out.println(i);
        }

        for (int i : b) {
            System.out.println(i);

        }
    }
}

