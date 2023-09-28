package org.ai.Controller;

import org.ai.NaturalLanguageProcessing_NLP.NLPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ai")
public class AIController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, I'm your AI assistant!";
    }

    @Autowired
    private NLPService nlpService;

    @PostMapping("/process-text")
    public ResponseEntity<String> processText(@RequestBody String text) {
        String result = nlpService.processText(text);
        return ResponseEntity.ok(result);
    }

    // Add more endpoints and logic here as your app evolves.
}

