package sk.train.mehrfachvererbung;

public class WhatEyes extends BrownEyes implements BlueEyes{
	private String c = BlueEyes.super.getColor();
	
	public static void main(String[] args) {
		System.out.println( new WhatEyes().getColor());  //brown
		System.out.println( new WhatEyes().c);  //blue
	}
}
