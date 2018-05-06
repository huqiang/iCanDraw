/**
 *
 */
package hu.qiang.icandraw;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.qiang.icandraw.commands.CommandFactory;
import hu.qiang.icandraw.commands.CreateCanvasCommand;
import hu.qiang.icandraw.commands.ICommand;
import hu.qiang.icandraw.commands.QuitCommand;
import hu.qiang.icandraw.exceptions.InvalidCommandException;
import hu.qiang.icandraw.exceptions.InvalidCommandParamException;
import hu.qiang.icandraw.exceptions.InvalidShapeException;
import hu.qiang.icandraw.shapes.Canvas;
import hu.qiang.icandraw.shapes.ICanvas;
import hu.qiang.icandraw.shapes.ShapeFactory;

/**
 * @author huqiang
 *
 */
public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	private final CommandFactory commandFactory = new CommandFactory();
	private final ShapeFactory shapeFactory = new ShapeFactory();

	private ICanvas canvas;
	private Scanner scanner;

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
		this.scanner = new Scanner(System.in);
		String command = "";
		while (true) {
			System.out.print("enter command: ");
			command = this.scanner.nextLine();
			this.execute(command);
		}
	}

	private void execute(String commandLine) {
		ICommand command = null;
		try {
			command = this.commandFactory.getCommand(commandLine);
		} catch (InvalidCommandException e) {
			System.out.println("Wrong command!");
			System.out.println(this.getHelp());
		} catch (InvalidCommandParamException e) {
			System.out.println("Wrong parameters: " + e.getMessage());
			System.out.println(this.getHelp());
		}
		if (command instanceof CreateCanvasCommand) {
			this.createNewCanvas((CreateCanvasCommand) command);
		}

		if (command instanceof QuitCommand) {
			this.quit();
		}

		if (command instanceof DrawCommand) {
			this.draw((DrawCommand) command);
		}

		this.renderCurrent();

	}

	private void draw(DrawCommand command) {
		if (this.canvas == null) {
			System.out.println("You need to create a canvas first");
			return;
		}
		try {
			this.canvas.addShape(this.shapeFactory.getShape(command));
		} catch (InvalidShapeException e) {
			System.out.println(
					"Can not add the shape to canvas: " + e.getMessage());
		}
	}

	private void createNewCanvas(CreateCanvasCommand command) {
		this.canvas = new Canvas(command.getWidth(), command.getHeight());
	}

	private void renderCurrent() {
		if (this.canvas != null) {
			System.out.println(this.canvas.render());
		}
	}

	private void quit() {
		this.scanner.close();
		System.out.println("See you soon!");
		System.exit(0);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new App().start();
	}

}
