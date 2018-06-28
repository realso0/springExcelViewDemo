package com.spring.excelView;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

//아파치 POI 라이브러리를 이용하여 엑셀파일을 생성하는 클래스
public class ExcelBuilder extends AbstractExcelView { //AbstractExcelView를 상속받아야 함.
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		List<Book> listBooks = (List<Book>)model.get("BookLists");
		
		//엑셀 sheet 만들기
		HSSFSheet sheet = workbook.createSheet("자바책");
		sheet.setDefaultColumnWidth(20);
		
		// 셀 스타일 지정
		CellStyle style = workbook.createCellStyle();
		
		// 폰트 지정
		Font font = workbook.createFont();
		font.setFontName("맑은고딕");
		
		style.setFillForegroundColor(HSSFColor.GREEN.index); //배경색 초록
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBold(true);
		font.setColor(HSSFColor.WHITE.index); //하얀 글씨
		
		style.setFont(font); //스타일에 폰트를 설정
		
		// 타이틀 행(row)을 추가
		HSSFRow title = sheet.createRow(0); //첫번째 행은 무조건 0 (1이 아님)
		
		title.createCell(0).setCellValue("제목"); //첫번째 열 (첫번째 열도 무조건 0)
		title.getCell(0).setCellStyle(style);
		
		title.createCell(1).setCellValue("저자"); //두번째 열
		title.getCell(1).setCellStyle(style);
		
		title.createCell(2).setCellValue("ISBN"); //세번째 열
		title.getCell(2).setCellStyle(style);
		
		title.createCell(3).setCellValue("출판일"); //네번째 열
		title.getCell(3).setCellStyle(style);
		
		title.createCell(4).setCellValue("가격"); //다섯번째 열
		title.getCell(4).setCellStyle(style);
		
		// 이전에 만들었던 책 데이타 행을 추가
		int rowCnt = 1;
		
		for(Book book : listBooks){
			HSSFRow row = sheet.createRow(rowCnt++); //한바퀴 돌고나서 2가 됨.
			row.createCell(0).setCellValue(book.getSubject());
			row.createCell(1).setCellValue(book.getAuthor());
			row.createCell(2).setCellValue(book.getIsbn());
			row.createCell(3).setCellValue(book.getPublishDate());
			row.createCell(4).setCellValue(book.getPrice());			
		}//for
	}
}
