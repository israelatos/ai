package org.ai.SpeechRecognition;


import com.google.cloud.speech.v1p1beta1.*;
import com.google.protobuf.ByteString;
import org.springframework.stereotype.Service;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class SpeechRecognitionService {

    public String recognizeSpeech(byte[] audioData) throws Exception {
        try (SpeechClient speechClient = SpeechClient.create()) {
            ByteString audioBytes = ByteString.copyFrom(audioData);

            RecognitionConfig config = RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                    .setSampleRateHertz(16000)
                    .setLanguageCode("en-US")
                    .build();

            RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();

            RecognizeResponse response = speechClient.recognize(config, audio);

            List<SpeechRecognitionResult> results = response.getResultsList();
            StringBuilder recognizedText = new StringBuilder();

            for (SpeechRecognitionResult result : results) {
                recognizedText.append(result.getAlternatives(0).getTranscript());
            }

            return recognizedText.toString();
        }
    }
}

