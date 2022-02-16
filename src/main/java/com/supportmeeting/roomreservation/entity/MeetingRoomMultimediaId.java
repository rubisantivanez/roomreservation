package com.supportmeeting.roomreservation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetingRoomMultimediaId implements Serializable {
    private Long meetingRoomId;
    private Long multimediaId;
}
