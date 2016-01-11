package com;

public class TestChess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GobangGame game=new GobangGame(new Chessboard());
		game.start();
		System.out.println("游戏结束，欢迎再来~");
	}
}
