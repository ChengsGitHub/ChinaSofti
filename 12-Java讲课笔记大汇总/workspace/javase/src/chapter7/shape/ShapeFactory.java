package chapter7.shape;

/**
 * 工厂模式：调用者直接可以获得某个对象的实例
 */
public class ShapeFactory {
		
	public static Shape getShape(ShapeType type) {
		
		Shape shape = null;
		
		if (type == ShapeType.CIRCLE)
			shape = new Circle();
		else if (type == ShapeType.RECTANGLE)
			shape = new Rectangle();
		else 
			shape = new Line();
		
		return shape;		
	}
}