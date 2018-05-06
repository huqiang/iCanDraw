/**
 * 
 */
package hu.qiang.icandraw;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author huqiang
 *
 */
public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	public String getHelp() {
//		@formatter:off
		return String.join(System.lineSeparator(),
				"Command     Description",
				"C w h           Should create a new canvas of width w and height h.",
				"L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only",
				"                horizontal or vertical lines are supported. Horizontal and vertical lines",
				"                will be drawn using the 'x' character.",
				"R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and",
				"                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn",
				"                using the 'x' character.",
				"B x y c         Should fill the entire area connected to (x,y) with \"colour\" c. The",
				"                behaviour of this is the same as that of the \"bucket fill\" tool in paint",
				"                programs.", "Q               Should quit the program.");
//		@formatter:on
	}
	
	
	public void start() {
		System.out.println(this.getHelp());
		Scanner scan = new Scanner(System.in);
		String command = "";
		while(!command.equals("Q")) {
			System.out.print("enter command: ");
			command = scan.nextLine();
			this.execute(command);
		}
		System.out.println("See you soon!");
		scan.close();
	}
	
	

	private void execute(String command) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new App().start();
	}

}
