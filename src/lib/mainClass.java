package lib;

import java.io.IOException;

public class mainClass {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Parser p = new Parser();
		System.out.println(p.parse().size());
	}

}
