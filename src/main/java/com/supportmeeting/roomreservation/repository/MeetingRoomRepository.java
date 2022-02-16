package com.supportmeeting.roomreservation.repository;

import com.supportmeeting.roomreservation.entity.MeetingRoom;
import com.supportmeeting.roomreservation.translate.IAvailableRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Long> {

    @Query(value = "SELECT mr.max_allocation as maxAllocation, mr.room_name as roomName, mr.id as roomId "
            + "FROM meeting_room mr "
            + "WHERE mr.max_allocation = ?1 "
            + "     ORDER BY mr.max_allocation DESC", nativeQuery = true)
    List<IAvailableRoom> findAvailableRooms(@Param("attendees_number") int attendeesNumber);

    @Query(value = "SELECT mr.max_allocation as maxAllocation, mr.room_name as roomName, mr.id as roomId  "
            + "FROM meeting_room mr "
            + "     JOIN building b "
            + "         ON mr.building_id = b.id "
            + "WHERE mr.max_allocation >= ?1 "
            + "AND b.name LIKE CONCAT(?2, '%')"
            + "     ORDER BY mr.max_allocation DESC", nativeQuery = true)
    List<IAvailableRoom> findAvailableRoomsWithBuilding(@Param("attendees_number") int attendeesNumber,
                                                        @Param("building") String building);

}
