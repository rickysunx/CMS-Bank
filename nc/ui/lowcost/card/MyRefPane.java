package nc.ui.lowcost.card;

import java.awt.Container;
import java.awt.LayoutManager;


public class MyRefPane extends nc.ui.pub.beans.UIRefPane {
    /**
     *
     */
    private static final long serialVersionUID = 6336174176278878464L;

    public MyRefPane() {
        super();
    }

    public MyRefPane(Container parent) {
        super(parent);
    }

    public MyRefPane(LayoutManager p0) {
        super(p0);
    }

    public MyRefPane(LayoutManager p0, boolean p1) {
        super(p0, p1);
    }

    public MyRefPane(boolean p0) {
        super(p0);
    }

    public void onButtonClicked() {
        isKeyPressed = false;
        super.onButtonClicked();
    }
}
