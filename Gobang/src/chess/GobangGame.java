package chess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;
	//��¼���̵�Σ��ֵ
	private int [][] keyDefend = null;
	private int [][] keyAttack = null;
	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		keyDefend = new int[22][22];
		keyAttack = new int[22][22];
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				//���÷��ص�Σ��ֵ
				setkey(posX, posY, chessman, keyDefend);
				//���ý����Ĺ�����
				chessman = Chessman.WHITE.getChessman();
				setkey(posX, posY, chessman, keyAttack);
				// ��������ѡ��λ������
				int[] computerPosArr = null;
				int[] computerPosArrDefend = computerDo(keyDefend);
				int[] computerPosArrAttack = computerDo(keyAttack);
				computerPosArr = keyDefend[computerPosArrDefend[0]][computerPosArrDefend[1]] > keyAttack[computerPosArrAttack[0]][computerPosArrAttack[1]]?
						computerPosArrDefend:computerPosArrAttack;
//				System.out.println(computerPosArr[0] + " " + computerPosArr[1]);
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
	 */
	public int[] computerDo(int key[][]) {
		
//		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		String[][] board = chessboard.getBoard();
//		while (board[posX][posY] != "ʮ") {
//			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
//		}
		int largekey = 0;
		int _posX = 0;
		int _posY = 0;
		String[][] getBoard = chessboard.getBoard();
		for(int i = 0; i <= 21; i++){
			for(int  j = 0; j<= 21; j++){
				if(getBoard[i][j].equals("ʮ")){
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
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
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
//					if(chessboard.getBoard()[i][j].equals("ʮ")){
//						keyDefend[i][j]++;
//					}
//				}
//			}
//		}
		//ˮƽ����
		x_up = posX - funCount(-1, 0, posX, posY, ico);
		x_down = posX + funCount(1, 0, posX, posY, ico);
		int count1 = x_down - x_up - 1;
		if(x_up >= 0 && x_up < 22 ){
			if(chessboard.getBoard()[x_up][posY].equals("ʮ")){
				key[x_up][posY] = key[x_up][posY]<count1 ? count1:key[x_up][posY];
			}
			if(chessboard.getBoard()[x_down][posY].equals("ʮ")){
				key[x_down][posY] = key[x_down][posY]<count1 ? count1:key[x_down][posY];
			}
		}
		//��ֱ����
		y_up = posY - funCount(0, -1, posX, posY, ico);
		y_down = posY + funCount(0, 1, posX, posY, ico);
		int count2 = y_down - y_up - 1;
		if(y_up >= 0 && y_up < 22){
			if(chessboard.getBoard()[posX][y_up].equals("ʮ")){
				key[posX][y_up] = key[posX][y_up]<count2 ? count2:key[posX][y_up];
			}
			if(chessboard.getBoard()[posX][y_down].equals("ʮ")){
				key[posX][y_down] = key[posX][y_down]<count2 ? count2:key[posX][y_down];
			}
		}
		//ʮһ��� �ĵ�뷽��
		x_up = posX - funCount(-1, 1, posX, posY, ico);
		y_up = posY + funCount(-1, 1, posX, posY, ico);
		x_down = posX + funCount(1, -1, posX, posY, ico);
		y_down = posY - funCount(1, -1, posX, posY, ico);
		int count3 = x_down - x_up - 1;
		if(x_up >= 0 && x_up < 22 && y_up >= 0 && y_up < 22){
			if(chessboard.getBoard()[x_up][y_up].equals("ʮ")){
				key[x_up][y_up] = key[x_up][y_up]<count3 ? count3:key[x_up][y_up];
			}
			if(chessboard.getBoard()[x_down][y_down].equals("ʮ")){
				key[x_down][y_down] = key[x_down][y_down]<count3 ? count3:key[x_down][y_down];
			}
		}
		//һ��� �ߵ�뷽��
		x_up = posX - funCount(-1, -1, posX, posY, ico);
		y_up = posY - funCount(-1, -1, posX, posY, ico);
		x_down = posX + funCount(1, 1, posX, posY, ico);
		y_down = posY + funCount(1, 1, posX, posY, ico);
		int count4 = x_down - x_up - 1;
		if(x_up >= 0 && x_up < 22 && y_up >= 0 && y_up < 22){
			if(chessboard.getBoard()[x_up][y_up].equals("ʮ")){
				key[x_up][y_up] = key[x_up][y_up]<count4 ? count4:key[x_up][y_up];
			}
			if(chessboard.getBoard()[x_down][y_down].equals("ʮ")){
				key[x_down][y_down] = key[x_down][y_down]<count4 ? count4:key[x_up][y_up];
			}
		}
	}
	public static void main(String[] args) throws Exception {
		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
