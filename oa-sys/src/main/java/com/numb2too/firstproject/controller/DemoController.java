package com.numb2too.firstproject.controller;

import com.numb2too.firstproject.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService){
        this.demoService = demoService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/getIdAndNameByPathVariable/{id}/{name}")
    public String getIdAndNameByPathVariable(@PathVariable Long id, @PathVariable String name) {
        return demoService.getIdAndName(id, name);
    }

    @GetMapping("/getIdAndNameByRequestParam")
    public String getIdAndNameByRequestParam(@RequestParam Long id, @RequestParam String name){
        return demoService.getIdAndName(id, name);
    }

    @PostMapping("/getIdAndNameByRequestBody")
    public String getIdAndNameByRequestBody(@RequestBody Map<String,Object> requestBody) {
        Long id = requestBody.get("id") instanceof Number number
                ? number.longValue()
                : null;
        String name = (String) requestBody.get("name");
        if (id == null || name == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        return demoService.getIdAndName(id, name);
    }

}
