package com.supportmeeting.roomreservation.repository;

import com.supportmeeting.roomreservation.entity.MeetingRoom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class MeetingRoomRepositoryTest {

    @Autowired
    private MeetingRoomRepository meetingRoomRepository;

    @Test
    public void testFindAll() {
        List<MeetingRoom> items = meetingRoomRepository.findAll();
        assertEquals(5, items.size());
    }

    @Test
    public void testFindOne() {
        MeetingRoom meetingRoom = meetingRoomRepository.findById(1L).get();
        assertEquals("Main lounge", meetingRoom.getRoomName());
    }
}
