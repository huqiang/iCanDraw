/**
 *
 */
package hu.qiang.icandraw;

import hu.qiang.icandraw.canvas.Canvas;
import hu.qiang.icandraw.canvas.ICanvas;
import hu.qiang.icandraw.commands.*;
import hu.qiang.icandraw.exceptions.InvalidCommandException;
import hu.qiang.icandraw.exceptions.InvalidCommandParamException;
import hu.qiang.icandraw.exceptions.InvalidShapeException;
import hu.qiang.icandraw.shapes.ShapeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

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
        displayHelpMessage(this.getHelp());
        this.scanner = new Scanner(System.in);
        String command = "";
        while (true) {
            displayHelpMessage("enter command: ");
            command = this.scanner.nextLine();
            this.execute(command);
        }
    }

    private void displayHelpMessage(String help) {
        System.out.println(help);
    }

    private void execute(String commandLine) {
        ICommand command = null;
        try {
            command = this.commandFactory.getCommand(commandLine);
        } catch (InvalidCommandException e) {
            displayErrorMessage("Wrong command!");
            displayHelpMessage(this.getHelp());
        } catch (InvalidCommandParamException e) {
            displayErrorMessage("Wrong parameters: " + e.getMessage());
            displayHelpMessage(this.getHelp());
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

    private void displayErrorMessage(String msg) {
        System.out.println(msg);
    }

    private void draw(DrawCommand command) {
        if (this.canvas == null) {
            displayErrorMessage("You need to create a canvas first");
            return;
        }
        try {
            this.canvas.addShape(this.shapeFactory.getShape(command));
        } catch (InvalidShapeException e) {
            displayErrorMessage(
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
        displayHelpMessage("See you soon!");
        System.exit(0);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new App().start();
    }

}
