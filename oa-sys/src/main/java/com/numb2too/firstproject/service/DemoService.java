package com.numb2too.firstproject.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public String getIdAndName(Long id, String name) {
        return "id: " + id + ", name: " + name;
    }

}
