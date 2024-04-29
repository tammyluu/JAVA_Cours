import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.entity.Room;
import org.example.port.IBaseRepository;
import org.example.service.RoomService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class RoomServiceStepDefinitions {
    private RoomService roomService;
    private IBaseRepository roomRepository;

    @Given("there are no rooms")
    public void thereAreNoRooms() {
        roomRepository = mock(IBaseRepository.class);
        roomService = new RoomService(roomRepository);
        //when(roomRepository.create(any(Room.class))).thenReturn(1); // Stubbing room creation
    }

    @When("a new room is created with name {string} and capacity {int}")
    public void aNewRoomIsCreatedWithNameAndCapacity(String name, int capacity) {
        roomService.createRoom(name, capacity);
    }

    @Then("the room should be created successfully")
    public void theRoomShouldBeCreatedSuccessfully() {
        Room expectedRoom = new Room.Builder().name("Conference Room").capacity(10).build();
        verify(roomRepository, times(1)).create(expectedRoom);
    }

    @Given("there is a room with ID {int}")
    public void thereIsARoomWithId(int roomId) {
        roomRepository = mock(IBaseRepository.class);
        roomService = new RoomService(roomRepository);
        Room existingRoom = new Room.Builder().id(roomId).name("Existing Room").capacity(10).build();
      //  when(roomRepository.findById(roomId)).thenReturn(existingRoom); // Stubbing room existence
    }

    @When("I delete the room with ID {int}")
    public void iDeleteTheRoomWithId(int roomId) {
        roomService.deleteRoom(roomId);
    }

    @Then("the room should be deleted successfully")
    public void theRoomShouldBeDeletedSuccessfully() {
        verify(roomRepository, times(1)).delete(any(Room.class));
    }
}

