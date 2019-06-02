package com.apps.dashboard.controller;

import com.apps.dashboard.model.AppModel;
import com.apps.dashboard.service.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/dashboard")
public class DashBoardController {

    @Autowired
    FileReader fileReader;

    @GetMapping(value = "/loaddetails")
    public List<AppModel> loadDashBoard() {
        return fileReader.getAppDetails();
    }
}


