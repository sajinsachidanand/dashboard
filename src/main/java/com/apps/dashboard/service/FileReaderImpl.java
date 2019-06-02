package com.apps.dashboard.service;

import com.apps.dashboard.constants.ColumnNames;
import com.apps.dashboard.model.AppModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class FileReaderImpl implements FileReader {

    public static final String FILE_PATH = "assets/filename.xlsx";

    @Override
    public List<AppModel> getAppDetails() {
        return getApplicationDetails();
    }

    private List<AppModel> getApplicationDetails() {
        List<AppModel> appDetails = new ArrayList<>();
        try (InputStream is = new ClassPathResource(FILE_PATH).getInputStream()) {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(1);
            Iterator rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                AppModel appModel = new AppModel();
                Row row = (Row) rowIterator.next();
                Iterator cellIterator = row.cellIterator();
                while (cellIterator.hasNext() && row.getRowNum() > 0){
                    Cell cell = (Cell) cellIterator.next();
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    switch (cell.getColumnIndex()) {
                        case ColumnNames.APP_ID:
                            appModel.setAppId(cell.getStringCellValue());
                            break;
                        case ColumnNames.APP_Name:
                            appModel.setAppName(cell.getStringCellValue());
                            break;
                        case ColumnNames.APP_MANAGER:
                            appModel.setAppManager(cell.getStringCellValue());
                            break;
                        case ColumnNames.SME:
                            appModel.setSme(cell.getStringCellValue());
                            break;
                        case ColumnNames.CI:
                            appModel.setCi(cell.getStringCellValue());
                            break;
                        case ColumnNames.SERVICE_TYPE:
                            appModel.setServiceType(cell.getStringCellValue());
                            break;
                        case ColumnNames.N1ORG:
                            appModel.setN1Org(cell.getStringCellValue());
                            break;
                        case ColumnNames.REGION:
                            appModel.setRegion(cell.getStringCellValue());
                            break;
                        case ColumnNames.TECH_SKILL:
                            appModel.setTechSkill(cell.getStringCellValue());
                            break;
                        case ColumnNames.SYS_TYPE:
                            appModel.setSysType(cell.getStringCellValue());
                            break;
                        case ColumnNames.SER_CLASS:
                            appModel.setServiceClass(cell.getStringCellValue());
                            break;
                        case ColumnNames.NO_OF_USR:
                            appModel.setNoOfUsers(cell.getStringCellValue());
                            break;
                        case ColumnNames.NO_OF_INC:
                            appModel.setNoOfIncidentsPerYear(cell.getStringCellValue());
                            break;
                        case ColumnNames.NO_OF_SR:
                            appModel.setNoOfServiceRequestPerYear(cell.getStringCellValue());
                            break;
                        case ColumnNames.NO_OF_CR:
                            appModel.setNoOfChangeRequestPerYear(cell.getStringCellValue());
                            break;
                        case ColumnNames.GO_LIVE_DATE:
                            appModel.setGoLiveDate(cell.getStringCellValue());
                            break;
                        case ColumnNames.REVISED_WAVE:
                            appModel.setRevisedWave(cell.getStringCellValue());
                            break;
                        case ColumnNames.PRIMARY_KR:
                            appModel.setPrimaryKr(cell.getStringCellValue());
                            break;
                        case ColumnNames.SECONDARY_KR:
                            appModel.setSecondaryKr(cell.getStringCellValue());
                            break;
                        case ColumnNames.ADDITIONAL_KR:
                            appModel.setAdditionalKr(cell.getStringCellValue());
                            break;
                        case ColumnNames.SER_TYPE:
                            appModel.setServerType(cell.getStringCellValue());
                            break;
                        case ColumnNames.SER_NAME:
                            appModel.setServerName(cell.getStringCellValue());
                            break;
                        case ColumnNames.SER_ACCESS_ID:
                            appModel.setServerAccessId(cell.getStringCellValue());
                            break;
                        case ColumnNames.LOG_PATH:
                            appModel.setLogPath(cell.getStringCellValue());
                            break;
                        case ColumnNames.DB_DETAIL:
                            appModel.setDbDetail(cell.getStringCellValue());
                            break;
                        case ColumnNames.DB_TYPE:
                            appModel.setDbType(cell.getStringCellValue());
                            break;
                        case ColumnNames.DB_USR_ID:
                            appModel.setDbUserId(cell.getStringCellValue());
                            break;
                        case ColumnNames.DB_PREVILEGE_URL:
                            appModel.setDbPrivilage(cell.getStringCellValue());
                            break;
                        case ColumnNames.DB_URL:
                            appModel.setUrl(cell.getStringCellValue());
                            break;
                        case ColumnNames.DB_URL_ACCESS_ID:
                            appModel.setUrlAccessId(cell.getStringCellValue());
                            break;
                        case ColumnNames.LIC_RENEWAL_FREQ:
                            appModel.setLicence(cell.getStringCellValue());
                            break;
                        case ColumnNames.LAST_RENEW_DATE:
                            appModel.setLastRenewDate(cell.getStringCellValue());
                            break;
                        case ColumnNames.VENDOR_CNT_DETAIL:
                            appModel.setVendorContact(cell.getStringCellValue());
                            break;
                        case ColumnNames.USR_DTL:
                            appModel.setUserDl(cell.getStringCellValue());
                            break;
                        case ColumnNames.APP_DTL:
                            appModel.setAppDetail(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                }
                if(appModel.getAppId()!= null) {
                    appDetails.add(appModel);
                }
                else{
                    //
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return appDetails;
    }
}
