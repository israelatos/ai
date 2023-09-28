package org.ai.NaturalLanguageProcessing_NLP;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.InputStream;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

public class NLPServiceTest {

    @Mock
    private TokenNameFinderModel tokenNameFinderModel;

    @Mock
    private NameFinderME nameFinderME;

    private NLPService nlpService;

    @Before
    public void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
        nlpService = new NLPService();

        // Mock the behavior of model loading
        InputStream modelIn = getClass().getResourceAsStream("/en-ner-person.bin");
        when(tokenNameFinderModel.getInputStream()).thenReturn(modelIn);
        when(new TokenNameFinderModel(modelIn)).thenReturn(tokenNameFinderModel);
        when(new NameFinderME(tokenNameFinderModel)).thenReturn(nameFinderME);
        when(nameFinderME.find(any())).thenReturn(new Span[] { new Span(0, 1) });
    }

    @Test
    public void testProcessPersonNames() {
        String inputText = "John and Mary are friends.";

        // Mock the model loading behavior

        // Call the method to test
        String result = nlpService.processPersonNames(inputText);

        // Verify the result
        assertEquals("John \n", result);
    }
}
