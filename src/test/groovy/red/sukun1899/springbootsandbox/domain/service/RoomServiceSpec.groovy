package red.sukun1899.springbootsandbox.domain.service

import red.sukun1899.springbootsandbox.domain.repository.ReservableRoomRepository
import spock.lang.Specification

import java.time.LocalDate

/**
 * @author su-kun1899
 */
class RoomServiceSpec extends Specification {
    def "日付でDBを検索した結果を返却する"() {
        given:
        def reservableRoomRepository = Mock(ReservableRoomRepository)
        def roomService = new RoomService(reservableRoomRepository)
        def date = LocalDate.of(2018, 6, 18)
        def repositoryResult = Stub(List)

        when:
        def actual = roomService.findReservableRooms(date)

        then:
        1 * reservableRoomRepository.findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(date) >> repositoryResult

        and:
        actual == repositoryResult
    }
}
