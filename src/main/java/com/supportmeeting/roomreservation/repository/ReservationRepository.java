package com.supportmeeting.roomreservation.repository;

import com.supportmeeting.roomreservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query(value = "SELECT COUNT(*) "
            + "FROM reservation r"
            + "     JOIN meeting_room mr "
            + "         ON r.meeting_room_id = mr.id "
            + "     JOIN meeting_room_multimedia mr "
            + "         ON r.meeting_room_id = mr.id "
            + "WHERE mr.max_allocation = ?1 "
            + "AND r.start_date = ?2"
            + "     ORDER BY mr.max_allocation DESC", nativeQuery = true)
    int findExistingReservation(@Param("attendees_number") int attendeesNumber,
                                @Param("start_date") int startDate);

}
