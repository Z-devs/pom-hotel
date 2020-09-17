package com.pomhotel.booking.application.factories;

import com.pomhotel.booking.application.domain.entities.RoomtypesEntity;
import com.pomhotel.booking.application.models.RoomtypesModel;
import org.springframework.stereotype.Component;

@Component
public class RoomtypesFactory {
    public RoomtypesEntity createEntity(RoomtypesModel model){
        RoomtypesEntity entity = new RoomtypesEntity();
        entity.setId(model.id);
        entity.setName(model.name);
        entity.setDescription(model.description);
        entity.setPreferencesById(model.preferencesById);
        entity.setRoomsById(model.roomsById);
        return entity;
    }

    public RoomtypesModel createModel(RoomtypesEntity entity){
        RoomtypesModel model = new RoomtypesModel();
        model.id = entity.getId();
        model.name = entity.getName();
        model.description = entity.getDescription();
        model.preferencesById = entity.getPreferencesById();
        model.roomsById = entity.getRoomsById();
        return model;
    }
}
