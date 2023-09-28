package org.ai.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "nlp.models")
public class NLPModelsConfig {
    private Map<String, String> paths = new HashMap<>();

    public Map<String, String> getPaths() {
        return paths;
    }

    public void setPaths(Map<String, String> paths) {
        this.paths = paths;
    }
}
