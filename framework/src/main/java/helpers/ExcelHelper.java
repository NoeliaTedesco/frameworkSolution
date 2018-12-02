package helpers;

import context.Usuario;
import log.Log;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelHelper {

	public static Usuario usuario;

	public static List<HashMap<String, String>> cargarExcel(String hojaExcel) {
		try {
			List<HashMap<String, String>> excelFile = new ArrayList<>();
			FileInputStream fs = new FileInputStream("src/test/java/datapool/usuariosPrestador.xls");
			HSSFWorkbook workbook = new HSSFWorkbook(fs);
			HSSFSheet sheet = workbook.getSheet(hojaExcel);
			Row HeaderRow = sheet.getRow(0);

			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				HashMap<String, String> currentHash = new HashMap<>();
				for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
					Cell currentCell = currentRow.getCell(j);
					switch (currentCell.getCellType()) {
					case Cell.CELL_TYPE_STRING: {
						currentHash.put(HeaderRow.getCell(j).getStringCellValue(), 
								currentCell.getStringCellValue());
						break;
					}
					}
				}
				excelFile.add(currentHash);
			}
			return excelFile;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			log.Log.info(ex.getMessage());
		}
		return null;
	}

	public static void mostrarExcelCargado() {
		try {
			List<HashMap<String, String>> datos = cargarExcel("Sheet1");
			for (int i = 0; i < datos.size(); i++) {
				System.out.println(datos.get(i).values());
			}
		} catch (Exception ex) {
			log.Log.info(ex.getMessage());
		}
	}

}
