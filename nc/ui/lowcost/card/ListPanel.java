/*
 * 创建日期 2005-9-16
 *
 * @author 孙锐
 */
package nc.ui.lowcost.card;

import java.awt.LayoutManager;

import nc.ui.bd.b04.DeptdocBO_Client;
import nc.ui.lowcost.type.TypeBO_Client;
import nc.ui.pub.beans.*;
import nc.ui.sm.user.UserBO_Client;

import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.table.*;

import nc.vo.bd.b04.DeptdocVO;
import nc.vo.bd.b06.PsndocVO;
import nc.vo.lowcost.card.*;
import nc.vo.lowcost.tool.NumFormate;
import nc.vo.lowcost.type.TypeVO;
import nc.vo.sm.UserVO;
/**
 * @author 孙锐
 *
 */
public class ListPanel extends UIPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6913220407945596242L;
	private UITablePane MainTablePane = null;
	private CardUI m_CardUI = null;
	private DeptdocVO [] m_ddvos = null;
	private HashMap m_hmDeptNameByPk = null;
	private HashMap m_hmPsnNameByPk = null;
	private HashMap m_hmTypeByPk = null;
	private PsndocVO[] m_pvos = null;
	private TypeVO[] m_type = null;
	public String[] header = null;
    /**
     * 
     */
    public ListPanel() {
        super();
		initialize();
    }

    /**
     * @param p0
     */
    public ListPanel(LayoutManager p0) {
        super(p0);
		initialize();
    }
    
    public ListPanel(CardUI cardUI) {
        super();
        m_CardUI = cardUI;
        initialize();
    }
    
    /**
     * @param p0
     * @param p1
     */
    public ListPanel(LayoutManager p0, boolean p1) {
        super(p0, p1);
		initialize();
    }

    /**
     * @param p0
     */
    public ListPanel(boolean p0) {
        super(p0);
		initialize();
    }

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        this.setLayout(new BorderLayout());
        this.setSize(529, 305);
        this.add(getMainTablePane(), java.awt.BorderLayout.CENTER);
		
        refreshTable(new CardVO[0]);
	}
	/**
	 * This method initializes UITablePane	
	 * 	
	 * @return nc.ui.pub.beans.UITablePane	
	 */    
	private UITablePane getMainTablePane() {
		if (MainTablePane == null) {
			MainTablePane = new UITablePane();
		}
		return MainTablePane;
	}
	
	public void refreshTable(CardVO [] cvos) {
		UserVO uvo = null;
	    try {
            String [] strHead = {
                    "物品编码","物品名称","物品类别","使用部门","使用人","单价","数量","金额",
					"物品状态","购买时间","增加时间","核销时间","备注","卡片录入人"
            };
            header = strHead;
            
            String [][] strData = new String [cvos.length][];
            for (int i = 0; i < strData.length; i++) {
                strData[i] = new String[14];
                strData[i][0] = cvos[i].getLccode();
                strData[i][1] = cvos[i].getLcname();              
                strData[i][2] = getTypeByPk(cvos[i].getPk_lctype());
                strData[i][3] = getDeptNameByPk(cvos[i].getPk_usedept());
                if(cvos[i].getDef1()!=null&&cvos[i].getDef1().length()>0)
                	strData[i][4] = getPsnNameByPk(cvos[i].getDef1());
                else
                	strData[i][4] = "";
                          
                strData[i][5] = NumFormate.getPrecisionData(cvos[i].getPrice(),2);
                strData[i][6] = String.valueOf(cvos[i].getNumber().toDouble().intValue());
                strData[i][7] = NumFormate.getPrecisionData(String.valueOf(cvos[i].getPrice().doubleValue()*cvos[i].getNumber().doubleValue()),2);
                strData[i][8] = cvos[i].getCardStatus();
                if(cvos[i].getBuydate()!=null)
                	strData[i][9] = cvos[i].getBuydate().toString();
                if(cvos[i].getAdddate()!=null)
                	strData[i][10] = cvos[i].getAdddate().toString();
                if(cvos[i].getCanceldate()!=null)
                	strData[i][11] = cvos[i].getCanceldate().toString();
                if(cvos[i].getRemark()!=null)
                	strData[i][12] = cvos[i].getRemark();
                if(cvos[i].getDef3()!=null&&cvos[i].getDef3().length()>0){
                	uvo = UserBO_Client.findUserByPrimaryKey(cvos[i].getDef3());
                	if(uvo!=null)
                		strData[i][13] = uvo.getUserName();
                	else
                		strData[i][13] = "";
                }
                else
                	strData[i][13] = "";
            }
            UITable table = new UITable(new CardTableModel(strData,strHead));
            getCardUI().setMData(strData);
            MainTablePane.setTable(table);
            
            table.setAutoResizeMode(UITable.AUTO_RESIZE_OFF);
            TableColumnModel cm = table.getColumnModel();
            for (int i = 0; i < cm.getColumnCount(); i++){
            	cm.getColumn(i).setPreferredWidth(80);
            	if(i>=3){
	            	DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
	            	cr.setHorizontalAlignment(JLabel.RIGHT);
	            	cm.getColumn(i).setCellRenderer(cr);
            	}
            }
    	    table.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    	               
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.showErrorDlg(this,"错误",e.getMessage());
        }	    
	}
	
	public void onQuery(CardVO condVO) throws Exception {
	    CardVO [] cvos = CardBO_Client.queryByCondVO(condVO);
	    m_CardUI.m_BufferedCardVOs = cvos;
	    refreshTable(cvos);
	}
	
	public void onQuery(String whereSql) throws Exception{
		CardVO[] cvos = CardBO_Client.queryByWhereSqlAndWithUseDept(whereSql);
		m_CardUI.m_BufferedCardVOs = cvos;
		refreshTable(cvos);
	}
	
	public void refresh(String key) throws Exception{
		CardVO vo = CardBO_Client.findByPrimaryKey(key);
		CardVO[] vos = new CardVO[] {vo};
		m_CardUI.m_BufferedCardVOs = vos;
		refreshTable(vos);
	}
	
	public CardUI getCardUI() {
	    return m_CardUI;
	}
	
	public UITable getTable() {
	    return getMainTablePane().getTable();
	}
	
	public DeptdocVO [] getDeptDoc() throws Exception {
	    if(m_ddvos==null){
	        m_ddvos = DeptdocBO_Client.queryAll(null);
	    }
	    return m_ddvos;
	}
	
	public TypeVO[] getType() throws Exception {
		if(m_type == null){
			m_type = TypeBO_Client.queryAll(null);
		}
		return m_type;
	}
	
	public PsndocVO[] getPsnVO() throws Exception {
		if(m_pvos==null){
			m_pvos = nc.ui.bd.b06.PsndocBO_Client.queryAll(null); 
		}
		return m_pvos;
	}
	
	public String getDeptNameByPk(String pk_deptdoc) throws Exception {
	    if(m_hmDeptNameByPk==null){
	        m_hmDeptNameByPk = new HashMap();
		    for (int i = 0; i < getDeptDoc().length; i++) {
		        m_hmDeptNameByPk.put(getDeptDoc()[i].getPk_deptdoc(),getDeptDoc()[i].getDeptname());
	        }
	    }
	    return (String)m_hmDeptNameByPk.get(pk_deptdoc);
	}
	
	public String getPsnNameByPk(String pk_psndoc) throws Exception {
		if(this.m_hmPsnNameByPk == null){
			this.m_hmPsnNameByPk = new HashMap();
			for(int i = 0; i < getPsnVO().length; i++){
				m_hmPsnNameByPk.put(getPsnVO()[i].getPrimaryKey(), getPsnVO()[i].getPsnname());
			}
		}
		return (String) m_hmPsnNameByPk.get(pk_psndoc);
	}
	
	public String getTypeByPk(String pk_type) throws Exception{
		if(m_hmTypeByPk == null){
			m_hmTypeByPk = new HashMap();
			for(int i = 0; i < getType().length; i++){
				m_hmTypeByPk.put(getType()[i].getPrimaryKey(), getType()[i].getLctypename());
			}
		}
		return (String) m_hmTypeByPk.get(pk_type);
	}
	
	public int [] getSelectedRows () {
	    int [] rows = getMainTablePane().getTable().getSelectedRows();
	    return rows;
	}
}
