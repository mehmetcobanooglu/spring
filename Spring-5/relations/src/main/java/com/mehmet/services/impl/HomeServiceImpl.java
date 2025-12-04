package com.mehmet.services.impl;

import java.util.Optional;

import java.util.List;
import com.mehmet.entities.Room;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehmet.dto.DtoHome;
import com.mehmet.dto.DtoRoom;
import com.mehmet.entities.Home;
import com.mehmet.repository.HomeRepository;
import com.mehmet.services.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public DtoHome findHomeById(Long id) {

        DtoHome dtoHome = new DtoHome();
        Optional<Home> optional = homeRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Home dbHome = optional.get();
        List<Room> dbRooms = optional.get().getRoom();
        BeanUtils.copyProperties(dbHome, dtoHome);

        if (dbRooms != null && !dbRooms.isEmpty()) {
            for (Room room : dbRooms) {

                DtoRoom dtoRoom = new DtoRoom();
                BeanUtils.copyProperties(room, dtoRoom);
                dtoHome.getRooms().add(dtoRoom);
            }
        }
        return dtoHome;
    }

}
