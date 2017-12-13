package org.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.arpit.java2blog.model.RuleSetup;

public class ExportRuleSetupData {
	private final static String filePath = "C:/RuleDataExport.xlsx";
	
	public static void generateRuleSetupRows(List<RuleSetup> ruleSetupList) {
		
		try	{    
			XSSFWorkbook workbook = new XSSFWorkbook(); 
			XSSFSheet sheet = workbook.createSheet("sheet1");// creating a blank sheet

			//add header row
			Row header = sheet.createRow(0);
			header.createCell(0).setCellValue(Constants.RULE_NUMBER);
			header.createCell(1).setCellValue(Constants.RULE_NAME);

			header.createCell(2).setCellValue(Constants.ACCOUNT_NUMBER);
			header.createCell(3).setCellValue(Constants.ACCOUNT_TYPE);

			header.createCell(4).setCellValue(Constants.ISBN);
			header.createCell(5).setCellValue(Constants.FAMILY_CODE);
			header.createCell(6).setCellValue(Constants.PRODUCT_DGP);

			header.createCell(7).setCellValue(Constants.QUANTITY_RANGE_1);
			header.createCell(8).setCellValue(Constants.DISCOUNT_RANGE_1);
			header.createCell(9).setCellValue(Constants.QUANTITY_RANGE_2);
			header.createCell(10).setCellValue(Constants.DISCOUNT_RANGE_2);
			header.createCell(11).setCellValue(Constants.FREIGHT_CHARGE);
			header.createCell(12).setCellValue(Constants.OVERRIDE_EXPLICIT_FLAG);
			header.createCell(13).setCellValue(Constants.HARDCODE_FLAG);
			header.createCell(14).setCellValue(Constants.TERMS);
			header.createCell(15).setCellValue(Constants.COMBO_FIELD);

			header.createCell(16).setCellValue(Constants.PRIORITY);
			header.createCell(17).setCellValue(Constants.DISCOUNT);

			int rowCount = 0;
			Row row = null;
			for (RuleSetup ruleSetup : ruleSetupList) {
				row = sheet.createRow( ++rowCount);
				addRuleSetupValues(ruleSetup, row);
			}

			FileOutputStream out = new FileOutputStream(new File(filePath));
			workbook.write(out);
			out.close();
		} 
		catch (Exception e)	{
			e.printStackTrace();
		}
	}

	private static void addRuleSetupValues(RuleSetup ruleSetup, Row row) {
		/* This method will fill rows will available data for rule setup from UI*/

		Cell cell = row.createCell(0);
		cell.setCellValue(ruleSetup.getRuleNumber());

		cell = row.createCell(1);
		cell.setCellValue(ruleSetup.getRuleName());

		cell = row.createCell(2);
		if(ruleSetup.getAccount().getAccountNumber()!=null) {
			cell.setCellValue(ruleSetup.getAccount().getAccountNumber());
		}

		cell = row.createCell(3);
		cell.setCellValue(ruleSetup.getAccount().getAccountType());

		cell = row.createCell(4);
		if(ruleSetup.getProduct().getIsbn()!=null) {
			cell.setCellValue(ruleSetup.getProduct().getIsbn());
		}

		cell = row.createCell(5);
		cell.setCellValue(ruleSetup.getProduct().getFamilyCode());

		cell = row.createCell(6);
		cell.setCellValue(ruleSetup.getProduct().getProductGroupCode());

		cell = row.createCell(7);
		if(ruleSetup.getQuantityRange1()!=null) {
			cell.setCellValue(ruleSetup.getQuantityRange1());
		}

		cell = row.createCell(8);
		if(ruleSetup.getDiscountRange1()!=null) {
			cell.setCellValue(ruleSetup.getDiscountRange1());
		}

		cell = row.createCell(9);
		if(ruleSetup.getQuantityRange2()!=null) {
			cell.setCellValue(ruleSetup.getQuantityRange2());
		}

		cell = row.createCell(10);
		if(ruleSetup.getDiscountRange2()!=null) {
			cell.setCellValue(ruleSetup.getDiscountRange2());
		}

		cell = row.createCell(11);
		cell.setCellValue(ruleSetup.getOffer().getFrieghtCharge());

		cell = row.createCell(12);
		cell.setCellValue(ruleSetup.getOffer().getOverridenExplicitly());

		cell = row.createCell(13);
		cell.setCellValue(ruleSetup.getOffer().getHardcode());

		cell = row.createCell(14);
		if(ruleSetup.getOffer().getDays()!=null) {
			cell.setCellValue(ruleSetup.getOffer().getDays());
		}

		cell = row.createCell(15);
		if(ruleSetup.getOffer().getComboField()!=null) {
			cell.setCellValue(ruleSetup.getOffer().getComboField());
		}

		cell = row.createCell(16);
		if(ruleSetup.getOffer().getPriority()!=null) {
			cell.setCellValue(ruleSetup.getOffer().getPriority());
		}

		cell = row.createCell(17);
		if(ruleSetup.getDiscount().getPercentage()!=null) {
			cell.setCellValue(ruleSetup.getDiscount().getPercentage());
		}

	}

}
