package chapter7.shape;

/**
 * ����ģʽ��������ֱ�ӿ��Ի��ĳ�������ʵ��
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