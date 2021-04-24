/**
 *
 */
package hu.qiang.icandraw.shapes;

import hu.qiang.icandraw.commands.BucketFillCommand;
import hu.qiang.icandraw.commands.DrawCommand;
import hu.qiang.icandraw.commands.DrawLineCommand;
import hu.qiang.icandraw.commands.DrawRectangleCommand;

import java.security.InvalidParameterException;

/**
 * @author huqiang
 *
 */
public class ShapeFactory {
    public IShape getShape(DrawCommand command) {

        switch (command.getType()) {
            case DRAW_LINE: {
                DrawLineCommand cmd = (DrawLineCommand) command;
                return new Line(cmd.getX1(), cmd.getY1(), cmd.getX2(), cmd.getY2());
            }
            case DRAW_RECTANGLE: {
                DrawRectangleCommand cmd = (DrawRectangleCommand) command;
                return new Rectangle(cmd.getX1(), cmd.getY1(), cmd.getX2(), cmd.getY2());
            }
            case FILL_BUCKET: {
                BucketFillCommand cmd = (BucketFillCommand) command;
                return new BucketFill(cmd.getX(), cmd.getY(), cmd.getCharacter());
            }
            default:
                throw new InvalidParameterException(command.getType() + " Is not valid command");
        }
    }
}
