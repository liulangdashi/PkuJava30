package com;
import java.util.Random;
import java.util.Scanner;

public class GobangGame {
	public static final int WIN_COUNT=5;
	private int posX=0,posY=0;
	private Chessboard chessboard;
	
	public GobangGame(Chessboard chessboard){
		this.chessboard=chessboard;
	}

	public boolean isValid(String inputStr){
		//此方法验证控制台的输入字符串是否合法，如果合法，返回true,
		//如果不合法，则返回false，此方法抛出Exception异常
		int[] p=new int[2];
		String[] pointStrings=inputStr.split(",");
		try{
			for(int i=0;i<pointStrings.length;i++){
				p[i]=Integer.parseInt(pointStrings[i])-1;
				System.out.println(p[i]);//hhhhhhhhhhhhhhhhhhhhhhhhhhhhh
			}
		}catch(Exception e){
			System.out.println("输入格式不合法，请重新输入！");
			return false;
		}
		
		
		if((p[0]>=0&&p[0]<15)&&(p[1]>=0&&p[1]<15)){
			System.out.println(p[0]+"heni"+p[1]);///////////////////
			System.out.println(chessboard.init[1][2]);////////////////
			System.out.println(chessboard.getBoard()[2][3]+"dddddddddddddddddddd");
			if(!chessboard.getBoard()[p[0]][p[1]].equals("+")){
			    System.out.println("位置不合法，请重新输入！");
				return false;
		}
		else{
			posX=p[1];
			posY=p[0];
			chessboard.setBoard(posX,posY,Chessman.BLACK.getChessman());
			System.out.println(chessboard.init[posX][posY]);////////////////////
			System.out.println(chessboard.init[3][5]);////////////////
			chessboard.printBoard();
			return true;
		}
	}
	else{
		System.out.println("x与y的坐标只能是1~15的数字，请重新输入！");
		return false;
	}
  }
	
