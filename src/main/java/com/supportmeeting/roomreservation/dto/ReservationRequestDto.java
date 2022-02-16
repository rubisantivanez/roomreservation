package com.supportmeeting.roomreservation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class ReservationRequestDto {

    @JsonProperty("attendees_number")
    private int attendeesNumber;

    @JsonProperty("multimedia_required")
    private boolean multimediaRequired;

    @JsonProperty("meeting_time_span")
    private int meetingTimeSpan;

    @JsonProperty("reservation_date")
    private Date reservationDate;

    @JsonProperty("building_name")
    private String buildingName;

}
