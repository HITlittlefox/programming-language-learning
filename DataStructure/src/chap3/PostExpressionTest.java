package chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import chap3.SeqStackLinStack.LinStack;

public class PostExpressionTest {

    // 中缀转后缀 时，迭代所需要的当前位置
    private static int currentIndex = 0;

    // 中缀转后缀
    // 使用迭代，实现（带括号的）中缀转后缀
    // 1.遍历中缀List
    // 2.判断是否为“(”
    // 开始迭代
    // 3.判断是否为")"
    // 结束迭代
    private static List<String> parseSufixExpression(List<String> infixExpression) {
        List<String> resultList = new ArrayList<String>();
        // 存放操作的栈
        Stack<String> stackOperation = new Stack<>();
        // 获取到当前遍历到的指针
        // 遍历中缀，把当前操作位置记为index
        // index 为后缀的位置
        for (; // 不需要
             currentIndex < infixExpression.size(); currentIndex++) {
            // 遍历中缀当前字符
            String s = infixExpression.get(currentIndex);
            // 不是不是数字
            if (!s.matches("\\D")) {
                // 如果是数字，就加入输出结果
                resultList.add(s);
            } else if (s.equals("(")) {
                // 如果是左括号
                // 开始迭代
                // 把迭代的结果
                // 操作下一个字符
                currentIndex++;
                resultList.addAll(parseSufixExpression(infixExpression));
            } else if (s.equals(")")) {
                // 如果是右括号
                // 跳出循环结束迭代
                break;
            } else {
                // 如果不是数字，不是()
                // 进行判断，加减乘除
                switch (s) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        // 栈有东西的话
                        if (stackOperation.size() > 0) {
                            while (stackOperation.size() > 0) {
                                // 栈顶取元素
                                String strTemp = stackOperation.pop();
                                if (isHeightLevel(s, strTemp)) {
                                    // 如果现有的s和栈顶比，优先级高，就存入
                                    stackOperation.push(strTemp);
                                    break;
                                } else {
                                    // 否则就把栈顶元素输出到list
                                    resultList.add(strTemp);
                                }
                            }
                            // 把栈需要的输出后，，把s放入栈
                            stackOperation.push(s);
                        } else {
                            // 如果栈空,直接进入栈
                            stackOperation.push(s);
                        }
                        break;
                    default:
                        throw new RuntimeException();
                }
            }
        }
        while (stackOperation.size() > 0) {
            resultList.add(stackOperation.pop());
        }
        // 遍历到最后，初始化index
        initialIndex(infixExpression);
        return resultList;
    }

    private static void initialIndex(List<String> Expression) {
        if (!(currentIndex < Expression.size())) {
            currentIndex = 0;
        }
    }

    // 判断优先级
    private static boolean isHeightLevel(String s, String sTemp) {
        return getLevel(s) - getLevel(sTemp) > 0 ? true : false;
    }

    // 获取优先级
    private static int getLevel(String s) {
        switch (s) {
            case "+":
            case "-":
                return 0;
            case "*":
            case "/":
                return 1;
        }
        throw new RuntimeException();
    }

    // 分割字符
    // 1 接收一个：由多个空格隔开的字符
    // 2 分割这些字符
    // 3 返回字符ArrayList
    private static List<String> parseExpression(String str) {
        // 空格分开字符
        String[] strTemp = str.split("\\s+");
        // 字符存入List
        List<String> outList = new ArrayList<>();
        for (String s : strTemp) {
            outList.add(s);
        }
        return outList;
    }

    public static void postExp(LinStack s, String str) throws Exception {
        // public static void postExp(LinStack s) throws Exception {
        char ch;
        int x1, x2, b = 0;
        System.out.print("输入后缀表达式(表达式以#符号结束):");
        System.out.println(str);
        System.out.print("输出读取到的后缀表达式:");
        for (int i = 0; i < str.length(); i++) {
            // while ((ch = (char) (b = System.in.read())) != '#') {
            if ((ch = (char) (b = str.charAt(i))) != '#') {
                System.out.print(ch + "");

                if (Character.isDigit(ch)) {
                    s.push(new Integer(Character.toString(ch)));
                } else {
                    x2 = ((Integer) s.pop()).intValue();
                    x1 = ((Integer) s.pop()).intValue();
                    switch (ch) {
                        case '+':
                            x1 += x2;
                            break;
                        case '-':
                            x1 -= x2;
                            break;
                        case '*':
                            x1 *= x2;
                            break;
                        case '/':
                            if (x2 == 0) {
                                throw new Exception("除数为О错! ");
                            } else {
                                x1 /= x2;
                                break;
                            }
                    }
                    s.push(new Integer(x1));
                }
            }
        }
        System.out.println();
        System.out.println("后缀表达式计算结果为:" + s.pop());
    }

    public static void main(String[] args) {
        // String infix_expression = "1 + 2 * 3 + ( 4 + 5 ) * 6 - 7";
        // String infix_expression = "2 * 1 * 3 + ( 4 + 5 ) * 6 - 7";
        String infix_expression = "3 + ( 6 - 4 / 2 ) * 5 ";

        // String infix_expression = "A + ( B - C / D ) * E # "; //27
        System.out.println("中缀表达式：" + infix_expression);
        List<String> suffix_strTemp = parseSufixExpression(
                parseExpression(infix_expression));
        // System.out.println("转成后缀表达式：" + suffix_strTemp.toString());
        // System.out.println("转成后缀表达式：" + (A
        // rays.toString(suffix_strTemp.toArray())));
        System.out
                .println("转成后缀表达式：" + Arrays.toString(suffix_strTemp.toArray()).replaceAll(",", "").replace("[", "")
                        .replace("]", "").replace(" ", ""));

        String finalStr = Arrays.toString(suffix_strTemp.toArray()).replaceAll(",", "").replace("[", "")
                .replace("]", "").replace(" ", "");

        // System.out.println("字符串" + finalStr);
        finalStr = finalStr + "#";
        // System.out.println("字符串" + finalStr);

        LinStack myStack = new LinStack();
        try {
            postExp(myStack, finalStr);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
