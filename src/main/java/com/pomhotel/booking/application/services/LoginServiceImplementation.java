package com.pomhotel.booking.application.services;

import com.pomhotel.booking.application.domain.entities.ClientsEntity;
import com.pomhotel.booking.application.domain.entities.LoginsEntity;
import com.pomhotel.booking.application.factories.ClientsFactory;
import com.pomhotel.booking.application.factories.LoginsFactory;
import com.pomhotel.booking.application.models.ClientsModel;
import com.pomhotel.booking.application.models.LoginsModel;
import com.pomhotel.booking.application.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplementation implements LoginService{

    LoginRepository loginRepository;
    LoginsFactory loginsFactory;
    ClientsFactory clientsFactory;

    @Autowired
    public LoginServiceImplementation(LoginRepository loginRepository, LoginsFactory loginsFactory, ClientsFactory clientsFactory) {
        this.loginRepository = loginRepository;
        this.loginsFactory = loginsFactory;
        this.clientsFactory = clientsFactory;
    }

    @Override
    public ClientsModel authentification (LoginsModel model) {
        ClientsModel clientsModel;

        LoginsEntity loginsEntity = loginsFactory.createEntity(model);
        ClientsEntity clientsEntity = loginRepository.authentification(loginsEntity);

        if (clientsEntity != null){
            clientsModel = clientsFactory.createModel(clientsEntity);
        }
        else{
            clientsModel = null;
        }

        return clientsModel;
    }
}
