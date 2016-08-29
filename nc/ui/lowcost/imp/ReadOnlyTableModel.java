/*
 * 创建日期 2005-12-10
 *
 * @author 孙锐
 */
package nc.ui.lowcost.imp;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

/**
 * @author 孙锐
 *
 */
public class ReadOnlyTableModel extends DefaultTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2922263178609734702L;

	/**
     * 
     */
    public ReadOnlyTableModel() {
        super();
    }

    /**
     * @param rowCount
     * @param columnCount
     */
    public ReadOnlyTableModel(int rowCount, int columnCount) {
        super(rowCount, columnCount);
    }

    /**
     * @param columnNames
     * @param rowCount
     */
    public ReadOnlyTableModel(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    /**
     * @param columnNames
     * @param rowCount
     */
    public ReadOnlyTableModel(Vector columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    /**
     * @param data
     * @param columnNames
     */
    public ReadOnlyTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    /**
     * @param data
     * @param columnNames
     */
    public ReadOnlyTableModel(Vector data, Vector columnNames) {
        super(data, columnNames);
    }

    /* （非 Javadoc）
     * @see javax.swing.table.TableModel#isCellEditable(int, int)
     */
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
