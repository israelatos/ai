package org.ai.NaturalLanguageProcessing_NLP;


import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class NLPService {

    public String processText(String text) {
        try {
            // Load the model (you need to download and place the model file in your project)
            InputStream modelIn = new FileInputStream("models/en-ner-person.bin");
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

