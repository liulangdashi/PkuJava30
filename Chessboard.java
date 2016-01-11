package com;

public class Chessboard {
	public static String[][] init;
	static final int BOARD_SIZE=22;
	//��ʼ�����̣���ʼ�µ���Ϸʱ��Ӧ�õ��ô˷���
	public void initBoard(){
		init=new String[15][15];
		for(int i=0;i<init.length;i++){
			for(int j=0;j<init[i].length;j++){
				init[i][j]="+";
			}
		}
	}
	
	public void printBoard(){
		//�ڿ���̨������̣�����ÿ����һ�����Ӻ��������������ӵ�״̬�иı�
		//���Ա�����ô˷���������������
		for(String[] row:init){
			for(String string:row){
				System.out.print(string);
			}
			System.out.println();
		}
	}
	
	public void setBoard(int posX,int posY,String chessman){
		//posX��posY���������ӵ�x��y���꣬chessman���������ӵ����ͣ���������ӣ���
		//ÿ����һ�����Ӻ�ͨ�����ô˷������������õ������ϡ�
		if(chessman.equals(Chessman.WHITE.getChessman())){
			this.init[posX][posY]=chessman;			
		}
		else{
			this.init[posX][posY]=Chessman.BLACK.getChessman();
		}
		System.out.println(init[posX][posY]);/////////////////////////////////
	}
	
	public String[][] getBoard(){
		//�������̣����������Ǳ������̵Ķ�ά����
		//initBoard();
		//String s3=init[1][2];
		//System.out.println(init[2][3]);
		return this.init;
	}
}
