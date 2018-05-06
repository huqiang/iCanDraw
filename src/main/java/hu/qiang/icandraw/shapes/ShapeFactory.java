/**
 * 
 */
package hu.qiang.icandraw.shapes;

import hu.qiang.icandraw.DrawCommand;
import hu.qiang.icandraw.commands.BucketFillCommand;
import hu.qiang.icandraw.commands.DrawLineCommand;
import hu.qiang.icandraw.commands.DrawRectangleCommand;

/**
 * @author huqiang
 *
 */
public class ShapeFactory {
	public IShape getShape(DrawCommand command) {
		if (command instanceof DrawLineCommand) {
			DrawLineCommand cmd = (DrawLineCommand) command;
			return new Line(cmd.getX1(), cmd.getY1(), cmd.getX2(), cmd.getY2());
		} else if (command instanceof DrawRectangleCommand) {
			DrawRectangleCommand cmd = (DrawRectangleCommand) command;
			return new Rectangle(cmd.getX1(), cmd.getY1(), cmd.getX2(), cmd.getY2());
		} else if (command instanceof BucketFillCommand) {
			BucketFillCommand cmd = (BucketFillCommand) command;
			return new BucketFill(cmd.getX(), cmd.getY(), cmd.getCharacter());
		}
		return null;
	}
}
