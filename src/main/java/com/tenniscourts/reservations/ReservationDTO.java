package com.tenniscourts.reservations;

import com.tenniscourts.schedules.ScheduleDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
@Component
public class ReservationDTO {

    private Long id;

    private ScheduleDTO schedule;

    private String reservationStatus;

    private ReservationDTO previousReservation;

    private BigDecimal refundValue;

    private BigDecimal value;

    private Long scheduledId;

    private Long guestId;

	public ReservationDTO( Long guestId, Long scheduleId) {
	this.guestId=guestId;
	this.scheduledId = scheduleId;
	}

}
