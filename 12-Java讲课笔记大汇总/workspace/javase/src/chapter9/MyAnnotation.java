package chapter9;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义注解类型
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

	int id();
	
	String name();
	
}