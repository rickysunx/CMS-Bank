/*
 * ��Ʒ��Ƭ�������
 * �������� 2005-9-16
 *
 * @author ����
 */
package nc.ui.lowcost.card;

import nc.ui.pub.*;
import nc.ui.pub.beans.*;
import nc.ui.pub.print.IDataSource2;
import nc.ui.pub.print.PrintDirectEntry;
import nc.ui.pub.print.PrintEntry;

import nc.ui.sm.user.UserBO_Client;

import nc.vo.lowcost.card.CardVO;
import nc.vo.lowcost.tool.NumFormate;

import nc.vo.sm.UserVO;

import java.awt.BorderLayout;

import java.util.ArrayList;
import java.util.Vector;


/**
 * @author ����
 */
public class CardUI extends ToftPanel {
    /**
     *
     */
    private static final long serialVersionUID = -6362644455519604668L;
    private UIPanel MainPanel = null;

    //�б����İ�ť
    private ButtonObject m_boQuery = new ButtonObject("��ѯ", "��ѯ", 2);
    private ButtonObject m_boCopy = new ButtonObject("����", "����", 2);
    private ButtonObject m_boCheck = new ButtonObject("���", "���", 2);
    private ButtonObject m_boUnCheck = new ButtonObject("ȡ�����", "ȡ�����", 2);
    private ButtonObject m_boShowCard = new ButtonObject("��Ƭ����", "��Ƭ����", 2);
    private ButtonObject m_boMulPrint = new ButtonObject("��Ƭ��ӡ", "��Ƭ��ӡ", 2);
    private ButtonObject m_boListPrint = new ButtonObject("�б��ӡ", "�б��ӡ", 2);
    private ButtonObject[] m_ListBos = new ButtonObject[] {
            m_boQuery, m_boShowCard ,m_boCheck,m_boUnCheck, m_boMulPrint,
            m_boListPrint
        };

    //��Ƭ����İ�ť
    private ButtonObject m_boAdd = new ButtonObject("����", "����", 2);
    private ButtonObject m_boEdit = new ButtonObject("�޸�", "�޸�", 2);
    private ButtonObject m_boDel = new ButtonObject("ɾ��", "ɾ��", 2);
    private ButtonObject m_boSave = new ButtonObject("����", "����", 2);
    private ButtonObject m_boCancel = new ButtonObject("ȡ��", "ȡ��", 2);
    private ButtonObject m_boFirst = new ButtonObject("��ҳ", "��ҳ", 2);
    private ButtonObject m_boPrev = new ButtonObject("��ҳ", "��ҳ", 2);
    private ButtonObject m_boNext = new ButtonObject("��ҳ", "��ҳ", 2);
    private ButtonObject m_boLast = new ButtonObject("ĩҳ", "ĩҳ", 2);
    private ButtonObject m_boBack = new ButtonObject("����", "����", 2);
    private ButtonObject m_boPrint = new ButtonObject("��ӡ", "��ӡ", 2);
    private ButtonObject[] m_CardBos = new ButtonObject[] {
            m_boAdd, m_boEdit, m_boDel, m_boSave, m_boCancel,
            m_boCopy ,m_boCheck,m_boUnCheck, m_boFirst, m_boPrev, m_boNext,
            m_boLast, m_boPrint, m_boBack
        };
    private ListPanel m_ListPanel = null;
    private CardPanel m_CardPanel = null;
    public final int LISTPANEL = 0;
    public final int CARDPANEL = 1;
    public int m_CurrentPanel = -1;
    public CardVO[] m_BufferedCardVOs = null;
    public int m_CurrentIndex = -1;
    public int m_CurrentCardState = 0;
    public final int BROWSESTATE = 0;
    public final int ADDSTATE = 1;
    public final int EDITSTATE = 2;
    public CardVO m_CondVO = null;
    public CardQueryDlg m_cardQueryDlg = null;
    private Object[][] m_data = null;

    /**
     *
     */
    public CardUI() {
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
        this.setSize(536, 336);
        this.add(getMainPanel(), java.awt.BorderLayout.CENTER);

        ShowPanel(LISTPANEL);
    }

    /* ���� Javadoc��
     * @see nc.ui.pub.ToftPanel#getTitle()
     */
    public String getTitle() {
        return "��ֵ�׺�Ʒ��Ƭ����";
    }

