package chapter9;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * �Զ���ע������
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

	int id();
	
	String name();
	
}