package com.taiji.wjw.wjwportal.service;

import com.taiji.wjw.wjwportal.model.DiagnosisVo;
import com.taiji.wjw.wjwportal.model.LivingTogetherContactVo;
import com.taiji.wjw.wjwportal.model.SameHouseholdContactVo;
import com.taiji.wjw.wjwportal.model.TrafficContactVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MushAllytrialExportService {

    public List<List<String>> findTScoreTotalDtos() {
        List<TrafficContactVo> list = new ArrayList<>();
        TrafficContactVo trafficContact1 = new TrafficContactVo();
        list.add(trafficContact1);
        TrafficContactVo trafficContact2 = new TrafficContactVo();
        list.add(trafficContact2);

        //数据处理
        List<List<String>> data0 = new ArrayList<List<String>>();
        //序号处理
        int index1 = 1;
        for(TrafficContactVo trafficContact : list){
            List rowData = new ArrayList();
            rowData.add(index1+"");
            rowData.add(trafficContact.getID()==null?"":trafficContact.getID());
            rowData.add(trafficContact.getTool()==null?"":trafficContact.getTool());
            rowData.add(trafficContact.getShifts()==null?"":trafficContact.getShifts());
            rowData.add(trafficContact.getTime()==null?"":trafficContact.getTime());
            rowData.add(trafficContact.getFrom()==null?"":trafficContact.getFrom());
            rowData.add(trafficContact.getTo()==null?"":trafficContact.getTo());
            rowData.add(trafficContact.getTID()==null?"":trafficContact.getTID());
            data0.add(rowData);
            index1++;
        }

        return data0;
    }

    public List<LivingTogetherContactVo> findlivingTogethers() {
        List<LivingTogetherContactVo> list = new ArrayList<>();
        LivingTogetherContactVo livingTogetherContact = new LivingTogetherContactVo();
        list.add(livingTogetherContact);
        return list;
    }

    public List<SameHouseholdContactVo> findSameHouseholds() {
        List<SameHouseholdContactVo> list = new ArrayList<>();
        SameHouseholdContactVo sameHouseholdContact = new SameHouseholdContactVo();
        list.add(sameHouseholdContact);
        return list;
    }

    public List<List<String>>  findDiagnosis() {
        List<DiagnosisVo> list = new ArrayList<>();
        DiagnosisVo diagnosisVo1 = new DiagnosisVo();
        diagnosisVo1.setID("1111");
        diagnosisVo1.setShifts("火车");
        diagnosisVo1.setTime(System.currentTimeMillis()+"");
        diagnosisVo1.setType("密接方式");
        list.add(diagnosisVo1);

        //处理数据
        List<List<String>> data = new ArrayList<List<String>>();
        //序号处理
        int index1 = 1;
        for(DiagnosisVo diagnosisVo : list){
            List rowData = new ArrayList();
            rowData.add(index1+"");
            rowData.add(diagnosisVo.getID()==null?"":diagnosisVo.getID());
            rowData.add(diagnosisVo.getType()==null?"":diagnosisVo.getType());
            rowData.add(diagnosisVo.getShifts()==null?"":diagnosisVo.getShifts());
            rowData.add(diagnosisVo.getTime()==null?"":diagnosisVo.getTime());
            rowData.add(diagnosisVo.getHID()==null?"":diagnosisVo.getHID());
            data.add(rowData);
            index1++;
        }
        return data;
    }
}
