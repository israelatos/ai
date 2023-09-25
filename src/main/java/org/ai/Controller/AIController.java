package org.ai.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/ai")
public class AIController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, I'm your AI assistant!";
    }

    // Add more endpoints and logic here as your app evolves.
}

