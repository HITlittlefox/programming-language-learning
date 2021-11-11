package JavaBook.chap10;

import java.io.*;

class CopyMaker {
    String sourceName, destName;
    BufferedReader source;
    BufferedWriter dest;
    String line;

    //���ļ�
    private boolean openFiles() {
        try {
            //��Դ�ļ�
            source = new BufferedReader(new FileReader(sourceName));
        } catch (IOException iox) {
            System.out.println("Problem opening source file:" + sourceName);
            return false;
        }
        try {
            //��Ŀ���ļ�
            dest = new BufferedWriter(new FileWriter(destName));
        } catch (IOException iox) {
            System.out.println("Problem opening destination file:" + destName);
            return false;
        }

        return true;
    }

    //��������
    private boolean copyFiles() {
        try {
            //��Դ�ļ���
            line = source.readLine();
            //��Ŀ���ļ�д
            while (line != null) {
                dest.write(line);
                dest.newLine();
                //��Դ�ļ���
                line = source.readLine();
            }
        } catch (IOException iox) {
            System.out.println("Problem reading or writing");
            return false;
        }

        return true;
    }

    //�ر��ļ�
    private boolean closeFiles() {
        boolean retVal = true;

        try {
            //�ر�Դ�ļ�
            source.close();
        } catch (IOException iox) {
            System.out.println("Problem closing source file:" + sourceName);
            retVal = false;
        }

        try {
            //�ر�Ŀ���ļ�
            dest.close();
        } catch (IOException iox) {
            System.out.println("Problem closing destination file:" + destName);
            retVal = false;
        }

        return retVal;
    }

    //�������ĸ��Ʒ�����������������һ����sourceԭ�ļ���һ����destinationĿ���ļ�
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
