package sk.train.mehrfachvererbung;

public class WhatEyes2 implements BlueEyes, GreyEyes{

	@Override
	public String getColor() {
		return BlueEyes.super.getColor();
	}	
	
}
