package com.icss.test;

public class Animal {
	private int animal_age;
	private String animal_sex;
	//���췽��
	public Animal() {
		super();
	}
	public Animal(int animal_age, String animal_sex) {
		super();
		this.animal_age = animal_age;
		this.animal_sex = animal_sex;
	}
	//���е�getset����
	public int getAnimal_age() {
		return animal_age;
	}
	public void setAnimal_age(int animal_age) {
		this.animal_age = animal_age;
	}
	public String getAnimal_sex() {
		return animal_sex;
	}
	public void setAnimal_sex(String animal_sex) {
		this.animal_sex = animal_sex;
	}
	//�Զ���ķ���
	public void eat(){
		System.out.println("��");
	}
	public void sleep(){
		System.out.println("˯");
	}

}
