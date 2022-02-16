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
@Table(name = "meeting_room_multimedia")
public class MeetingRoomMultimedia {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "meetingRoomId",
                    column = @Column(name = "meeting_room_id", nullable = false)),
            @AttributeOverride(name = "multimediaId",
                    column = @Column(name = "multimedia_id", nullable = false))
    })
    private MeetingRoomMultimediaId meetingRoomMultimediaId;

}
