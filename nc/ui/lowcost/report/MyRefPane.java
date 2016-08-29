/**
 * 
 */
package nc.ui.lowcost.report;

import java.awt.Container;
import java.awt.LayoutManager;

import nc.ui.pub.beans.UIRefPane;

/**
 * @author Administrator
 *
 */
public class MyRefPane extends UIRefPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 100880544071084487L;

	/**
	 * 
	 */
	public MyRefPane() {
		super();
	}

	/**
	 * @param parent
	 */
	public MyRefPane(Container parent) {
		super(parent);
	}

	/**
	 * @param p0
	 */
	public MyRefPane(LayoutManager p0) {
		super(p0);
	}

	/**
	 * @param p0
	 * @param p1
	 */
	public MyRefPane(LayoutManager p0, boolean p1) {
		super(p0, p1);
	}

	/**
	 * @param p0
	 */
	public MyRefPane(boolean p0) {
		super(p0);
	}

	public void onButtonClicked() {
		// TODO Auto-generated method stub
		isKeyPressed = false;
		super.onButtonClicked();
	}

}
