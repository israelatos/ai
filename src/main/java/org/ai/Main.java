package org.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws IOException {
        // Set the path to your JSON key file
        String keyFilePath = "israelatos-ai-ccdb9efabda9.json";

        // Load the JSON key file
        Resource resource = new ClassPathResource(keyFilePath);

        // Set the GOOGLE_APPLICATION_CREDENTIALS environment variable programmatically
        System.setProperty("GOOGLE_APPLICATION_CREDENTIALS", resource.getFile().getAbsolutePath());

        // Run your Spring Boot application
        SpringApplication.run(Main.class, args);
        ;
    }
}

