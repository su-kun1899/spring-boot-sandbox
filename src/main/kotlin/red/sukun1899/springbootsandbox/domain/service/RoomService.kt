package red.sukun1899.springbootsandbox.domain.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import red.sukun1899.springbootsandbox.domain.model.ReservableRoom
import red.sukun1899.springbootsandbox.domain.repository.ReservableRoomRepository
import java.time.LocalDate

/**
 * @author su-kun1899
 */
@Service
@Transactional
class RoomService(private val reservableRoomRepository: ReservableRoomRepository) {

    fun findReservableRooms(date: LocalDate): List<ReservableRoom> =
            reservableRoomRepository.findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(date)
}