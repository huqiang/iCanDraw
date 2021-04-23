/**
 * 
 */
package hu.qiang.icandraw.commands;

/**
 * @author huqiang
 *
 */
public interface ICommand {
	enum Command {
		CREATE_CANVAS, DRAW_LINE, DRAW_RECTANGLE, FILL_BUCKET, QUIT
	}

	Command getType();
}
