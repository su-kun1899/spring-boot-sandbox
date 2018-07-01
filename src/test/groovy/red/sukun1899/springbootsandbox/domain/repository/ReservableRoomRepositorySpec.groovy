package red.sukun1899.springbootsandbox.domain.repository

import com.ninja_squad.dbsetup.DbSetup
import com.ninja_squad.dbsetup.destination.DataSourceDestination
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import javax.sql.DataSource
import java.time.LocalDate

import static com.ninja_squad.dbsetup.Operations.insertInto
import static com.ninja_squad.dbsetup.Operations.sequenceOf

/**
 * @author su-kun1899
 */
@SpringBootTest
class ReservableRoomRepositorySpec extends Specification {
    @Autowired
    ReservableRoomRepository reservableRoomRepository

    @Autowired
    DataSource dataSource

    def '予約可能な会議室の一覧を取得する'() {
        given:
        def operation = sequenceOf(
                DbSetupOperations.DELETE_ALL,
                insertInto("meeting_room")
                        .columns("room_id", "room_name")
                        .values(1, "品川")
                        .values(2, "目黒")
                        .values(3, "恵比寿")
                        .build(),
                insertInto("reservable_room")
                        .columns("reserved_date", "room_id")
                        .values("2018-6-09", 1)
                        .values("2018-6-10", 1)
                        .values("2018-6-09", 2)
                        .values("2018-6-10", 2)
                        .values("2018-6-11", 2)
                        .values("2018-6-09", 3)
                        .values("2018-6-11", 3)
                        .build(),
        )
        def dbSetup = new DbSetup(new DataSourceDestination(dataSource), operation)
        dbSetup.launch()

        and:
        def date = LocalDate.of(2018, 6, 10)

        when:
        def result = reservableRoomRepository.findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(date)

        then:
        result.size() == 2

        and:
        result[0].meetingRoom.roomId == 1
        result[0].meetingRoom.roomName == "品川"
        result[0].reservableRoomId.reservedDate == date

        and:
        result[1].meetingRoom.roomId == 2
        result[1].meetingRoom.roomName == "目黒"
        result[1].reservableRoomId.reservedDate == date
    }
}