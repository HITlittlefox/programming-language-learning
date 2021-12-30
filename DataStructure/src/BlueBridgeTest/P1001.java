package BlueBridgeTest;

//小明对数位中含有 2、0、1、9 的数字很感兴趣，
// 在 1 到 40 中这样的数包括 1、2、9、10 至 32、39 和 40，共 28 个，他们的和是 574，平方和是 14362。
//注意，平方和是指将每个数分别平方后求和。
//请问，在 1 到 2019 中，所有这样的数的平方和是多少？
public class P1001 {
    public static void main(String[] args) {
//        int aimNumber = 40;
        int aimNumber = 2019;
        int[] target = new int[]{2, 0, 1, 9, 111};
        int total = 0;

        for (int i = 1; i <= aimNumber; i++) {
            for (int j = 0; j < target.length; j++) {
                int k = target[j];
                //个位、十位、百位、千位
                if ((k == i % 10)//个位
                        || (i > 10 & i <= 100 & k == ((i - i % 10) / 10))//十位
                        || (i > 100 & i < 1000 & k == (i - (i - i % 10 - (i - i % 10))) / 100)) //百位
                {
                    total = total + i * i;
                    System.out.println(i);
                    k = 4;
                    break;
                }

            }

        }
        System.out.println("total:" + total);
//        for (int i = 1; i <= 40; i++) {
//            System.out.println("i=" + i);
//            System.out.println("i %10=" + i % 10);
//            System.out.println("(i-i%10)/10=" + (i - i % 10) / 10);
////            System.out.println("i - 10 * (i / 10)=" + (i - 10 * (i / 10)));
//        }


    }
}
