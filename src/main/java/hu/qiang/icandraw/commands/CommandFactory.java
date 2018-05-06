/**
 *
 */
package hu.qiang.icandraw.commands;

import java.util.Arrays;

import hu.qiang.icandraw.exceptions.InvalidCommandException;

/**
 * @author huqiang
 *
 */
public class CommandFactory {
	public ICommand getCommand(String command) throws InvalidCommandException{
		String[] tokens = command.replaceAll("^ +| +$|( )+", "$1")
				.split(" ");
		String commandType = tokens[0].toUpperCase();
		String[] params = Arrays.copyOfRange(tokens, 1, tokens.length);
		switch (commandType) {
		case "C":
			return new CreateCanvasCommand(params);
		case "L":
			return new DrawLineCommand(params);
		case "R":
			return new DrawRectangleCommand(params);
		case "B":
			return new BucketFillCommand(params);
		case "Q":
			return new QuitCommand();
		default:
			throw new InvalidCommandException();
		}
	}
}
