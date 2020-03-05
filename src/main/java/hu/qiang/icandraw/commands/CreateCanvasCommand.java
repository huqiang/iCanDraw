/**
 * 
 */
package hu.qiang.icandraw.commands;

import hu.qiang.icandraw.exceptions.InvalidCommandParamException;
import hu.qiang.icandraw.utils.NumberUtil;

/**
 * @author huqiang
 *
 */
public class CreateCanvasCommand implements ICommand {
	private int height;
	private int width;

	public CreateCanvasCommand(String[] params) {
		if (params.length < 2)
			throw new InvalidCommandParamException("Create command expects 2 int params");
		try {
			this.width = NumberUtil.stringToPositiveInt(params[0]);
			this.height = NumberUtil.stringToPositiveInt(params[1]);
		} catch (InvalidCommandParamException e) {
			throw new InvalidCommandParamException("Number must >= 0");
		}
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	@Override
	public Command getType() {
		return Command.CREATE_CANVAS;
	}
	
	
}
