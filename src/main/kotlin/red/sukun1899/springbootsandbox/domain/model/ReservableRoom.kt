package red.sukun1899.springbootsandbox.domain.model

import javax.persistence.*

/**
 * @author su-kun1899
 */
@Entity
data class ReservableRoom(
        @EmbeddedId
        var reservableRoomId: ReservableRoomId = ReservableRoomId(),
        @ManyToOne
        @JoinColumn(name = "room_id", insertable = false, updatable = false)
        @MapsId("roomId")
        var meetingRoom: MeetingRoom = MeetingRoom()
)
