package org.ai.NaturalLanguageProcessing_NLP;



import org.ai.config.NLPModelsConfig;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class NLPService {


    public String processPersonNames(String text) {
        // Implement named entity recognition for person names here.
        // Return the result as a string.
        return "Processed person names: " + text;
    }

    public String processDates(String text) {
        // Implement date recognition here.
        // Return the result as a string.
        return "Processed dates: " + text;
    }

    public String processLocations(String text) {
        // Implement location recognition here.
        // Return the result as a string.
        return "Processed locations: " + text;
    }

    public String processMoneyAmounts(String text) {
        // Implement recognition of money amounts here.
        // Return the result as a string.
        return "Processed money amounts: " + text;
    }

    public String processOrganizations(String text) {
        // Implement recognition of organizations here.
        // Return the result as a string.
        return "Processed organizations: " + text;
    }

    public String processPercentages(String text) {
        // Implement recognition of percentages here.
        // Return the result as a string.
        return "Processed percentages: " + text;
    }

    public String processTimes(String text) {
        // Implement recognition of times here.
        // Return the result as a string.
        return "Processed times: " + text;
    }
    @Autowired
    private NLPModelsConfig nlpModelsConfig;

    public String processText(String text, String modelName) {
        try {
            // Load the model based on the provided model name
            String modelPath = nlpModelsConfig.getPaths().get(modelName);
            if (modelPath == null) {
                return "Model not found for the specified task.";
            }

            InputStream modelIn = new FileInputStream(modelPath);
            TokenNameFinderModel model = new TokenNameFinderModel(modelIn);
            NameFinderME nameFinder = new NameFinderME(model);

            // Tokenize the input text
            String[] tokens = text.split("\\s+");

            // Find names (you can customize this for your specific NLP task)
            Span[] nameSpans = nameFinder.find(tokens);

            // Build the result
            StringBuilder result = new StringBuilder();
            for (Span span : nameSpans) {
                for (int i = span.getStart(); i < span.getEnd(); i++) {
                    result.append(tokens[i]).append(" ");
                }
                result.append("\n");
            }

            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error processing text: " + e.getMessage();
        }
    }
}

