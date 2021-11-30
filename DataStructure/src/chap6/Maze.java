package chap6;

import java.io.*;
import java.util.*;

// 迷宫互相连通的交叉路口

// 迷宫问题数值化
// 把每个路口定义成一个包括left、forward、right三个域的结构体
// 分别表示向左、向前、向右的搜索方向
// 如果某个域的值为非0，表示该方向上有通路可走到该非0值所表示的路口
// 如果某个域的值为0，则表示该方向上是思路
class InterSection {// 窗口类
	int left;// 向左方向
	int forward;// 向前方向
	int right;// 向右方向
}

// 描述一个迷宫问题的成员变量
// 包括全部路口数据的集合
// 包括迷宫的出口数据
// 为算法设计方便，迷宫问题的成员变量还应包括迷宫问题路口的个数
public class Maze {
	int mazeSize;// 路口个数
	InterSection[] intSec;// 路口集合
	int exit;// 出口

	// 构造函数
	Maze(String fileName) {
		String line;
		Integer temp;

		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			line = in.readLine();// 读文件的第一行
			mazeSize = Integer.parseInt(line.trim());// 去空格并变换类型

			intSec = new InterSection[mazeSize + 1];// 创建对象

			for (int i = 1; i <= mazeSize; i++) {// 读文件的后续行
				line = in.readLine();// 读文件的当前行
				StringTokenizer tokenizer = new StringTokenizer(line);// 把字符串分解，把当前行数值变换成StringTokenizer对象

				InterSection curr = new InterSection();// 创建对象
				// 左前右
				curr.left = Integer.parseInt(tokenizer.nextToken());// 截取tokenizer对象的第一部分并变换成int类型
				curr.forward = Integer.parseInt(tokenizer.nextToken());// 截取tokenizer对象的第二部分并变换成int类型
				curr.right = Integer.parseInt(tokenizer.nextToken());// 截取tokenizer对象的第三部分并变换成int类型
				intSec[i] = curr;// 对象赋值
			}
			exit = Integer.parseInt(in.readLine());// 读文件的最末行
			in.close();// 关闭
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean travMaze(int intSecValue) {// 搜索
		// 用回溯法搜索迷宫的所有分支，intSecValue为当前所处路口号
		// 当搜索到出口时，函数返回1，否则返回0
		if (intSecValue > 0) {
			if (intSecValue == exit) {// 搜索成功出口
				System.out.print(intSecValue + "<==");// 输出路口号
				return true;
				// 向当前路口的左分支探索
			} else if (travMaze(intSec[intSecValue].left)) {
				System.out.print(intSecValue + "<==");
				return true;
				// 向当前路口的前分支探索
			} else if (travMaze(intSec[intSecValue].forward)) {
				System.out.print(intSecValue + "<==");
				return true;
				// 向当前路口的右分支探索
			} else if (travMaze(intSec[intSecValue].right)) {
				System.out.print(intSecValue + "<==");
				return true;
			}
		}
		return false;// 搜索失败出口
	}
}
