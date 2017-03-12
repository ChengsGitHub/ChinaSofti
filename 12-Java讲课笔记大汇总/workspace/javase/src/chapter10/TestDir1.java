package chapter10;

import java.io.File;

public class TestDir1 {

	public static void main(String[] args) {
		
		File dir = new File("f:\\abc\\xyz\\123");
		
		dir.mkdirs();

	}

}