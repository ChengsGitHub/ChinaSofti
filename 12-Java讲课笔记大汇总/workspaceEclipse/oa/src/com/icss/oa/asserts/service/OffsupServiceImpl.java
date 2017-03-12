package com.icss.oa.asserts.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.asserts.dao.OffsupDao;
import com.icss.oa.system.pojo.Job;
import com.icss.oa.asserts.pojo.Offsup;

@Service
@Transactional(rollbackFor = Exception.class)
public class OffsupServiceImpl implements OffsupService{

	@Autowired
	private OffsupDao dao;

	public void insert(Offsup offsup) {
		dao.insert(offsup);
	}

	public void update(Offsup offsup) {
		dao.update(offsup);
	}

	public void delete(Integer offsupId) {
		dao.delete(offsupId);
	}

	public Offsup queryById(Integer offsupId) {

		return dao.queryById(offsupId);
	}

	public List<Offsup> query(Pager pager) {

		return dao.query(pager);
	}

	public int getContentCount() {

		return dao.getContentCount();
	}
	/**
	 * ����EXCEL�ļ�
	 * 
	 * @param os
	 *            �����
	 * @throws IOException 
	 */
	public void exportExcel(OutputStream os) throws IOException {

		Pager pager = new Pager(dao.getContentCount(), 1, dao.getContentCount());
		List<Offsup> list = dao.query(pager);

		String[] titles = { "�ʲ����", "�ʲ�����","�ʲ�����" };

		// ��������������
		HSSFWorkbook wb = new HSSFWorkbook();

		// �������������
		HSSFSheet sheet1 = wb.createSheet("�ʲ�����");

		// ����������
		HSSFRow rowTitle = sheet1.createRow(0);
		
		for (int i = 0;i < titles.length;i ++) {
			rowTitle.createCell(i).setCellValue(titles[i]);
		}
		
		//����������
		for (int i = 0;i < list.size();i ++) {
						
			HSSFRow row = sheet1.createRow(i + 1);
			row.createCell(0).setCellValue(list.get(i).getId());
			row.createCell(1).setCellValue(list.get(i).getName());
			row.createCell(2).setCellValue(list.get(i).getLoss()==null?0:list.get(i).getLoss());
		}
		
		wb.write(os);
		os.close();

	}

}
