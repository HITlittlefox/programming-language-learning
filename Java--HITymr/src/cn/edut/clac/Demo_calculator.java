
package cn.edut.clac;

public class Demo_calculator {
    public static void main(String[] args) {
        //运算表达式
        //答案：78
        String expression = "1 + 2 * 3 + "
                + "( 8 / 2 * 1 + 25 / 5 + ( 7 + ( 1 + 1 ) / 2 ) / 2  ) * 6"
                + " - 7";
        //运算结果
        int result = Calculator.calcExpression(expression);
        System.out.println("运算表达式："+ expression );
        System.out.println("结果："+result);
    }
}


