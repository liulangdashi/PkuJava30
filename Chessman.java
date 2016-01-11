package com;

public enum Chessman {
	BLACK("¡ñ"),WHITE("¡ð");
	
	private String chessman;
	
    private Chessman(String chessman){
    	this.chessman=chessman;
    }
    
    public String getChessman(){
    	return this.chessman;
    }
}
