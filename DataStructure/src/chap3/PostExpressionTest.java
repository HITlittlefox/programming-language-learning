package chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import chap3.SeqStackLinStack.LinStack;

public class PostExpressionTest {

    // ��׺ת��׺ ʱ����������Ҫ�ĵ�ǰλ��
    private static int currentIndex = 0;

    // ��׺ת��׺
    // ʹ�õ�����ʵ�֣������ŵģ���׺ת��׺
    // 1.������׺List
    // 2.�ж��Ƿ�Ϊ��(��
    // ��ʼ����
    // 3.�ж��Ƿ�Ϊ")"
    // ��������
    private static List<String> parseSufixExpression(List<String> infixExpression) {
        List<String> resultList = new ArrayList<String>();
        // ��Ų�����ջ
        Stack<String> stackOperation = new Stack<>();
        // ��ȡ����ǰ��������ָ��
        // ������׺���ѵ�ǰ����λ�ü�Ϊindex
        // index Ϊ��׺��λ��
        for (; // ����Ҫ
             currentIndex < infixExpression.size(); currentIndex++) {
            // ������׺��ǰ�ַ�
            String s = infixExpression.get(currentIndex);
            // ���ǲ�������
            if (!s.matches("\\D")) {
                // ��������֣��ͼ���������
                resultList.add(s);
            } else if (s.equals("(")) {
                // �����������
                // ��ʼ����
                // �ѵ����Ľ��
                // ������һ���ַ�
                currentIndex++;
                resultList.addAll(parseSufixExpression(infixExpression));
            } else if (s.equals(")")) {
                // �����������
                // ����ѭ����������
                break;
            } else {
                // ����������֣�����()
                // �����жϣ��Ӽ��˳�
                switch (s) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        // ջ�ж����Ļ�
                        if (stackOperation.size() > 0) {
                            while (stackOperation.size() > 0) {
                                // ջ��ȡԪ��
                                String strTemp = stackOperation.pop();
                                if (isHeightLevel(s, strTemp)) {
                                    // ������е�s��ջ���ȣ����ȼ��ߣ��ʹ���
                                    stackOperation.push(strTemp);
                                    break;
                                } else {
                                    // ����Ͱ�ջ��Ԫ�������list
                                    resultList.add(strTemp);
                                }
                            }
                            // ��ջ��Ҫ������󣬣���s����ջ
                            stackOperation.push(s);
                        } else {
                            // ���ջ��,ֱ�ӽ���ջ
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
        // ��������󣬳�ʼ��index
        initialIndex(infixExpression);
        return resultList;
    }

    private static void initialIndex(List<String> Expression) {
        if (!(currentIndex < Expression.size())) {
            currentIndex = 0;
        }
    }

    // �ж����ȼ�
    private static boolean isHeightLevel(String s, String sTemp) {
        return getLevel(s) - getLevel(sTemp) > 0 ? true : false;
    }

    // ��ȡ���ȼ�
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

    // �ָ��ַ�
    // 1 ����һ�����ɶ���ո�������ַ�
    // 2 �ָ���Щ�ַ�
    // 3 �����ַ�ArrayList
    private static List<String> parseExpression(String str) {
        // �ո�ֿ��ַ�
        String[] strTemp = str.split("\\s+");
        // �ַ�����List
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
        System.out.print("�����׺���ʽ(���ʽ��#���Ž���):");
        System.out.println(str);
        System.out.print("�����ȡ���ĺ�׺���ʽ:");
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
                                throw new Exception("����Ϊ����! ");
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
        System.out.println("��׺���ʽ������Ϊ:" + s.pop());
    }

    public static void main(String[] args) {
        // String infix_expression = "1 + 2 * 3 + ( 4 + 5 ) * 6 - 7";
        // String infix_expression = "2 * 1 * 3 + ( 4 + 5 ) * 6 - 7";
        String infix_expression = "3 + ( 6 - 4 / 2 ) * 5 ";

        // String infix_expression = "A + ( B - C / D ) * E # "; //27
        System.out.println("��׺���ʽ��" + infix_expression);
        List<String> suffix_strTemp = parseSufixExpression(
                parseExpression(infix_expression));
        // System.out.println("ת�ɺ�׺���ʽ��" + suffix_strTemp.toString());
        // System.out.println("ת�ɺ�׺���ʽ��" + (A
        // rays.toString(suffix_strTemp.toArray())));
        System.out
                .println("ת�ɺ�׺���ʽ��" + Arrays.toString(suffix_strTemp.toArray()).replaceAll(",", "").replace("[", "")
                        .replace("]", "").replace(" ", ""));

        String finalStr = Arrays.toString(suffix_strTemp.toArray()).replaceAll(",", "").replace("[", "")
                .replace("]", "").replace(" ", "");

        // System.out.println("�ַ���" + finalStr);
        finalStr = finalStr + "#";
        // System.out.println("�ַ���" + finalStr);

        LinStack myStack = new LinStack();
        try {
            postExp(myStack, finalStr);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
