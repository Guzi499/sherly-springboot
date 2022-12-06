package com.guzi.sherly.manager;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guzi.sherly.model.PageResult;
import com.guzi.sherly.model.dto.ScheduleTaskInsertDTO;
import com.guzi.sherly.model.dto.ScheduleTaskPageDTO;
import com.guzi.sherly.model.vo.ScheduleTaskPageVO;
import com.guzi.sherly.modules.quartz.dao.ScheduleTaskDao;
import com.guzi.sherly.modules.quartz.model.ScheduleTask;
import com.guzi.sherly.modules.quartz.util.ScheduleTaskUtil;
import org.quartz.Scheduler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 谷子毅
 * @date 2022/12/5
 */
@Service
public class ScheduleTaskManager {

    @Resource
    private ScheduleTaskDao scheduleTaskDao;

    @Resource
    private Scheduler scheduler;

    /**
     * 定时任务分页
     * @param dto
     * @return
     */
    public PageResult<ScheduleTaskPageVO> listPage(ScheduleTaskPageDTO dto) {
        Page<ScheduleTask> page = scheduleTaskDao.listPage(dto);

        List<ScheduleTaskPageVO> result = page.getRecords().stream().map(e -> {
            ScheduleTaskPageVO scheduleTaskPageVO = new ScheduleTaskPageVO();
            BeanUtils.copyProperties(e, scheduleTaskPageVO);
            return scheduleTaskPageVO;
        }).collect(Collectors.toList());

        return PageResult.build(result, page.getTotal());
    }

    /**
     * 定时任务新增
     * @param dto
     */
    public void saveOne(ScheduleTaskInsertDTO dto) {
        ScheduleTask scheduleTask = new ScheduleTask();
        BeanUtils.copyProperties(dto, scheduleTask);
        //boolean isSave = scheduleTaskDao.save(scheduleTask);
        //if (isSave) {
            ScheduleTaskUtil.createScheduleTaskJob(scheduler, scheduleTask);
        //}
    }
}
