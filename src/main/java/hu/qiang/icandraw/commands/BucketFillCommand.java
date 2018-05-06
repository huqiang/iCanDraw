/**
 * 
 */
package hu.qiang.icandraw.commands;

import hu.qiang.icandraw.DrawCommand;
import hu.qiang.icandraw.exceptions.InvalidCommandParamException;
import hu.qiang.icandraw.utils.NumberUtil;

/**
 * @author huqiang
 *
 */
public class BucketFillCommand implements DrawCommand {
	private int x;
	private int y;
	private char character;

	public BucketFillCommand(String[] params) {
		if (params.length < 3) {
			throw new InvalidCommandParamException("Bucket fill expects 3 params");
		}
		if (params[2].length() != 1) {
			throw new InvalidCommandParamException(
					"Color character should only be 1 character, given: " + params[2]);
		}

		this.x = NumberUtil.stringToPositiveInt(params[0]);
		this.y = NumberUtil.stringToPositiveInt(params[1]);
		character = params[2].charAt(0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public char getCharacter() {
		return character;
	}

	@Override
	public String getType() {
		return "B";
	}

}
