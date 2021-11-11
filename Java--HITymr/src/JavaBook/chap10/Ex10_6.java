package JavaBook.chap10;

import java.io.*;

class CopyMaker {
    String sourceName, destName;
    BufferedReader source;
    BufferedWriter dest;
    String line;

    //打开文件
    private boolean openFiles() {
        try {
            //打开源文件
            source = new BufferedReader(new FileReader(sourceName));
        } catch (IOException iox) {
            System.out.println("Problem opening source file:" + sourceName);
            return false;
        }
        try {
            //打开目标文件
            dest = new BufferedWriter(new FileWriter(destName));
        } catch (IOException iox) {
            System.out.println("Problem opening destination file:" + destName);
            return false;
        }

        return true;
    }

    //复制内容
    private boolean copyFiles() {
        try {
            //从源文件读
            line = source.readLine();
            //往目标文件写
            while (line != null) {
                dest.write(line);
                dest.newLine();
                //从源文件读
                line = source.readLine();
            }
        } catch (IOException iox) {
            System.out.println("Problem reading or writing");
            return false;
        }

        return true;
    }

    //关闭文件
    private boolean closeFiles() {
        boolean retVal = true;

        try {
            //关闭源文件
            source.close();
        } catch (IOException iox) {
            System.out.println("Problem closing source file:" + sourceName);
            retVal = false;
        }

        try {
            //关闭目标文件
            dest.close();
        } catch (IOException iox) {
            System.out.println("Problem closing destination file:" + destName);
            retVal = false;
        }

        return retVal;
    }

    //复制器的复制方法，有两个参数，一个是source原文件，一个是destination目标文件
    public boolean copy(String src, String dst) {
        sourceName = src;
        destName = dst;
        return openFiles() && copyFiles() && closeFiles();
    }
}


public class Ex10_6 {
    public static void main(String[] args) {
        if (args.length == 2) {
            CopyMaker cm = new CopyMaker();
            cm.copy(args[0], args[1]);
        } else
            System.out.println("Please Enter File names");
    }
}
