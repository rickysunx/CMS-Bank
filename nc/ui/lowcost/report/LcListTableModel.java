package nc.ui.lowcost.report;

/**
 * �˴���������˵����
 * �������ڣ�(2005-5-25 11:19:26)
 * @author������
 */
public class LcListTableModel extends javax.swing.table.DefaultTableModel {
/**
	 * 
	 */
	private static final long serialVersionUID = 6049773757475506323L;

/**
 * TableModel ������ע�⡣
 */
public LcListTableModel() {
	super();
}
/**
 * TableModel ������ע�⡣
 * @param data java.lang.Object[][]
 * @param columnNames java.lang.Object[]
 */
public LcListTableModel(java.lang.Object[][] data, java.lang.Object[] columnNames) {
	super(data, columnNames);
}
/**
 * TableModel ������ע�⡣
 * @param columnNames java.lang.Object[]
 * @param numRows int
 */
public LcListTableModel(java.lang.Object[] columnNames, int numRows) {
	super(columnNames, numRows);
}
/**
 * TableModel ������ע�⡣
 * @param numRows int
 * @param numColumns int
 */
public LcListTableModel(int numRows, int numColumns) {
	super(numRows, numColumns);
}
/**
 * TableModel ������ע�⡣
 * @param columnNames java.util.Vector
 * @param numRows int
 */
public LcListTableModel(java.util.Vector columnNames, int numRows) {
	super(columnNames, numRows);
}
/**
 * TableModel ������ע�⡣
 * @param data java.util.Vector
 * @param columnNames java.util.Vector
 */
public LcListTableModel(java.util.Vector data, java.util.Vector columnNames) {
	super(data, columnNames);
}

public boolean isCellEditable(int row, int column) {
	return m_bCellEditable;
}

	public boolean m_bCellEditable = false;

/**
 * �˴����뷽��˵����
 * �������ڣ�(2005-6-14 16:05:12)
 * @param newCellEditable boolean
 */
public void setCellEditable(boolean newCellEditable) {
	m_bCellEditable = newCellEditable;
}
}