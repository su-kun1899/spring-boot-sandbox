package red.sukun1899.springbootsandbox.domain.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import red.sukun1899.springbootsandbox.domain.service.RoomService
import java.time.LocalDate

/**
 * @author su-kun1899
 */
@Controller
@RequestMapping("rooms")
class RoomsController(private val roomService: RoomService) {
    @GetMapping
    fun listRooms(model: Model): String {
        val today = LocalDate.now()
        val rooms = roomService.findReservableRooms(today)
        model.addAttribute("date", today)
        model.addAttribute("rooms", rooms)
        return "room/listRooms"
    }
}