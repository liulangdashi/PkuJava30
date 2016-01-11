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
		//�˷�����֤����̨�������ַ����Ƿ�Ϸ�������Ϸ�������true,
		//������Ϸ����򷵻�false���˷����׳�Exception�쳣
		int[] p=new int[2];
		String[] pointStrings=inputStr.split(",");
		try{
			for(int i=0;i<pointStrings.length;i++){
				p[i]=Integer.parseInt(pointStrings[i])-1;
				System.out.println(p[i]);//hhhhhhhhhhhhhhhhhhhhhhhhhhhhh
			}
		}catch(Exception e){
			System.out.println("�����ʽ���Ϸ������������룡");
			return false;
		}
		
		
		if((p[0]>=0&&p[0]<15)&&(p[1]>=0&&p[1]<15)){
			System.out.println(p[0]+"heni"+p[1]);///////////////////
			System.out.println(chessboard.init[1][2]);////////////////
			System.out.println(chessboard.getBoard()[2][3]+"dddddddddddddddddddd");
			if(!chessboard.getBoard()[p[0]][p[1]].equals("+")){
			    System.out.println("λ�ò��Ϸ������������룡");
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
		System.out.println("x��y������ֻ����1~15�����֣����������룡");
		return false;
	}
  }
	
	public void start(){
		//Chessboard chessboard=new Chessboard();
		chessboard.initBoard();
		
		System.out.println("��ʼ�����̡���\n��Ϸ��ʼ����");
		//chessboard.printBoard();
		while(true){
			
			computerDo();
			System.out.println("��������=================");
			chessboard.printBoard();
			//System.out.println("��������=================");////////////////////////////////////////////
			if(isWon(posY,posX,Chessman.WHITE.getChessman())){
				if(isReplay(Chessman.WHITE.getChessman())){
					start();
					break;
				}
				else
					break;
			}
			else{
				//�û�����
				System.out.println("�û�����================");
				Scanner scanner;
				do{
					System.out.println("�����������ԣ�x,y���ĸ�ʽ����");
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
		//�Ƿ����¿�ʼ��Ϸ������ǣ�����true,���򷵻�false,
		//����chessman������ӻ����
		String messageString=chessman.equals(Chessman.BLACK.getChessman())?
	"��ϲ�㣬��Ӯ��":"���ź���������";
		System.out.println(messageString+"\n"+"����һ�ѣ�(y/n)");
		Scanner scanner=new Scanner(System.in);
		if(scanner.next().equals("y")){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	public int[] computerDo(){
		//�����������壬�ɼ�����Զ��������̣������ذ���
		//��������λ��x��y�����int[]��������
		
		int[] point=new int[2];
		Random random=new Random();
		do{
			for(int i=0;i<point.length;i++){
				point[i]=random.nextInt(14);
				System.out.println(point[i]);//������������������
			}
		}
		while(!chessboard.getBoard()[point[1]][point[0]].equals("+"));
		posX=point[1];
		posY=point[0];
		chessboard.setBoard(posX, posY, Chessman.WHITE.getChessman());
		return point;
	}
	
	public boolean isWon(int posX,int posY,String ico){
		//����posX��posY�����������ӵ�x��y���꣬ico�������µ��������ͣ�
		//���Ӯ�ˣ�����true,���򷵻�false��isWon��������ÿ���������á�
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
		//ˮƽ
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
		//��ֱ
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
		//��б
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
		//��б
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

