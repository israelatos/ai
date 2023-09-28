package org.ai.Controller;

import org.ai.NaturalLanguageProcessing_NLP.NLPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ai")
public class AIController {

    @Autowired
    private NLPService nlpService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, I'm your AI assistant!";
    }

    @PostMapping("/process-text")
    public ResponseEntity<String> processText(@RequestBody Map<String, String> request) {
        String text = request.get("text");
        String modelName = request.get("modelName");

        if (text == null || modelName == null || !isValidModel(modelName)) {
            return ResponseEntity.badRequest().body("Invalid request. Please provide a valid modelName.");
        }

        String result;

        switch (modelName.toLowerCase()) {
            case "person":
                result = nlpService.processPersonNames(text);
                break;
            case "date":
                result = nlpService.processDates(text);
                break;
            case "location":
                result = nlpService.processLocations(text);
                break;
            case "money":
                result = nlpService.processMoneyAmounts(text);
                break;
            case "organization":
                result = nlpService.processOrganizations(text);
                break;
            case "percentage":
                result = nlpService.processPercentages(text);
                break;
            case "time":
                result = nlpService.processTimes(text);
                break;
            default:
                return ResponseEntity.badRequest().body("Invalid 'modelName'. Supported models: person, date, location, money, organization, percentage, time.");
        }

        return ResponseEntity.ok(result);
    }

    private boolean isValidModel(String modelName) {
        // Check if modelName is valid based on your criteria.
        // You can implement this validation as needed.
        return true; // Modify this based on your validation logic.
    }

    // Add more endpoints and logic here as your app evolves.
}
