package red.sukun1899.springbootsandbox.domain.model

import java.time.LocalDate

/**
 * @author su-kun1899
 */
data class ReservableRoomId(
        var roomId:Int = 0,
        var reserveDate: LocalDate = LocalDate.MIN
)
