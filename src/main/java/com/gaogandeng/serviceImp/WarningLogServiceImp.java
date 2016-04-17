package com.gaogandeng.serviceImp;

import com.gaogandeng.QueryCondition.WarningLogQuery;
import com.gaogandeng.dao.WarningLogMapper;
import com.gaogandeng.model.WarningLog;
import com.gaogandeng.service.WarningLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 */

@Service("warningLogService")
public class WarningLogServiceImp implements WarningLogService {

    private WarningLogMapper warningLogMapper;

    @Autowired
    public void setWarningLogMapper(WarningLogMapper warningLogMapper) {
        this.warningLogMapper = warningLogMapper;
    }

    public void insertWarningLog(WarningLog log) {
        warningLogMapper.insertWarningLog(log);
    }

    public List<WarningLog> findAllWarningLogs() {
        return warningLogMapper.findAllWarningLogs();
    }

    public List<WarningLog> findWarningLogs(WarningLogQuery query) {
        return warningLogMapper.findWarningLogs(query);
    }

    public void confirmWarning(Integer id) {
        warningLogMapper.confirmWarning(id);
    }
}
