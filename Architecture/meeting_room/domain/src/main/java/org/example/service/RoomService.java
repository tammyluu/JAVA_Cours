package org.example.service;

import org.example.entity.Room;
import org.example.port.IBaseRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class RoomService {
    private final IBaseRepository roomRepository;

    public RoomService(IBaseRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    public Room createRoom(String name, int capacity){
        if (name.length() < 3 && name.length() >50){
            throw  new RuntimeException("Title length must be between 3 and 50 char");
        }
        if (capacity <= 0 ){
            throw new IllegalArgumentException("Room capacity must be greater than zero.");
        }
        Room room = new Room.Builder()
                .name(name)
                .capacity(capacity)
                .build();
        roomRepository.create(room);
        return room;
    }
    public void deleteRoom(int id){
        Room room = roomRepository.findById(id).getRoom();
        if (room == null){
            throw new RuntimeException("Room not found");
        }
        roomRepository.delete(room);
    }
    public List<Room> searchRoom(String search){
        List<Room> list = roomRepository.findAll(search);
        return list;
    }
    public void updateRoom(int roomId, String name, LocalDate date, LocalTime hours, int capacity){
        Room existingRoom = roomRepository.findById(roomId).getRoom();
        if (existingRoom == null){
            throw new IllegalArgumentException("The room with the specified ID does not exist.");
        }
        if (capacity <= 0 ){
            throw new IllegalArgumentException("Room capacity must be greater than zero.");
        }
        if (date.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("The reservation date has already passed.");
        }
        existingRoom.setName(name);
        existingRoom.setCapacity(capacity);
        roomRepository.update(existingRoom);
    }

}