	public void start(){
		//Chessboard chessboard=new Chessboard();
		chessboard.initBoard();
		
		System.out.println("初始化棋盘……\n游戏开始……");
		//chessboard.printBoard();
		while(true){
			
			computerDo();
			System.out.println("电脑下棋=================");
			chessboard.printBoard();
			//System.out.println("电脑下棋=================");////////////////////////////////////////////
			if(isWon(posY,posX,Chessman.WHITE.getChessman())){
				if(isReplay(Chessman.WHITE.getChessman())){
					start();
					break;
				}
				else
					break;
			}
			else{
				//用户下棋
				System.out.println("用户下棋================");
				Scanner scanner;
				do{
					System.out.println("请输入坐标以（x,y）的格式输入");
					scanner=new Scanner(System.in);
				}				
				while(!isValid(scanner.nextLine()));
				if(isWon(posY,posX,Chessman.BLACK.getChessman())){
					if(isReplay(Chessman.BLACK.getChessman())){
						start();
						break;
					}
					else
						break;				
				}
				
			}
		}		
	}
	
	
	public boolean isReplay(String chessman){
		//是否重新开始游戏，如果是，返回true,否则返回false,
		//参数chessman代表黑子或白子
		String messageString=chessman.equals(Chessman.BLACK.getChessman())?
	"恭喜你，你赢了":"很遗憾，你输了";
		System.out.println(messageString+"\n"+"再玩一把？(y/n)");
		Scanner scanner=new Scanner(System.in);
		if(scanner.next().equals("y")){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	public int[] computerDo(){
		//计算机随机下棋，由计算机自动设置棋盘，并返回包含
		//新下棋子位置x与y坐标的int[]数组类型
		
		int[] point=new int[2];
		Random random=new Random();
		do{
			for(int i=0;i<point.length;i++){
				point[i]=random.nextInt(14);
				System.out.println(point[i]);//啦啦啦啦啦啦啦啦啦
			}
		}
		while(!chessboard.getBoard()[point[1]][point[0]].equals("+"));
		posX=point[1];
		posY=point[0];
		chessboard.setBoard(posX, posY, Chessman.WHITE.getChessman());
		return point;
	}
	
	public boolean isWon(int posX,int posY,String ico){
		//参数posX与posY代表新下棋子的x与y坐标，ico代表新下的棋子类型，
		//如果赢了，返回true,否则返回false。isWon方法会在每次下棋后调用。
		boolean way1=way1(posX,posY,ico);
		if(way1){
			return way1;
		}
		else{
			boolean way2=way2(posX,posY,ico);
			if(way2){
				return way2;
			}
			else{
				boolean way3=way3(posX,posY,ico);
				if(way3){
					return way3;
				}
				else{
					boolean way4=way4(posX,posY,ico);
					if(way4){
						return way4;
					}
					else{
						return false;
					}
				}
			}
		}
	}
	
	
	public boolean way1(int posX,int posY,String ico){
		//水平
		boolean way1;
		int min_x1,max_x1;
		String str1="",subString=ico+ico+ico+ico+ico;
		if(posX-WIN_COUNT+1<0){
			min_x1=0;
		}
		else{
			min_x1=posX-WIN_COUNT+1;
		}
		if(posX+WIN_COUNT-1>14){
			max_x1=14;
		}
		else{
			max_x1=posX+WIN_COUNT-1;
		}
		String[][] chess=chessboard.getBoard();
		
		for(int i=min_x1;i<=max_x1;i++){
			str1+=chess[posY][i];
		}
		way1=str1.contains(subString);
		return way1;
	}
	
	public boolean way2(int posX,int posY,String ico){
		//垂直
		boolean way2;
		int min_y2,max_y2;
		String str1="",substring=ico+ico+ico+ico+ico;
		if(posY-WIN_COUNT+1<0){
			min_y2=0;
		}
		else{
			min_y2=posY-WIN_COUNT+1;
		}
		
		if(posY+WIN_COUNT-1>14){
			max_y2=14;
		}
		else{
			max_y2=posY+WIN_COUNT-1;
		}
		
		String[][] chess=chessboard.getBoard();
		
		for(int i=min_y2;i<max_y2;i++){
			str1+=chess[i][posX];
		}
		way2=str1.contains(substring);
		return way2;
	}
	
	public boolean way3(int posX,int posY,String ico){
		//左斜
		boolean way3;
		int min_x3,max_x3,min_y3,max_y3;
		String str="",substring=ico+ico+ico+ico+ico;
		int x,y,i=1,n=1;
		max_x3=posX;
		min_x3=posX;
		max_y3=posY;
		min_y3=posY;
		
		while(i<5){
			if(max_x3==14||max_y3==14){
				break;
			}
			max_x3++;
			max_y3++;
			i++;
		}
		while(n<5){
			if(min_x3==0||min_y3==0){
				break;
			}
			min_x3--;
			min_y3--;
			n++;
		}
		x=min_x3;
		y=min_y3;
		while(true){
			str+=chessboard.getBoard()[y][x];
			if(x==max_x3){
				break;
			}
			x++;
			y++;
		}
		way3=str.contains(substring);
		return way3;
	}
	
	public boolean way4(int posX,int posY,String ico){
		//右斜
		boolean way4;
		int min_x4,max_x4,min_y4,max_y4;
		String str="",substring=ico+ico+ico+ico+ico;
		int x,y,i=1,n=1;
		max_x4=posX;
		min_x4=posX;
		max_y4=posY;
		min_y4=posY;
		
		while(i<5){
			if(max_x4==14||min_y4==0){
				break;
			}
			max_x4++;
			min_y4--;
			i++;
		}
		
		while(n<5){
			if(min_x4==0||max_y4==14){
				break;
			}
			min_x4--;
			max_y4++;
			n++;
		}
		x=max_x4;
		y=min_y4;
		while(true){
			str+=chessboard.getBoard()[y][x];
			
			if(x==min_x4){
				break;
			}
			x--;
			y++;
		}
		way4=str.contains(substring);
		return way4;
	}	
}

