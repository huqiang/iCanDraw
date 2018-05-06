/**
 * 
 */
package hu.qiang.icandraw.shapes;

/**
 * @author huqiang
 *
 */
public interface ICanvas {
	void addShape(IShape shape);
	
	String render();
}
