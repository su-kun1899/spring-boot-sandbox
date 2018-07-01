package red.sukun1899.springbootsandbox.domain.controller

import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import red.sukun1899.springbootsandbox.domain.model.MeetingRoom
import red.sukun1899.springbootsandbox.domain.model.ReservableRoom
import red.sukun1899.springbootsandbox.domain.model.ReservableRoomId
import red.sukun1899.springbootsandbox.domain.service.RoomService
import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

/**
 * @author su-kun1899
 */
@WebMvcTest(RoomsController)
class RoomsControllerSpec extends Specification {
    @Autowired
    MockMvc mvc

    @MockBean
    RoomService roomService

    def "会議室の一覧を表示する"() {
        given:
        def date = LocalDate.now()
        def stubRooms = [new ReservableRoom(
                new ReservableRoomId(1, date),
                new MeetingRoom(1, '汐留'),
        )]

        when:
        // Nowとかテストで使いたくないんだよなぁ。。
        BDDMockito.given(this.roomService.findReservableRooms(date)).willReturn(
                stubRooms
        )

        then:
        this.mvc.perform(MockMvcRequestBuilders.get("/rooms"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("rooms", stubRooms))
    }

    def "指定した日付の会議室の一覧を表示する"() {
        given:
        def date = LocalDate.of(2018, Month.JUNE, 23)
        def stubRooms = [new ReservableRoom(
                new ReservableRoomId(1, date),
                new MeetingRoom(1, '汐留'),
        )]

        when:
        BDDMockito.given(this.roomService.findReservableRooms(date)).willReturn(
                [new ReservableRoom(
                        new ReservableRoomId(1, date),
                        new MeetingRoom(1, '汐留'),
                )]
        )

        then:
        this.mvc.perform(MockMvcRequestBuilders.get("/rooms/2018-06-23"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attribute("rooms", stubRooms))
    }
}
