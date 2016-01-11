package com;

public class Chessboard {
	public static String[][] init;
	static final int BOARD_SIZE=22;
	//初始化棋盘，开始新的游戏时，应该调用此方法
	public void initBoard(){
		init=new String[15][15];
		for(int i=0;i<init.length;i++){
			for(int j=0;j<init[i].length;j++){
				init[i][j]="+";
			}
		}
	}
	
	public void printBoard(){
		//在控制台输出棋盘，各方每下完一颗棋子后，由于棋盘上棋子的状态有改变
		//所以必须调用此方法重新输入棋盘
		for(String[] row:init){
			for(String string:row){
				System.out.print(string);
			}
			System.out.println();
		}
	}
	
	public void setBoard(int posX,int posY,String chessman){
		//posX与posY是新下棋子的x与y坐标，chessman是新下棋子的类型（黑子与白子）；
		//每下完一颗棋子后，通过调用此方法把棋子设置到棋盘上。
		if(chessman.equals(Chessman.WHITE.getChessman())){
			this.init[posX][posY]=chessman;			
		}
		else{
			this.init[posX][posY]=Chessman.BLACK.getChessman();
		}
		System.out.println(init[posX][posY]);/////////////////////////////////
	}
	
	public String[][] getBoard(){
		//返回棋盘，返回类型是保存棋盘的二维数组
		//initBoard();
		//String s3=init[1][2];
		//System.out.println(init[2][3]);
		return this.init;
	}
}
