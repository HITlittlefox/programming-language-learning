package JavaBook.chap9;

//命令行提供成绩，若提供的超过2位，则报一个空指针异常的错；若给出非数组，则check抛出数值格式异常，若没有提供参数，则在main中异常处理。
public class App9_5 {
    //方法后面那个是声明会抛出异常:我如果说我会抛出，但是实际ide没拿到这个异常，他就会说你为嘛说话不算数了
    static void check(String str1) throws NullPointerException {

        if (str1.length() > 2) {
//            str1 = null;
//            System.out.println(str1.length());
            throw new NullPointerException();
        }
        char ch;
        for (int i = 0; i < str1.length(); i++) {
            ch = str1.charAt(i);
            if (!Character.isDigit(ch)) {
                throw new NullPointerException();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int num;
        try {
            args = new String[]{"100"};
            check(args[0]);
            num = Integer.parseInt(args[0]);
            if (num > 60) {
                System.out.println("GoOn");
            } else {
                System.out.println("you need learn more!");
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException:" + e.toString());
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException:" + e.toString());
        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
    }
}