    /* ���� Javadoc��
     * @see nc.ui.pub.ToftPanel#onButtonClicked(nc.ui.pub.ButtonObject)
     */
    public void onButtonClicked(ButtonObject bo) {
        try {
            if (bo == m_boQuery) {
                onQuery();
            }

            if (bo == m_boShowCard) {
                onShowCard();
            }

            if (bo == m_boBack) {
                onBack();
            }

            if (bo == m_boAdd) {
                onAdd();
            }

            if (bo == m_boCancel) {
                onMyCancel();
            }

            if (bo == m_boSave) {
                onSave();
            }

            if (bo == m_boDel) {
                onDel();
            }

            if (bo == m_boEdit) {
                onEdit();
            }

            if (bo == m_boFirst) {
                onFirst();
            }

            if (bo == m_boPrev) {
                onPrev();
            }

            if (bo == m_boNext) {
                onNext();
            }

            if (bo == m_boLast) {
                onLast();
            }

            if (bo == m_boCopy) {
                onCopy();
            }

            if (bo == m_boCheck) {
                onCheck();
            }

            if (bo == m_boUnCheck) {
                onUnCheck();
            }

            if (bo == m_boPrint) {
                onPrint();
            }

            if (bo == m_boMulPrint) {
                onMulPrint();
            }

            if (bo == m_boListPrint) {
                onListPrint();
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.showErrorDlg(this, "����", e.getMessage());
        }
    }

    public void onListPrint() throws Exception {
        CardVO[] vos = getSelectedVOs();

        if ((m_data == null) || (m_data.length == 0)) {
            throw new Exception("û�пɹ���ӡ�����ݣ�\n����ִ�в�ѯ���ٽ��д�ӡ��");
        }

        if ((vos != null) && (vos.length > 0)) {
            String[][] strData = new String[vos.length][];

            for (int i = 0; i < strData.length; i++) {
                strData[i] = new String[14];
                strData[i][0] = vos[i].getLccode();
                strData[i][1] = vos[i].getLcname();
                strData[i][2] = getListPanel().getTypeByPk(vos[i].getPk_lctype());
                strData[i][3] = getListPanel()
                                    .getDeptNameByPk(vos[i].getPk_usedept());

                if ((vos[i].getDef1() != null) &&
                        (vos[i].getDef1().length() > 0)) {
                    strData[i][4] = getListPanel()
                                        .getPsnNameByPk(vos[i].getDef1());
                } else {
                    strData[i][4] = "";
                }

                strData[i][5] = NumFormate.getPrecisionData(vos[i].getPrice(), 2);
                strData[i][6] = String.valueOf(vos[i].getNumber().toDouble()
                                                     .intValue());
                strData[i][7] = NumFormate.getPrecisionData(String.valueOf(
                            vos[i].getPrice().doubleValue() * vos[i].getNumber()
                                                                    .doubleValue()),
                        2);
                strData[i][8] = vos[i].getCardStatus();

                if (vos[i].getBuydate() != null) {
                    strData[i][9] = vos[i].getBuydate().toString();
                }

                if (vos[i].getAdddate() != null) {
                    strData[i][10] = vos[i].getAdddate().toString();
                }

                if (vos[i].getCanceldate() != null) {
                    strData[i][11] = vos[i].getCanceldate().toString();
                }

                if (vos[i].getRemark() != null) {
                    strData[i][12] = vos[i].getRemark();
                }

                if ((vos[i].getDef3() != null) &&
                        (vos[i].getDef3().length() > 0)) {
                    UserVO uvo = UserBO_Client.findUserByPrimaryKey(vos[i].getDef3());

                    if (uvo != null) {
                        strData[i][13] = uvo.getUserName();
                    } else {
                        strData[i][13] = "";
                    }
                } else {
                    strData[i][13] = "";
                }
            }

            setMData(strData);
        }

        String[][] colNames = new String[1][];
        colNames[0] = getListPanel().header;

        int[] colwidth = new int[] {
                100, 100, 100, 70, 70, 70, 70, 70, 70, 70, 70, 70, 120, 70
            };
        int[] alignflag = new int[] { 0, 0, 0, 0, 1, 2, 2, 2, 1, 1, 1, 1, 0, 0 };
        String title = "��ֵ�׺�Ʒ��Ƭ�б�";
        PrintDirectEntry print = new PrintDirectEntry();
        print.setTitle(title);
        print.setColNames(colNames);
        print.setData(m_data);
        print.setColWidth(colwidth);
        print.setAlignFlag(alignflag);
        print.preview();
    }

    public void onMulPrint() {
        //    	CardVO[] vo = null;
        //    	try{
        //    		vo = getSelectedVOs();
        //    	}catch(Exception e){
        //    		e.printStackTrace();
        //    	}
        //    	if(vo!=null&&vo.length>0){
        //    		ArrayList list = new ArrayList();
        //    		for(int i = 0; i < vo.length; i++){
        //    			nc.ui.pub.print.IDataSource2 data = new MulPrintData(vo[i]);
        //    			list.add(data);
        //    		}
        //    		//String node = "209002";
        //    		String ID = "0001AA1000000000GWEM";
        //    		try{
        //    			
        //    			nc.ui.pub.print.PrintEntry entry = new nc.ui.pub.print.PrintEntry(this);
        //    			entry.setTemplateID(ID);
        //    			entry.beginVoucherBatchPrint();
        //    			for (int i = 0; i < list.size(); i++) {
        //    				entry.setDataSource((MulPrintData)list.get(i));
        //    			}
        //    			entry.endVoucherBatchPrint();    			
        //    		}catch(Exception e){
        //    			e.printStackTrace();
        //    			showErrorMessage("������ӡ�쳣,������!");
        //    			System.err.println("������ӡ����!");
        //    		}
        //    	}else{
        //    		showErrorMessage("��ѡ��Ҫ��ӡ�����ݣ�");
        //    		return;
        //    	}
        String ID = "0001AA1000000001540V";
        CardVO[] vos = null;
        ArrayList list = new ArrayList();

        try {
            vos = getSelectedVOs();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if ((vos != null) && (vos.length > 0)) {
            int num = vos.length;

            if ((num > 1) && ((num % 2) != 0)) {
                CardVO[] temp = new CardVO[vos.length + 1];

                for (int i = 0; i < vos.length; i++) {
                    temp[i] = vos[i];
                }

                temp[vos.length] = buildNullCard();

                for (int i = 0; i < temp.length; i += 2) {
                    CardVO[] tmp = new CardVO[2];
                    tmp[0] = temp[i];
                    tmp[1] = temp[i + 1];

                    IDataSource2 data = new MulPrintData2(tmp);
                    list.add(data);
                }

                try {
                    nc.ui.pub.print.PrintEntry entry = new nc.ui.pub.print.PrintEntry(this);
                    entry.setTemplateID(ID);
                    entry.beginVoucherBatchPrint();

                    for (int i = 0; i < list.size(); i++) {
                        entry.setDataSource((MulPrintData2) list.get(i));
                    }

                    entry.endVoucherBatchPrint();
                } catch (Exception e) {
                    e.printStackTrace();
                    showErrorMessage("������ӡ�쳣,������!");
                    System.err.println("������ӡ����!");
                }
            } else {
                if (num == 1) {
                    try {
                        PrintEntry entry = new PrintEntry(this);
                        entry.setTemplateID(ID);
                        entry.beginVoucherBatchPrint();

                        CardVO[] temp = new CardVO[2];
                        temp[0] = vos[0];
                        temp[1] = buildNullCard();
                        entry.setDataSource(new MulPrintData2(temp));
                        entry.endVoucherBatchPrint();
                    } catch (Exception e) {
                        e.printStackTrace();
                        showErrorMessage("��ѡ��Ҫ��ӡ�Ŀ�Ƭ���ݣ�");
                    }
                } else {
                    for (int i = 0; i < vos.length; i += 2) {
                        CardVO[] tmp = new CardVO[2];
                        tmp[0] = vos[i];
                        tmp[1] = vos[i + 1];

                        IDataSource2 data = new MulPrintData2(tmp);
                        list.add(data);
                    }

                    try {
                        nc.ui.pub.print.PrintEntry entry = new nc.ui.pub.print.PrintEntry(this);
                        entry.setTemplateID(ID);
                        entry.beginVoucherBatchPrint();

                        for (int i = 0; i < list.size(); i++) {
                            entry.setDataSource((MulPrintData2) list.get(i));
                        }

                        entry.endVoucherBatchPrint();
                    } catch (Exception e) {
                        e.printStackTrace();
                        showErrorMessage("������ӡ�쳣,������!");
                        System.err.println("������ӡ����!");
                    }
                }
            }
        } else {
            showErrorMessage("��ѡ��Ҫ��ӡ�Ŀ�Ƭ���ݣ�");

            return;
        }
    }

    private CardVO buildNullCard() {
        CardVO vo = new CardVO();
        //   	vo.setLccode("\t ");
        //    	vo.setUser("\t ");
        //    	vo.setAdddate(new UFDate(" /t"));
        //    	vo.setBuydate(new UFDate("/t "));
        //    	vo.setCanceldate(new UFDate("/t "));
        //    	vo.setLcname("\t  ");
        //    	vo.setPk_lctype("\t ");
        //    	vo.setPk_usedept(" \t  ");
        //    	vo.setM_status(" \t ");
        //    	vo.setDef1(" \t");
        //    	vo.setDef3(" \t ");
        //    	vo.setRemark(" \t ");
        //    	vo.setTallydate(new UFDate("\t "));
        vo.setPrice(null);
        vo.setNumber(null);

        return vo;
    }

    public void onPrint() {
        String user = getCardPanel().getRefUser().getRefName();
        String usedep = getCardPanel().getRefUseDept().getRefName();
        String status = getCardPanel().getTxtStatus().getText();
        String type = getCardPanel().getRefType().getRefName();

        //String input = getCardPanel().getInputPsnRefPane().getRefName();
        String input = getCardPanel().getInputPsnText().getText().trim();
        CardVO[] vos = null;

        try {
            vos = getSelectedVOs();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (vos != null) {
            for (int i = 0; i < vos.length; i++) {
                vos[i].setUser(user);
                vos[i].dep = usedep;
                vos[i].setM_status(status);
                vos[i].setType(type);
                vos[i].psn = input;
            }

            nc.ui.pub.print.IDataSource dataSource = null;
            CardVO[] vo = new CardVO[1];
            vo[0] = vos[0];
            dataSource = new SinglePrintData(vo);

            nc.ui.pub.print.PrintEntry print = new nc.ui.pub.print.PrintEntry(null,
                    dataSource);
            //		print.setTemplateID(getClientEnvironment().getCorporation().getPrimaryKey(),
            //				 "209002",
            //				 getClientEnvironment().getUser().getUserName(),
            //				 null);
            print.setTemplateID("0001AA1000000000GWEM");
            print.preview();
        } else {
            showErrorMessage("û��ѡ��Ҫ��ӡ�����ݣ�");
        }
    }

    public void onCheck() throws Exception {
        CardVO[] vos = getSelectedVOs();

        for (int i = 0; i < vos.length; i++) {
            if (((vos[i].getTallyflag() != null) &&
                    vos[i].getTallyflag().booleanValue()) ||
                    ((vos[i].getCancelflag() != null) &&
                    vos[i].getCancelflag().booleanValue()) ||
                    (vos[i].getDef2() != null)) {
                throw new Exception("����ѡ��ļ�¼�У����Ѿ����ˡ���������˵ļ�¼����������ˣ�");
            }
        }

        CardBO_Client.check(vos,
            ClientEnvironment.getInstance().getUser().getPrimaryKey());

        if (m_CondVO != null) {
            getListPanel().onQuery(m_CondVO);
        }

        setCardBrowseState();
        ShowPanel(LISTPANEL);
        MessageDialog.showHintDlg(this, "�ɹ�", "��˳ɹ�");
    }

    public void onUnCheck() throws Exception {
        CardVO[] vos = getSelectedVOs();

        for (int i = 0; i < vos.length; i++) {
            if (((vos[i].getTallyflag() != null) &&
                    vos[i].getTallyflag().booleanValue()) ||
                    ((vos[i].getCancelflag() != null) &&
                    vos[i].getCancelflag().booleanValue()) ||
                    (vos[i].getDef2() == null)) {
                throw new Exception("����ѡ��ļ�¼�����Ѿ����ˡ���������˵ļ�¼����������ˣ�");
            }
        }

        if (m_CondVO != null) {
            getListPanel().onQuery(m_CondVO);
        }

        setCardBrowseState();
        ShowPanel(LISTPANEL);
        CardBO_Client.check(vos, null);
        MessageDialog.showHintDlg(this, "�ɹ�", "ȡ����˳ɹ�");
    }

    public CardVO[] getSelectedVOs() throws Exception {
        Vector v = new Vector();
        CardVO[] vos = null;
        int[] rows = getListPanel().getSelectedRows();

        if ((rows == null) || (rows.length == 0)) {
            throw new Exception("��ѡ���¼��");
        }

        for (int i = 0; i < rows.length; i++) {
            v.add(m_BufferedCardVOs[rows[i]]);
        }

        vos = new CardVO[v.size()];
        v.copyInto(vos);

        return vos;
    }

    /**
     * This method initializes UIPanel
     *
     * @return nc.ui.pub.beans.UIPanel
     */
    public UIPanel getMainPanel() {
        if (MainPanel == null) {
            MainPanel = new UIPanel();
        }

        return MainPanel;
    }

    public void onCopy() throws Exception {
        int row = m_CurrentIndex;

        if (row == -1) {
            throw new Exception("��ѡ����Ҫ���Ƶļ�¼��");
        }

        if ((m_BufferedCardVOs != null) && (row >= 0) &&
                (row < m_BufferedCardVOs.length)) {
            CardCopyDlg dlg = new CardCopyDlg(this);

            if (dlg.showModal() == UIDialog.ID_OK) {
                int n = dlg.getCopyCount();
                CardBO_Client.copy(m_BufferedCardVOs[row], n);

                if (m_CondVO != null) {
                    getListPanel().onQuery(m_CondVO);
                }

                setCardBrowseState();
                ShowPanel(LISTPANEL);
            }
        } else {
            throw new Exception("��ѡ����Ҫ���ƵĿ�Ƭ");
        }
    }

    public void onQuery() throws Exception {
        CardQueryDlg dlg = getCardQueryDlg();

        if (dlg.showModal() == MessageDialog.ID_OK) {
            if (dlg.flag == 1) {
                getListPanel().onQuery(dlg.getWhereSql());
            } else {
                m_CondVO = dlg.getCondVO();
                getListPanel().onQuery(m_CondVO);
            }
        }
    }

    public void onShowCard() throws Exception {
        ShowPanel(CARDPANEL);

        CardVO vo = null;
        m_CurrentIndex = getListPanel().getTable().getSelectedRow();

        if ((m_CurrentIndex != -1) && (m_BufferedCardVOs != null) &&
                (m_CurrentIndex < m_BufferedCardVOs.length)) {
            vo = m_BufferedCardVOs[m_CurrentIndex];
        }

        getCardPanel().setCurrentVO(vo);
        getCardPanel().setBrowseStateVO(vo);
    }

    public void onBack() throws Exception {
        ShowPanel(LISTPANEL);
    }

    public CardPanel getCardPanel() {
        if (m_CardPanel == null) {
            m_CardPanel = new CardPanel(this);

            try {
                setCardBrowseState();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return m_CardPanel;
    }

    public ListPanel getListPanel() {
        if (m_ListPanel == null) {
            m_ListPanel = new ListPanel(this);
        }

        return m_ListPanel;
    }

    public void ShowPanel(int nPanelID) {
        try {
            if (m_CurrentPanel != nPanelID) {
                if (nPanelID == LISTPANEL) {
                    remove(getMainPanel());
                    MainPanel = getListPanel();
                    add(getMainPanel(), java.awt.BorderLayout.CENTER);
                    setButtons(m_ListBos);
                }

                if (nPanelID == CARDPANEL) {
                    remove(getMainPanel());
                    MainPanel = getCardPanel();
                    add(getMainPanel(), java.awt.BorderLayout.CENTER);
                    setButtons(m_CardBos);
                }

                validate();
                repaint();
                m_CurrentPanel = nPanelID;
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.showErrorDlg(this, "����", "�л�����ʱ��������" +
                e.getMessage());
        }
    }

    public void setCardAddState() throws Exception {
        m_boAdd.setEnabled(false);
        m_boEdit.setEnabled(false);
        m_boDel.setEnabled(false);
        m_boSave.setEnabled(true);
        m_boCancel.setEnabled(true);
        m_boFirst.setEnabled(false);
        m_boPrev.setEnabled(false);
        m_boNext.setEnabled(false);
        m_boLast.setEnabled(false);
        m_boBack.setEnabled(false);
        m_boPrint.setEnabled(false);
        m_boCopy.setEnabled(false);
        m_boCheck.setEnabled(false);
        m_boUnCheck.setEnabled(false);
        updateButtons();

        m_CurrentCardState = ADDSTATE;
        getCardPanel().setAddState();
    }

    public void setCardEditState() throws Exception {
        m_boAdd.setEnabled(false);
        m_boEdit.setEnabled(false);
        m_boDel.setEnabled(false);
        m_boSave.setEnabled(true);
        m_boCancel.setEnabled(true);
        m_boFirst.setEnabled(false);
        m_boPrev.setEnabled(false);
        m_boNext.setEnabled(false);
        m_boLast.setEnabled(false);
        m_boBack.setEnabled(false);
        m_boPrint.setEnabled(false);
        m_boCopy.setEnabled(false);
        m_boCheck.setEnabled(false);
        m_boUnCheck.setEnabled(false);
        updateButtons();

        m_CurrentCardState = EDITSTATE;
        getCardPanel().setEditState();
    }

    public void setCardBrowseState() throws Exception {
        m_boAdd.setEnabled(true);
        m_boEdit.setEnabled(true);
        m_boDel.setEnabled(true);
        m_boSave.setEnabled(false);
        m_boCancel.setEnabled(false);
        m_boFirst.setEnabled(true);
        m_boPrev.setEnabled(true);
        m_boNext.setEnabled(true);
        m_boLast.setEnabled(true);
        m_boBack.setEnabled(true);
        m_boPrint.setEnabled(true);
        m_boCopy.setEnabled(true);
        m_boCheck.setEnabled(true);
        m_boUnCheck.setEnabled(true);
        updateButtons();

        m_CurrentCardState = BROWSESTATE;

        getCardPanel().setBrowseState();
    }

    public void onAdd() throws Exception {
        setCardAddState();
    }

    public void onMyCancel() throws Exception {
        setCardBrowseState();
        getCardPanel().onMyCanel();
    }

    public void onSave() throws Exception {
        String key = null;

        if (m_CurrentCardState == ADDSTATE) {
            key = getCardPanel().SaveAdd();
        }

        if (m_CurrentCardState == EDITSTATE) {
            getCardPanel().SaveEdit();
        }

        if (m_CondVO != null) {
            getListPanel().onQuery(m_CondVO);
        } else {
            if ((m_CurrentCardState == ADDSTATE) && (key != null)) {
                getListPanel().refresh(key);
            }
        }

        setCardBrowseState();
        ShowPanel(LISTPANEL);
    }

    public ClientEnvironment getEvn() {
        return getClientEnvironment();
    }

    public void onDel() throws Exception {
        int row = m_CurrentIndex;

        if (row == -1) {
            throw new Exception("��ѡ����Ҫɾ������Ʒ");
        }

        if ((m_BufferedCardVOs != null) && (row >= 0) &&
                (row < m_BufferedCardVOs.length)) {
            //��Ʒɾ��У�� �Ƿ��Ѽ���֮��
            if ((m_BufferedCardVOs[row].getTallyflag() != null) &&
                    (m_BufferedCardVOs[row].getTallyflag().booleanValue() == true)) {
                throw new Exception("��Ʒ�Ѿ����ˣ�������ɾ����");
            }

            //ɾ��ȷ��
            if (MessageDialog.showYesNoDlg(this, "ѯ��", "�Ƿ����Ҫɾ����ѡ��Ʒ") == MessageDialog.ID_YES) {
                CardBO_Client.delete(m_BufferedCardVOs[row]);

                if (m_CondVO != null) {
                    getListPanel().onQuery(m_CondVO);
                }

                setCardBrowseState();
                ShowPanel(LISTPANEL);
            }
        } else {
            throw new Exception("��δѡ����Ҫɾ������Ʒ");
        }
    }

    public void onEdit() throws Exception {
        int row = m_CurrentIndex;

        if (row == -1) {
            throw new Exception("��ѡ����Ҫ�޸ĵ���Ʒ");
        }

        if ((m_BufferedCardVOs != null) && (row >= 0) &&
                (row < m_BufferedCardVOs.length)) {
            if ((m_BufferedCardVOs[row].getTallyflag() != null) &&
                    (m_BufferedCardVOs[row].getTallyflag().booleanValue() == true)) {
                setTallyState();

                return;

                //throw new Exception("�Ѿ����˵���Ʒ�������޸ģ�");
            }
        } else {
            throw new Exception("��δѡ����Ҫ�޸ĵ���Ʒ");
        }

        setCardEditState();
    }

    public CardQueryDlg getCardQueryDlg() {
        if (m_cardQueryDlg == null) {
            m_cardQueryDlg = new CardQueryDlg(this);
        }

        return m_cardQueryDlg;
    }

    public void onFirst() throws Exception {
        if ((m_BufferedCardVOs == null) || (m_BufferedCardVOs.length == 0)) {
            throw new Exception("��δ���в�ѯ���ѯ�Ľ��Ϊ��");
        }

        m_CurrentIndex = 0;
        getCardPanel().setBrowseStateVO(m_BufferedCardVOs[m_CurrentIndex]);
        getCardPanel().setCurrentVO(m_BufferedCardVOs[m_CurrentIndex]);
        getListPanel().getTable().getSelectionModel()
            .setSelectionInterval(m_CurrentIndex, m_CurrentIndex);
    }

    public void onPrev() throws Exception {
        if ((m_BufferedCardVOs == null) || (m_BufferedCardVOs.length == 0)) {
            throw new Exception("��δ���в�ѯ���ѯ�Ľ��Ϊ��");
        }

        if (m_CurrentIndex == -1) {
            m_CurrentIndex = 0;
        }

        if (m_CurrentIndex == 0) {
            throw new Exception("�Ѿ�����ҳ�����������Ϸ�ҳ");
        }

        m_CurrentIndex--;
        getCardPanel().setBrowseStateVO(m_BufferedCardVOs[m_CurrentIndex]);
        getCardPanel().setCurrentVO(m_BufferedCardVOs[m_CurrentIndex]);
        getListPanel().getTable().getSelectionModel()
            .setSelectionInterval(m_CurrentIndex, m_CurrentIndex);
    }

    public void onNext() throws Exception {
        if ((m_BufferedCardVOs == null) || (m_BufferedCardVOs.length == 0)) {
            throw new Exception("��δ���в�ѯ���ѯ�Ľ��Ϊ��");
        }

        if (m_CurrentIndex == (m_BufferedCardVOs.length - 1)) {
            throw new Exception("�Ѿ���ĩҳ�����������·�ҳ");
        }

        m_CurrentIndex++;
        getCardPanel().setBrowseStateVO(m_BufferedCardVOs[m_CurrentIndex]);
        getCardPanel().setCurrentVO(m_BufferedCardVOs[m_CurrentIndex]);
        getListPanel().getTable().getSelectionModel()
            .setSelectionInterval(m_CurrentIndex, m_CurrentIndex);
    }

    public void onLast() throws Exception {
        if ((m_BufferedCardVOs == null) || (m_BufferedCardVOs.length == 0)) {
            throw new Exception("��δ���в�ѯ���ѯ�Ľ��Ϊ��");
        }

        m_CurrentIndex = m_BufferedCardVOs.length - 1;
        getCardPanel().setBrowseStateVO(m_BufferedCardVOs[m_CurrentIndex]);
        getCardPanel().setCurrentVO(m_BufferedCardVOs[m_CurrentIndex]);
        getListPanel().getTable().getSelectionModel()
            .setSelectionInterval(m_CurrentIndex, m_CurrentIndex);
    }

    public void setTallyState() throws Exception {
        m_boAdd.setEnabled(false);
        m_boEdit.setEnabled(false);
        m_boDel.setEnabled(false);
        m_boSave.setEnabled(true);
        m_boCancel.setEnabled(true);
        m_boFirst.setEnabled(false);
        m_boPrev.setEnabled(false);
        m_boNext.setEnabled(false);
        m_boLast.setEnabled(false);
        m_boBack.setEnabled(false);
        m_boPrint.setEnabled(false);
        m_boCopy.setEnabled(false);
        updateButtons();

        m_CurrentCardState = EDITSTATE;
        getCardPanel().setTallyState();
    }

    public Object[][] getMData() {
        return m_data;
    }

    public void setMData(Object[][] data) {
        this.m_data = data;
    }
}
