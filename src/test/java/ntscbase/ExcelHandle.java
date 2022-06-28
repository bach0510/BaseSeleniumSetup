package ntscbase;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import  java.io.FileOutputStream;
import  java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelHandle {
    private FileInputStream fis;
    private FileOutputStream fos;
    private Workbook wb;
    private Sheet sh;
    private Cell cell;
    private Row row;
    private CellStyle cellstyle;
    private Color color;
    private  String excelpath;
    private Map<String,Integer> columns = new HashMap<>();

    public void setExcelFile(String path, String sheetName) throws Exception{
        try {
            File f = new File(path);

            if(!f.exists()){
                //f.createNewFile();
                System.out.println("File khong ton tai");
            }
            else{
                fis = new FileInputStream(path);
                wb = WorkbookFactory.create(fis);
                if (wb == null){
                    sh = wb.createSheet();
                }

                this.excelpath = excelpath;

                sh.getRow(0).forEach(cell ->{
                    columns.put(cell.getStringCellValue(),cell.getColumnIndex());
                });
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getCellData(int rowNum, int columnNum) throws Exception{
        try {
            cell = sh.getRow(rowNum).getCell(columnNum);
            String cellData = null;
            switch (cell.getCellType()){
                case STRING:
                    cellData = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if(DateUtil.isCellDateFormatted(cell)){
                        cellData = String.valueOf(cell.getDateCellValue());
                    }
                    else
                    {
                        cellData = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    cellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    cellData = "";
                    break;
            }
            return  cellData;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return "";
        }
    }
};
