package com.joker.ai.xiaozhi.xiaozhi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joker.ai.xiaozhi.xiaozhi.entity.Appointment;

public interface AppointmentService extends IService<Appointment> {
    Appointment getOne(Appointment appointment);
}