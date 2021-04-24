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
public class DrawRectangleCommand implements DrawCommand {
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public DrawRectangleCommand(String[] params) {
        if (params.length != 4)
            throw new InvalidCommandParamException(
                    "Draw line command expects 4 params");
        try {
            this.x1 = NumberUtil.stringToPositiveInt(params[0]);
            this.y1 = NumberUtil.stringToPositiveInt(params[1]);
            this.x2 = NumberUtil.stringToPositiveInt(params[2]);
            this.y2 = NumberUtil.stringToPositiveInt(params[3]);
        } catch (InvalidCommandParamException e) {
            throw new InvalidCommandParamException("Number should be > 0");
        }
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    @Override
    public Command getType() {
        return Command.DRAW_RECTANGLE;
    }

}
