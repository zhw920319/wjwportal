package com.taiji.wjw.wjwportal.controller.test;

import com.taiji.wjw.wjwportal.model.LivingTogetherContactVo;
import com.taiji.wjw.wjwportal.model.SameHouseholdContactVo;
import com.taiji.wjw.wjwportal.model.TrafficContactVo;
import com.taiji.wjw.wjwportal.service.MushAllytrialExportService;
import com.taiji.wjw.wjwportal.utils.ExportExcelUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    private Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired(required = false)
    private MushAllytrialExportService mushAllytrialExportService;

    @PostMapping("hello")
    @ResponseBody
    public String hello() {
        log.info("hello");
        return "hello";
    }
    //多sheet表导出模板
    @ResponseBody
    @PostMapping(value = "/exportAllyScoreCount")
    @ApiOperation(value = "导出对应关系")
    public void exportAllyScoreCount(HttpServletRequest request,HttpServletResponse response){
//        String fileName = System.currentTimeMillis()+".xlsx";
        String fileName = "密接人员.xlsx";

        try {
            response.setHeader("Content-Disposition", "attachment; filename=".concat(fileName));
            response.setHeader("Connection", "close");
            response.setHeader("Content-Type", "application/vnd.ms-excel");
            OutputStream ouputStream = response.getOutputStream();

            /*交通密接*/
            List<List<String>> data0 = mushAllytrialExportService.findTScoreTotalDtos();

            /*同住密接*/
            List<List<String>> data1 = new ArrayList<List<String>>();
            List<LivingTogetherContactVo> livingTogetherContacts = mushAllytrialExportService.findlivingTogethers();

            int index2 = 1;
            for(LivingTogetherContactVo livingTogetherContact : livingTogetherContacts){
                List rowData = new ArrayList();
                rowData.add(index2+"");
                rowData.add(livingTogetherContact.getID()==null?"":livingTogetherContact.getID());
                rowData.add(livingTogetherContact.getHID()==null?"":livingTogetherContact.getHID());
                rowData.add(livingTogetherContact.getName()==null?"":livingTogetherContact.getName());
                rowData.add(livingTogetherContact.getRelation()==null?"":livingTogetherContact.getRelation());
                data1.add(rowData);
                index2 ++ ;
            }
            /*同户密接*/
            List<List<String>> data2 = new ArrayList<List<String>>();
            List<SameHouseholdContactVo> sameHouseholdContacts = mushAllytrialExportService.findSameHouseholds();
            int index3 = 1;
            for(SameHouseholdContactVo sameHouseholdContact : sameHouseholdContacts){
                List rowData = new ArrayList();
                rowData.add(index3+"");
                rowData.add(sameHouseholdContact.getHID()==null?"":sameHouseholdContact.getHID());
                rowData.add(sameHouseholdContact.getName()==null?"":sameHouseholdContact.getName());
                rowData.add(sameHouseholdContact.getHotelName()==null?"":sameHouseholdContact.getHotelName());
                rowData.add(sameHouseholdContact.getAddress()==null?"":sameHouseholdContact.getAddress());
                rowData.add(sameHouseholdContact.getTime()==null?"":sameHouseholdContact.getTime());
                data2.add(rowData);
                index3 ++;
            }
            String[] headers0 = { "序号","身份证号", "密接交通工具","车次/班次","时间","始发站","终到站","密接身份证号"};
            String[] headers1 = { "序号","身份证号", "同户人身份证号","同户人姓名","与户主关系"};
            String[] headers2 = { "序号","同住身份证号", "姓名","旅馆名称","旅馆地址","入住时间"};
           ExportExcelUtils eeu = new ExportExcelUtils();
            XSSFWorkbook workbook = new XSSFWorkbook();
            eeu.exportExcel(workbook, 0, "交通密接", headers0,new int[]{8,24,16,24,24,24,24,24}, data0, ouputStream);
            eeu.exportExcel(workbook, 1, "同住密接", headers1,new int[]{8,24,30,24,24}, data1, ouputStream);
            eeu.exportExcel(workbook, 2, "同户密接", headers2,new int[]{8,24,16,24,24,24}, data2, ouputStream);
           //原理就是将所有的数据一起写入，然后再关闭输入流。
            workbook.write(ouputStream);
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //单sheet表导出模板
    @ResponseBody
    @PostMapping(value = "/exportOne")
    @ApiOperation(value = "导出对应关系")
    public void exportOne(HttpServletRequest request,HttpServletResponse response) throws Exception {
//        String fileName = System.currentTimeMillis()+".xlsx";
        java.lang.String fileName = new String("对比列表.xls".getBytes(), "iso-8859-1");

        try {
            response.setHeader("Content-Disposition", "attachment; filename=".concat(fileName));
            response.setHeader("Connection", "close");
            response.setHeader("Content-Type", "application/vnd.ms-excel");
            OutputStream ouputStream = response.getOutputStream();

            /*确诊人员*/
            List<List<String>> data0 = mushAllytrialExportService.findDiagnosis();

            String[] headers0 = { "序号","身份证号", "密接方式","车次/班次","密接时间","密接身份证号"};
            ExportExcelUtils eeu = new ExportExcelUtils();
            XSSFWorkbook workbook = new XSSFWorkbook();
            eeu.exportExcel(workbook, 0, "密接史", headers0,new int[]{8,24,16,24,24,24}, data0, ouputStream);
              //原理就是将所有的数据一起写入，然后再关闭输入流。
            workbook.write(ouputStream);
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
