package chap6;

// 回溯法，设计求解迷宫问题的函数并用实际例子测试
public class Exam6_7 {
	public static void main(String[] args) {
		String fileName = "src\\chap6\\Maze1.dat";
		Maze m = new Maze(fileName);
		int start = 1;

		if (m.travMaze(start)) {
			System.out.println();
			System.out.println("此迷宫的一条通路如上所示");
		} else {
			System.out.println("此迷宫无通路出来！");
		}
	}
}
