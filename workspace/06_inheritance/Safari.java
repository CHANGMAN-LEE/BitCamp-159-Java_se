package com.zoo.safari;

import com.zoo.Zoo;

class Safari extends Zoo {
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		zoo.tiger();
		//zoo.giraffe();
		//zoo.elephant();
		//zoo.lion();
		System.out.println();

		Safari safari = new Safari();
		safari.tiger();
		safari.giraffe();
		//safari.elephant();
		//zoo.lion();
	}
}
