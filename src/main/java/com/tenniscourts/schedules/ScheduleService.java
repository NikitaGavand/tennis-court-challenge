package com.tenniscourts.schedules;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Component
public class ScheduleService {

    private ScheduleRepository scheduleRepository;

    private ScheduleMapper scheduleMapper;

    public ScheduleDTO addSchedule(Long tennisCourtId, CreateScheduleRequestDTO createScheduleRequestDTO) {
        //TODO: implement addSchedule
        return scheduleMapper.map(this.add(tennisCourtId, createScheduleRequestDTO));
    }

    private Schedule add(Long tennisCourtId, CreateScheduleRequestDTO createScheduleRequestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ScheduleDTO> findSchedulesByDates(LocalDateTime startDate, LocalDateTime endDate) {
        //TODO: implement
        return null;
    }

    public ScheduleDTO findSchedule(Long scheduleId) {
        //TODO: implement
        return null;
    }

    public List<ScheduleDTO> findSchedulesByTennisCourtId(Long tennisCourtId) {
        return scheduleMapper.map(scheduleRepository.findByTennisCourt_IdOrderByStartDateTime(tennisCourtId));
    }
}
