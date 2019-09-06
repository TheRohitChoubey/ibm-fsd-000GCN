package com.IBm._myfirstSpring_Project.beans;

public class FortuneServiceImpl implements Fortune {
	private String fortune;
	private BaseballCoach bs;
	
	public FortuneServiceImpl() {
		super();
	}

	public FortuneServiceImpl(String fortune, BaseballCoach bs) {
		super();
		this.fortune = fortune;
		this.bs = bs;
	}

	public String getFortune() {
		// TODO Auto-generated method stub
		return "Very Good";
	}

	@Override
	public String toString() {
		return "FortuneServiceImpl [fortune=" + fortune + ", bs=" + bs.toString() + "]";
	}
	
	
}
