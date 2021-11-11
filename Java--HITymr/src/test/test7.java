package test;

//在已排序的数组元素中查找：>二分法举例
public class test7 {
    static int[] rep = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    //二分法
    //在给定的数组范围内查找某一元素，
    //方法重载 overload
    private static int search(int i, int lower, int upper) {
        int index = lower;
        // 里面是个递归(中间值然后左右递归)(参数1是你要找的数,参数2是起始位置,参数3是末尾位置,rep是个int数组)
        if (upper >= lower) {
            int middle = (upper + lower) / 2;
            //取出数组中间的那个元素
            int current = rep[middle];

            //把insert的数字与已有的数组中最中间的那个数进行比较
            //如果相同，就返回中间这个数的下标
            if (current == i) {
                index = middle;
            } else if (current < i) { //如果insert的数字大于中间数字，就再来一遍，把insert的数 和 数组中大于中间数字的数的中间数进行比较！
                index = search(i, middle + 1, upper);
            } else { //如果insert的数字小于中间数字，也再来一遍，把insert的数 和 数组中小于中间数字的数的中间数进行比较！
                index = search(i, lower, middle - 1);
            }
        }
        return index;
    }

    public static void main(String[] args) {

        int searchNumber = 9;
        System.out.println("the number \"" + searchNumber + "\" appears in the location of " + search(searchNumber, 1, 9));
    }
}
