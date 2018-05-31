package red.sukun1899.springbootsandbox.domain.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * @author su-kun1899
 */
@Entity
data class MeetingRoom(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var roomId: Int = 0,
        var roomName: String = ""
)
