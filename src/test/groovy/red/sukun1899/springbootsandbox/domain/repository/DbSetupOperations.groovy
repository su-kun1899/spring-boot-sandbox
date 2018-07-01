package red.sukun1899.springbootsandbox.domain.repository

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom

/**
 * @author su-kun1899
 */
class DbSetupOperations {
    static final def DELETE_ALL =
            deleteAllFrom(
                    "reservation",
                    "reservable_room",
                    "meeting_room",
                    "usr"
            )
}
