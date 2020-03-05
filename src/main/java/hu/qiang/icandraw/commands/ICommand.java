/**
 * 
 */
package hu.qiang.icandraw.commands;

/**
 * @author huqiang
 *
 */
public interface ICommand {
	public enum Command {
		CREATE_CANVAS, DRAW_LINE, DRAW_RECTANGLE, FILL_BUCKET, QUIT
	}

	public Command getType();
}
