package chapter7.shape;

public class TestShape {

	public static void main(String[] args) {		
		Shape shape = ShapeFactory.getShape(ShapeType.LINE);
		shape.draw();
	}

}