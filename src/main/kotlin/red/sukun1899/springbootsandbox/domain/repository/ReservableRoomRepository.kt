package red.sukun1899.springbootsandbox.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import red.sukun1899.springbootsandbox.domain.model.ReservableRoom
import red.sukun1899.springbootsandbox.domain.model.ReservableRoomId
import java.time.LocalDate

/**
 * @author su-kun1899
 */
@Repository
interface ReservableRoomRepository : JpaRepository<ReservableRoom, ReservableRoomId> {
    fun findByReservableRoomeId_reservedDateOrderByReservableRoomId_roomIdAsc(reservedDate: LocalDate): List<ReservableRoom>
}