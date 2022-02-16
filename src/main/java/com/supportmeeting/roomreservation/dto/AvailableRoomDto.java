package com.supportmeeting.roomreservation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AvailableRoomDto {

    @JsonProperty("room_name")
    private String roomName;

    @JsonProperty("room_id")
    private String roomId;

    @JsonProperty("clean_up_minutes")
    private int cleanUpMinutes;


}
