package com.tenniscourts.reservations;

import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.tenniscourts.config.BaseRestController;
import com.tenniscourts.exceptions.EntityNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@Api(tags = { "Reservation - Tennis Court" })
public class ReservationController extends BaseRestController {

    private final ReservationService reservationService;

    @PostMapping(path="/reservation")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Reservation for Tennis Court", notes = "This service is reserves the tennis court", tags = { "Reservation - Tennis Court" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful operation"),
			@ApiResponse(code = 500, message = "Internal Server Error", response = InternalServerError.class) })
	
    public ResponseEntity<Void> bookReservation(@RequestBody CreateReservationRequestDTO createReservationRequestDTO) {
    	System.out.println("book reservation");
        return ResponseEntity.created(locationByEntity(reservationService.bookReservation(createReservationRequestDTO).getId())).build();
    }

    @GetMapping(path="/reservation/{reservationId}")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(
            value = "Returns a list of all OIDC users",
            response = ReservationDTO.class
    )
    @ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful operation"),
			@ApiResponse(code = 500, message = "Internal Server Error", response = InternalServerError.class) })
	public ResponseEntity<ReservationDTO> findReservation(Long reservationId) {
        return ResponseEntity.ok(reservationService.findReservation(reservationId));
    }

    @DeleteMapping(path="/reservation/{reservationId}")
    public ResponseEntity<ReservationDTO> cancelReservation(@PathParam(value = "reservationId") Long reservationId)throws EntityNotFoundException {
        return ResponseEntity.ok(reservationService.cancelReservation(reservationId));
    }

    @RequestMapping(path="/reservation/{reservationId}/{scheduleId}")
    @ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful operation"),
			@ApiResponse(code = 500, message = "Internal Server Error", response = InternalServerError.class) })
	public ResponseEntity<ReservationDTO> rescheduleReservation(@PathParam(value = "reservationId")Long reservationId, @PathParam(value = "scheduleId")Long scheduleId) {
        return ResponseEntity.ok(reservationService.rescheduleReservation(reservationId, scheduleId));
    }
}
