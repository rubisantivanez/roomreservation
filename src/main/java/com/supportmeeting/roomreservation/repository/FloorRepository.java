package com.supportmeeting.roomreservation.repository;

import com.supportmeeting.roomreservation.entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FloorRepository extends JpaRepository<Floor, Long> {
}
