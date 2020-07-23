package com.apple;

import com.zoo.Zoo;

class Apple{
	public static void main(String[] args) {
		System.out.println("Red Apple");

		//Zoo클래스의 tiger메소드를 호출!!
		Zoo zoo = new Zoo();
		zoo.tiger();
		//zoo.giraffe();
		//zoo.elephant();
		//zoo.lion();
	}
}
