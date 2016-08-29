/*
 * 创建日期 2005-10-9
 *
 * @author 孙锐
 */
package nc.ui.lowcost.report;

import nc.ui.bd.CorpBO_Client;
import nc.ui.bd.b04.DeptdocBO_Client;
import nc.ui.lowcost.card.CardBO_Client;
import nc.ui.lowcost.type.TypeBO_Client;
import nc.ui.pub.ButtonObject;
import nc.ui.pub.ToftPanel;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIDialog;
import nc.ui.pub.beans.UITable;
import nc.ui.pub.beans.UITablePane;
import nc.ui.pub.print.PrintDirectEntry;
import nc.vo.bd.CorpVO;
import nc.vo.bd.b04.DeptdocVO;
import nc.vo.lowcost.card.CardVO;
import nc.vo.lowcost.tool.NumFormate;
import nc.vo.lowcost.type.TypeVO;
import nc.vo.pub.lang.UFDouble;
/**
 * @author 孙锐
 *
 */
public class LowCostListUI extends ToftPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -835077704532030138L;

	private UITablePane MainTP = null;
	
	private ButtonObject m_btnQuery = new ButtonObject("查询","查询",2);
	private ButtonObject m_btnPrint = new ButtonObject("打印","打印",2);
	private ButtonObject [] m_btns = new ButtonObject [] {
	        m_btnQuery,m_btnPrint
	};
	
	public CardVO [] m_cdvos = null;
	public LowCostQueryDlg m_dlg = null;
	public Object [][] m_data = null;
	public String [] m_header = null;
    /**
     * 
     */
    public LowCostListUI() {
        super();
		initialize();
    }

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        this.setLayout(new BorderLayout());
        this.setSize(586, 393);
        this.add(getMainTP(), java.awt.BorderLayout.CENTER);
		setButtons(m_btns);
		try {
		    refreshTable(new CardVO[0]);
		} catch (Exception e){
		    e.printStackTrace();
		    MessageDialog.showErrorDlg(this,"出错",e.getMessage());
		}
	}
    /* （非 Javadoc）
     * @see nc.ui.pub.ToftPanel#getTitle()
     */
    public String getTitle() {
        return "低值易耗品清单";
    }

    /* （非 Javadoc）
     * @see nc.ui.pub.ToftPanel#onButtonClicked(nc.ui.pub.ButtonObject)
     */
    public void onButtonClicked(ButtonObject bo) {
        try {
	        if(bo==m_btnQuery){
	            onQuery();
	        }
	        if(bo==m_btnPrint){
	            onPrint();
	        }
        } catch (Exception e){
            e.printStackTrace();
            MessageDialog.showErrorDlg(this,"出错",e.getMessage());
        }
        
    }

	/**
	 * This method initializes UITablePane	
	 * 	
	 * @return nc.ui.pub.beans.UITablePane	
	 */    
	private UITablePane getMainTP() {
		if (MainTP == null) {
			MainTP = new UITablePane();
		}
		return MainTP;
	}
	
	public void onQuery() throws Exception {
	    //显示查询对话框
	    LowCostQueryDlg dlg = getDlg();
	    if(dlg.showModal()==UIDialog.ID_OK){
	        String whereSql = dlg.getWhereSql();
	        CardVO [] cdvos = CardBO_Client.queryByWhereSqlAndWithUseDept(whereSql);
	        m_cdvos = cdvos;
	        try {
	            refreshTable(cdvos);
	        } catch (Exception e) {
	            e.printStackTrace();
	            MessageDialog.showErrorDlg(this,"查询数据时出错",e.getMessage());
	        }
	    }
	}
	
	public void refreshTable(CardVO [] cdvos) throws Exception {
//	    String [] Header = new String [] {
//	        "组织机构","物品编码","物品名称","物品类别","使用部门","物品状态","数量","单价","金额",
//			"购买时间","增加时间","核销时间","备注"
//	    };
//	    
//	    
//	    //按使用部门分组
//	    HashMap hmUseDept = new HashMap();
//	    Vector vUseDept = new Vector();
//	    
//	    for (int i = 0; i < cdvos.length; i++) {
//            if(hmUseDept.containsKey(cdvos[i].getPk_usedept())){
//                Vector v = (Vector)hmUseDept.get(cdvos[i].getPk_usedept());
//                v.add(cdvos[i]);
//            } else {
//                vUseDept.add(cdvos[i].getPk_usedept());
//                Vector v = new Vector();
//                v.add(cdvos[i]);
//                hmUseDept.put(cdvos[i].getPk_usedept(),v);
//            }
//        }
//	    
//	    String [] pk_usedepts = null;
//	    if(vUseDept.size()>0){
//	        pk_usedepts = new String [vUseDept.size()];
//	        vUseDept.copyInto(pk_usedepts);
//	    }
//	    
//	    Object [][] data = new Object[0][13];
//	    
//	    UFDouble totalSum = new UFDouble(0.0f); //总金额
//	    int totalNumber = 0; //总数量
//	    
//	    
//	    
//	    if(pk_usedepts!=null && pk_usedepts.length>0){
//	        CorpVO [] cvos = CorpBO_Client.queryAll(null);
//	        DeptdocVO [] dcvos = DeptdocBO_Client.queryAll(null);
//	        TypeVO [] tvos = TypeBO_Client.queryAll(null);
//	        HashMap hmType = new HashMap();
//	        if(tvos!=null){
//		        for (int i = 0; i < tvos.length; i++) {
//		            hmType.put(tvos[i].getPrimaryKey(),tvos[i].getLctypename());
//	            }
//	        }
//	        HashMap hmCorp = new HashMap();
//	        if(cvos!=null){
//	            for (int i = 0; i < cvos.length; i++) {
//                    hmCorp.put(cvos[i].getPrimaryKey(),cvos[i].getUnitname());
//                }
//	        }
//	        HashMap hmDeptDocName = new HashMap();
//	        HashMap hmDeptDocPkCorp = new HashMap();
//	        if(dcvos!=null){
//	            for (int i = 0; i < dcvos.length; i++) {
//                    hmDeptDocName.put(dcvos[i].getPrimaryKey(),dcvos[i].getDeptname());
//                    if(hmCorp.containsKey(dcvos[i].getPk_corp())){
//                        hmDeptDocPkCorp.put(dcvos[i].getPrimaryKey(),hmCorp.get(dcvos[i].getPk_corp()));
//                    }
//                }
//	        }
//	        Vector vData = new Vector();
//	        for (int i = 0; i < pk_usedepts.length; i++) {
//                Vector vDeptvos = (Vector) hmUseDept.get(pk_usedepts[i]);
//                CardVO [] DeptVos = null;
//                if(vDeptvos!=null && vDeptvos.size()>0){
//                    DeptVos = new CardVO[vDeptvos.size()];
//                    vDeptvos.copyInto(DeptVos);
//                }
//                if(DeptVos!=null && DeptVos.length>0){
//                    UFDouble deptSum = new UFDouble(0.0f);
//                    int deptNumber = 0;
//                    for (int j = 0; j < DeptVos.length; j++) {
//                        Object [] objLine = new Object[14];
//                        try {
//	                        objLine[0] = hmDeptDocPkCorp.get(DeptVos[j].getPk_usedept());
//	                        objLine[1] = DeptVos[j].getLccode();
//	                        objLine[2] = DeptVos[j].getLcname();
//	                        objLine[3] = hmType.get(DeptVos[j].getPk_lctype());
//	                        //objLine[4] = hmDeptDocName.get(DeptVos[j].getPk_managedept());
//	                        objLine[4] = hmDeptDocName.get(DeptVos[j].getPk_usedept());
//	                        objLine[5] = DeptVos[j].getAttributeValue("lcstatus");
//	                        objLine[6] = NumFormate.getPrecisionData(DeptVos[j].getNumber(),0);
//	                        objLine[7] = NumFormate.getPrecisionData(DeptVos[j].getPrice(),2);
//	                        objLine[8] = NumFormate.getPrecisionData(new UFDouble(DeptVos[j].getNumber().doubleValue()*DeptVos[j].getPrice().doubleValue()),2);
//	                        if(DeptVos[j].getBuydate()!=null)
//	                        objLine[9] = DeptVos[j].getBuydate().toString();
//	                        if(DeptVos[j].getAdddate()!=null)
//	                        objLine[10] = DeptVos[j].getAdddate().toString();
//	                        if(DeptVos[j].getCanceldate()!=null)
//	                        objLine[11] = DeptVos[j].getCanceldate().toString();
//	                        if(DeptVos[j].getRemark()!=null)
//	                        objLine[12] = DeptVos[j].getRemark().toString();
//	                        deptNumber += DeptVos[j].getNumber().intValue();
//	                        deptSum = deptSum.add(new UFDouble(DeptVos[j].getNumber().doubleValue()*DeptVos[j].getPrice().doubleValue()));
//	                        
//                        } catch (Exception e){
//                            System.out.println("----sunrui test----:数据行有错");
//                            e.printStackTrace();
//                            
//                        }
//                        vData.add(objLine);
//                    }
//                    //加入合计行
//                    Object [] objDeptCount = new Object [14];
//                    objDeptCount[0] = "本部门小计：";
//                    objDeptCount[6] = new Integer(deptNumber);
//                    objDeptCount[8] = NumFormate.getPrecisionData(deptSum,2);
//                    totalNumber += deptNumber;
//                    totalSum = totalSum.add(deptSum);
//                    vData.add(objDeptCount);
//                }
//            }
//	        
//	        //加入总合计行
//	        Object [] objTotalCount = new Object[14];
//	        objTotalCount[0] = "合计：";
//	        objTotalCount[6] = new Integer(totalNumber);
//	        objTotalCount[8] = NumFormate.getPrecisionData(totalSum,2);
//	        vData.add(objTotalCount);
//	        if(vData.size()>0){
//	            data = new Object[vData.size()][];
//	            vData.copyInto(data);
//	        }
//	    }
//	    m_data = data;
//	    m_header = Header;
//	    UITable table = new UITable(new LcListTableModel(data,Header));
//	    MainTP.setTable(table);
//        table.setAutoResizeMode(UITable.AUTO_RESIZE_OFF);
//        TableColumnModel cm = table.getColumnModel();
//        for (int i = 0; i < cm.getColumnCount(); i++){
//        	cm.getColumn(i).setPreferredWidth(80);
//        	if(i==6){
//        	    cm.getColumn(i).setPreferredWidth(50);
//        	}
//        	if(i>=6){
//            	DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
//            	cr.setHorizontalAlignment(JLabel.RIGHT);
//            	cm.getColumn(i).setCellRenderer(cr);
//        	}
//        }
		

	    String [] Header = new String [] {
	        "组织机构","物品编码","物品名称","物品类别","使用部门","物品状态","数量","单价","金额",
			"购买时间","增加时间","核销时间","备注"
	    };
	    
	    
	    //按使用部门和物品类别分组
	    HashMap hmUseDept = new HashMap();
	    Vector vUseDept = new Vector();
	    HashMap hmUseDeptToType = new HashMap(); 
	    
	    for (int i = 0; i < cdvos.length; i++) {
            if(hmUseDept.containsKey(cdvos[i].getPk_usedept()+ cdvos[i].getPk_lctype())){
                Vector v = (Vector)hmUseDept.get(cdvos[i].getPk_usedept()+ cdvos[i].getPk_lctype());
                v.add(cdvos[i]);
            } else {
                Vector v = new Vector();
                v.add(cdvos[i]);
                hmUseDept.put(cdvos[i].getPk_usedept()+cdvos[i].getPk_lctype(),v);
            }
        }
	    
	    for (int i = 0; i < cdvos.length; i++) {
            if(hmUseDeptToType.containsKey(cdvos[i].getPk_usedept())){
                Vector v = (Vector)hmUseDeptToType.get(cdvos[i].getPk_usedept());
                if(!v.contains(cdvos[i].getPk_lctype()))
                {
                  v.add(cdvos[i].getPk_lctype());
                }
             } else {
            	vUseDept.add(cdvos[i].getPk_usedept());
                Vector v = new Vector();
                v.add(cdvos[i].getPk_lctype());
                hmUseDeptToType.put(cdvos[i].getPk_usedept(),v);
            }
        }
	    
	    String [] pk_usedepts = null;
	    if(vUseDept.size()>0){
	        pk_usedepts = new String [vUseDept.size()];
	        vUseDept.copyInto(pk_usedepts);
	    }
	    
	    Object [][] data = new Object[0][13];
	    
	    UFDouble totalSum = new UFDouble(0.0f); //总金额
	    int totalNumber = 0; //总数量
	    
	    
	    
	    if(pk_usedepts!=null && pk_usedepts.length>0){
	        CorpVO [] cvos = CorpBO_Client.queryAll(null);
	        DeptdocVO [] dcvos = DeptdocBO_Client.queryAll(null);
	        TypeVO [] tvos = TypeBO_Client.queryAll(null);
	        HashMap hmType = new HashMap();
	        if(tvos!=null){
		        for (int i = 0; i < tvos.length; i++) {
		            hmType.put(tvos[i].getPrimaryKey(),tvos[i].getLctypename());
	            }
	        }
	        HashMap hmCorp = new HashMap();
	        if(cvos!=null){
	            for (int i = 0; i < cvos.length; i++) {
                    hmCorp.put(cvos[i].getPrimaryKey(),cvos[i].getUnitname());
                }
	        }
	        HashMap hmDeptDocName = new HashMap();
	        HashMap hmDeptDocPkCorp = new HashMap();
	        if(dcvos!=null){
	            for (int i = 0; i < dcvos.length; i++) {
                    hmDeptDocName.put(dcvos[i].getPrimaryKey(),dcvos[i].getDeptname());
                    if(hmCorp.containsKey(dcvos[i].getPk_corp())){
                        hmDeptDocPkCorp.put(dcvos[i].getPrimaryKey(),hmCorp.get(dcvos[i].getPk_corp()));
                    }
                }
	        }
	        Vector vData = new Vector();
	        for (int i = 0; i < pk_usedepts.length; i++) {
                Vector vTypes = (Vector) hmUseDeptToType.get(pk_usedepts[i]);
                UFDouble deptSum = new UFDouble(0.0f);
                int deptNumber = 0;
                for(int k = 0; k<vTypes.size(); k++)
	        	{
	        	//Vector currv = (Vector)vTypes.get(k);
	        	String currtype = vTypes.get(k).toString();
	        	Vector vDeptvos = (Vector) hmUseDept.get(pk_usedepts[i]+currtype);
                CardVO [] DeptVos = null;
                if(vDeptvos!=null && vDeptvos.size()>0){
                    DeptVos = new CardVO[vDeptvos.size()];
                    vDeptvos.copyInto(DeptVos);
                }
                if(DeptVos!=null && DeptVos.length>0){
                    UFDouble deptTypeSum = new UFDouble(0.0f);
                    int deptTypeNumber = 0;
                    for (int j = 0; j < DeptVos.length; j++) {
                        Object [] objLine = new Object[14];
                        try {
	                        objLine[0] = hmDeptDocPkCorp.get(DeptVos[j].getPk_usedept());
	                        objLine[1] = DeptVos[j].getLccode();
	                        objLine[2] = DeptVos[j].getLcname();
	                        objLine[3] = hmType.get(DeptVos[j].getPk_lctype());
	                        //objLine[4] = hmDeptDocName.get(DeptVos[j].getPk_managedept());
	                        objLine[4] = hmDeptDocName.get(DeptVos[j].getPk_usedept());
	                        objLine[5] = DeptVos[j].getAttributeValue("lcstatus");
	                        objLine[6] = NumFormate.getPrecisionData(DeptVos[j].getNumber(),0);
	                        objLine[7] = NumFormate.getPrecisionData(DeptVos[j].getPrice(),2);
	                        objLine[8] = NumFormate.getPrecisionData(new UFDouble(DeptVos[j].getNumber().doubleValue()*DeptVos[j].getPrice().doubleValue()),2);
	                        if(DeptVos[j].getBuydate()!=null)
	                        objLine[9] = DeptVos[j].getBuydate().toString();
	                        if(DeptVos[j].getAdddate()!=null)
	                        objLine[10] = DeptVos[j].getAdddate().toString();
	                        if(DeptVos[j].getCanceldate()!=null)
	                        objLine[11] = DeptVos[j].getCanceldate().toString();
	                        if(DeptVos[j].getRemark()!=null)
	                        objLine[12] = DeptVos[j].getRemark().toString();
	                        deptTypeNumber += DeptVos[j].getNumber().intValue();
	                        deptTypeSum = deptTypeSum.add(new UFDouble(DeptVos[j].getNumber().doubleValue()*DeptVos[j].getPrice().doubleValue()));
	                        
                        } catch (Exception e){
                            System.out.println("----sunrui test----:数据行有错");
                            e.printStackTrace();
                            
                        }
                        vData.add(objLine);
                    }
                    //加入类型合计行
                    Object [] objDeptTypeCount = new Object [14];
                    objDeptTypeCount[0] = hmType.get(currtype)+"小计：";
                    objDeptTypeCount[6] = new Integer(deptTypeNumber);
                    objDeptTypeCount[8] = NumFormate.getPrecisionData(deptTypeSum,2);
                    deptNumber += deptTypeNumber;
                    deptSum = deptSum.add(deptTypeSum);
                    vData.add(objDeptTypeCount);
                }
	        	}
                //加入部门合计行
                Object [] objDeptCount = new Object [14];
                objDeptCount[0] = "本部门小计：";
                objDeptCount[6] = new Integer(deptNumber);
                objDeptCount[8] = NumFormate.getPrecisionData(deptSum,2);
                totalNumber += deptNumber;
                totalSum = totalSum.add(deptSum);
                vData.add(objDeptCount);
            }
	        
	        //加入总合计行
	        Object [] objTotalCount = new Object[14];
	        objTotalCount[0] = "合计：";
	        objTotalCount[6] = new Integer(totalNumber);
	        objTotalCount[8] = NumFormate.getPrecisionData(totalSum,2);
	        vData.add(objTotalCount);
	        if(vData.size()>0){
	            data = new Object[vData.size()][];
	            vData.copyInto(data);
	        }
	    }
	    m_data = data;
	    m_header = Header;
	    UITable table = new UITable(new LcListTableModel(data,Header));
	    MainTP.setTable(table);
        table.setAutoResizeMode(UITable.AUTO_RESIZE_OFF);
        TableColumnModel cm = table.getColumnModel();
        for (int i = 0; i < cm.getColumnCount(); i++){
        	cm.getColumn(i).setPreferredWidth(80);
        	if(i==6){
        	    cm.getColumn(i).setPreferredWidth(50);
        	}
        	if(i>=6){
            	DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
            	cr.setHorizontalAlignment(JLabel.RIGHT);
            	cm.getColumn(i).setCellRenderer(cr);
        	}
        }
	
		
	}
	
	public void onPrint() throws Exception {
	    if(m_data==null || m_data.length==0){
	        throw new Exception ("没有可供打印的数据！\n请先执行查询后，再进行打印！");
	    }
	    String [][] colNames = new String [1][];
	    colNames [0] = m_header;
	    int[] colwidth = new int[] {100,70,70,70,70,60,40,80,80};
	    int[] alignflag = new int[] {0,0,0,0,0,1,2,2,2};
	    String title = "低值易耗品清单";
	    PrintDirectEntry print = new PrintDirectEntry();
	    print.setTitle(title);
		print.setColNames(colNames);  
		print.setData(m_data);	  
		print.setColWidth(colwidth);	
		print.setAlignFlag(alignflag);
		print.preview();
	}
	
	public LowCostQueryDlg getDlg() {
	    if(m_dlg==null){
	        m_dlg = new LowCostQueryDlg(this);
	    }
	    return m_dlg;
	}
 }
