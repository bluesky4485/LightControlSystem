package com.gaogandeng.utils;

import com.gaogandeng.QueryCondition.WarningLogQuery;
import com.gaogandeng.model.WarningLog;
import com.gaogandeng.service.WarningLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 */

@Service("warningService")
public class WarningInfoService {
    private WarningLogService warningLogService;

    @Autowired
    public void setWarningLogService(WarningLogService warningLogService) {
        this.warningLogService = warningLogService;
    }

    /**
     * 根据条件查询报警信息
     * @param query
     * @return
     */
    public List<WarningLog> queryWarningInfo(WarningLogQuery query){
        return warningLogService.findWarningLogs(query);
    }

    /**
     * 根据信息id确认报警信息
     * @param id
     */
    public void confirmWarningInfo(Integer id){
        warningLogService.confirmWarning(id);
    }

    /**
     * 批量确认报警信息
     * @param ids
     */
    public void confirmWarningInfo(List<Integer> ids){
        for (Integer id : ids){
            confirmWarningInfo(id);
        }
    }
}
