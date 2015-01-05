package com.design;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.controller.Command;

public class DesignListCMD implements Command{
	Logger logger = Logger.getLogger(DesignListCMD.class);
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("DesignListCMD ȣ�⼺��");
		
		/*DesignDAO dao = new DesignDAO();
		DesignDTO dto = new DesignDTO();
		
		ArrayList<DesignDTO> listDesign = dao.listDesign();
		req.setAttribute("listDesign",listDesign);	*/
	
	//����¡ó�� �غ���
	String page="";
	int curPage =1; //���� ������
	if(req.getParameter("curPage")!=null){
			curPage = Integer.parseInt(req.getParameter("curPage"));
	}
	DesignDAO dao = new DesignDAO();
	DesignPageTO list = dao.page(curPage);
	
	int perPage = list.getPerPage(); 
	int totalCount = list.getTotalCount();
	int totalPage = totalCount/perPage;  //������ ������ ��ȣ����
	if(totalCount % perPage != 0) totalPage++;
	for(int i=1; i<=totalPage; i++){
		if(curPage ==i){
			page +="<font size='5' color='red'>"+i+"</span>";
		}else{
			String mode = req.getParameter("mode");
			if("manager".equals(mode)){
			page +="<a href='manager_qna_list.do?mode=manager&curPage="+i+"'>"+i +"</a>&nbsp;";
			}else{
			page +="<a href='designList.do?curPage="+i+"'>"+i +"</a>&nbsp;";
			}
		}//end if
	}
	
	
	req.setAttribute("listDesign", list.getList());
	req.setAttribute("pg",page);
}
}
