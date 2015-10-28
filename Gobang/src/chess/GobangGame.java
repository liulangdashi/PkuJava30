package chess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;
	//记录棋盘的危险值
	private int [][] keyDefend = null;
	private int [][] keyAttack = null;
	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		keyDefend = new int[22][22];
		keyAttack = new int[22][22];
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				//设置防守的危险值
				setkey(posX, posY, chessman, keyDefend);
				//设置进攻的攻击力
				chessman = Chessman.WHITE.getChessman();
				setkey(posX, posY, chessman, keyAttack);
				// 计算机随机选择位置坐标
				int[] computerPosArr = null;
				int[] computerPosArrDefend = computerDo(keyDefend);
				int[] computerPosArrAttack = computerDo(keyAttack);
				computerPosArr = keyDefend[computerPosArrDefend[0]][computerPosArrDefend[1]] > keyAttack[computerPosArrAttack[0]][computerPosArrAttack[1]]?
						computerPosArrDefend:computerPosArrAttack;
//				System.out.println(computerPosArr[0] + " " + computerPosArr[1]);
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
	 */
	public int[] computerDo(int key[][]) {
		
//		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		String[][] board = chessboard.getBoard();
//		while (board[posX][posY] != "十") {
//			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		}
		int largekey = 0;
		int _posX = 0;
		int _posY = 0;
		String[][] getBoard = chessboard.getBoard();
		for(int i = 0; i <= 21; i++){
			for(int  j = 0; j<= 21; j++){
				if(getBoard[i][j].equals("十")){
					if(key[i][j] > largekey){
						_posX = i;
						_posY =j;
						largekey = key[i][j];
					}
				}
			}
		}
		int[] result = { _posX, _posY };
		return result;
	}

	/**
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) {
		int count1 = funCount(-1, 0, posX, posY, ico) + funCount(1, 0, posX, posY, ico) -1;
		int count2 = funCount(0, -1, posX, posY, ico) + funCount(0, 1, posX, posY, ico) -1;
		int count3 = funCount(-1, -1, posX, posY, ico) + funCount(1, 1, posX, posY, ico) -1;
		int count4 = funCount(-1, 1, posX, posY, ico) + funCount(1, -1, posX, posY, ico) -1;
		if(count1 == 5 || count2 == 5 || count3 == 5 || count4 == 5){
			return true;
		}
		else{
			return false;
		}
	}
	int funCount(int _x, int _y, int x, int y, String ico){
		int count = 1;
		while(count < 6){
			x += _x;
			y += _y;
			if(x >= 0 && x <= 21 && y >= 0 && y <= 21){
				String[][] _ico0 = chessboard.getBoard();
				if(_ico0[x][y].equals(ico)){
					count++;
				}
				else{
					break;
				}
			}
			else{
				break;
			}
		}
		return count;
	}
	public void setkey(int posX, int posY, String ico, int key[][]){
		int x_up = posX-1;
		int y_up = posY-1;
		int x_down = posX+1;
		int y_down = posY+1;
//		for(int i = x_up; i <= x_down; i++){
//			for(int  j = y_up; j<= y_down; j++){
//				if(i >= 0 && i <= 21 && j >= 0 && j <= 21){
//					if(chessboard.getBoard()[i][j].equals("十")){
//						keyDefend[i][j]++;
//					}
//				}
//			}
//		}
		//水平方向
		x_up = posX - funCount(-1, 0, posX, posY, ico);
		x_down = posX + funCount(1, 0, posX, posY, ico);
		int count1 = x_down - x_up - 1;
		if(x_up >= 0 && x_up < 22 ){
			if(chessboard.getBoard()[x_up][posY].equals("十")){
				key[x_up][posY] = key[x_up][posY]<count1 ? count1:key[x_up][posY];
			}
			if(chessboard.getBoard()[x_down][posY].equals("十")){
				key[x_down][posY] = key[x_down][posY]<count1 ? count1:key[x_down][posY];
			}
		}
		//垂直方向
		y_up = posY - funCount(0, -1, posX, posY, ico);
		y_down = posY + funCount(0, 1, posX, posY, ico);
		int count2 = y_down - y_up - 1;
		if(y_up >= 0 && y_up < 22){
			if(chessboard.getBoard()[posX][y_up].equals("十")){
				key[posX][y_up] = key[posX][y_up]<count2 ? count2:key[posX][y_up];
			}
			if(chessboard.getBoard()[posX][y_down].equals("十")){
				key[posX][y_down] = key[posX][y_down]<count2 ? count2:key[posX][y_down];
			}
		}
		//十一点半 四点半方向
		x_up = posX - funCount(-1, 1, posX, posY, ico);
		y_up = posY + funCount(-1, 1, posX, posY, ico);
		x_down = posX + funCount(1, -1, posX, posY, ico);
		y_down = posY - funCount(1, -1, posX, posY, ico);
		int count3 = x_down - x_up - 1;
		if(x_up >= 0 && x_up < 22 && y_up >= 0 && y_up < 22){
			if(chessboard.getBoard()[x_up][y_up].equals("十")){
				key[x_up][y_up] = key[x_up][y_up]<count3 ? count3:key[x_up][y_up];
			}
			if(chessboard.getBoard()[x_down][y_down].equals("十")){
				key[x_down][y_down] = key[x_down][y_down]<count3 ? count3:key[x_down][y_down];
			}
		}
		//一点半 七点半方向
		x_up = posX - funCount(-1, -1, posX, posY, ico);
		y_up = posY - funCount(-1, -1, posX, posY, ico);
		x_down = posX + funCount(1, 1, posX, posY, ico);
		y_down = posY + funCount(1, 1, posX, posY, ico);
		int count4 = x_down - x_up - 1;
		if(x_up >= 0 && x_up < 22 && y_up >= 0 && y_up < 22){
			if(chessboard.getBoard()[x_up][y_up].equals("十")){
				key[x_up][y_up] = key[x_up][y_up]<count4 ? count4:key[x_up][y_up];
			}
			if(chessboard.getBoard()[x_down][y_down].equals("十")){
				key[x_down][y_down] = key[x_down][y_down]<count4 ? count4:key[x_up][y_up];
			}
		}
	}
	public static void main(String[] args) throws Exception {
		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
