package com.supportmeeting.roomreservation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supportmeeting.roomreservation.dto.ReservationRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MeetingRoomReservationApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test for getting available rooms")
    void getAvailableRooms() throws Exception {
        ReservationRequestDto reservationRequestDto = ReservationRequestDto.builder()
                .reservationDate(new Date())
                .multimediaRequired(true)
                .attendeesNumber(40)
                .meetingTimeSpan(40)
                .build();

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/room_reservation/available_rooms")
                .content(new ObjectMapper().writeValueAsString(reservationRequestDto))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

}
