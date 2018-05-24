package red.sukun1899.springbootsandbox.domain.model

import java.time.LocalTime
import javax.persistence.*

/**
 * @author su-kun1899
 */
data class Reservation(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var reservationId: String = "",
        var startTime: LocalTime = LocalTime.MIN,
        var endTime: LocalTime = LocalTime.MIN,
        @ManyToOne
        @JoinColumns(JoinColumn(name = "reserved_date"), JoinColumn(name = "room_id"))
        var reservableRoom: ReservableRoom = ReservableRoom(),
        @ManyToOne
        @JoinColumn(name = "user_id")
        var user: User = User()
)
