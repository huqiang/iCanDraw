/**
 * 
 */
package hu.qiang.icandraw.commands;

/**
 * @author huqiang
 *
 */
public class QuitCommand implements ICommand {

	@Override
	public Command getType() {
		return Command.QUIT;
	}

}
