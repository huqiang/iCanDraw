/**
 * 
 */
package hu.qiang.icandraw.commands;

/**
 * @author huqiang
 *
 */
public class QuitCommand implements ICommand {
	private static final String CMD_TYPE = "C";

	@Override
	public String getType() {
		return CMD_TYPE;
	}

}
