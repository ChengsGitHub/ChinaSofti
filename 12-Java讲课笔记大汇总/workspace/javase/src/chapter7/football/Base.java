package chapter7.football;

/**
 * ������� 
 */
public abstract class Base {
	
	private String name;

	public Base(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public abstract int getScore();

}