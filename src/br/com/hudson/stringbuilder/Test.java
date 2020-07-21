package br.com.hudson.stringbuilder;

public class Test {
	public static void main(String[] args) {
		System.out.println(new Teste());
	}
}

class Teste{
	private int param1 = 1;
	private String param2 = "aaa";
	private Double param3 = 3.5;
	
	public int getParam1() {
		return param1;
	}
	
	public String getParam2() {
		return param2;
	}
	
	@Override
	public String toString() {
		return StringBuilderWithReflection.build(this);
	}
}
