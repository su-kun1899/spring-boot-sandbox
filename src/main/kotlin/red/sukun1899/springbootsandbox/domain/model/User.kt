package red.sukun1899.springbootsandbox.domain.model

import java.io.Serializable
import javax.persistence.*

/**
 * @author su-kun1899
 */
@Entity
@Table(name = "usr")
data class User(
        @Id
        var userId: String = "",
        var password: String = "",
        var firstName: String = "",
        var lastName: String = "",
        @Enumerated(EnumType.STRING)
        var roleName: RoleName = RoleName.USER
) : Serializable
