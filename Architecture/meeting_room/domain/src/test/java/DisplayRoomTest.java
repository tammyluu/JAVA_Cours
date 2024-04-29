import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.entity.Room;
import org.example.port.IBaseRepository;
import org.example.service.RoomService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DisplayRoomTest {
    private RoomService roomService;
    private Room room;
    private IBaseRepository roomRepository;
    private List<Room> resultSearch;
    public DisplayRoomTest(){
        roomRepository = Mockito.mock(IBaseRepository.class);
        roomService = new RoomService(roomRepository);
        room = new Room.Builder()
                .name("Citer d'or")
                .capacity(200).build();

    }


    @Given(": There are some rooms")
    public void there_are_some_rooms() {
      Mockito.doAnswer(invocationOnMock -> {
          Room room1 = invocationOnMock.getArgument(0);
          room1.setId(1);
          return null;
      }).when(roomRepository).create(room);
      roomService.createRoom("Grand Palais", 200);
    }
    @When(": I search a room by id")
    public void i_search_a_room_by_id(String search) {
        Mockito.when(roomRepository.findAll(search)).thenReturn(List.of(room));
        resultSearch = roomService.searchRoom(search);
    }
    @Then(": This room will be shown")
    public void this_room_will_be_shown(int id) {
        Assertions.assertTrue(resultSearch.stream().anyMatch(room -> room.getId() == id));;
    }
}
