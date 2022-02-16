package com.supportmeeting.roomreservation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "meeting_room")
public class MeetingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "room_name")
    private String roomName;

    @ManyToOne
    @JoinColumn(name = "floor_id", nullable = false)
    private Floor floor;

    @OneToOne
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    @Column(name = "max_allocation")
    private int maxAllocation;

    @OneToOne(mappedBy = "meetingRoom")
    private Reservation reservation;

}
