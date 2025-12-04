package com.example.demo_ci_env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EnvController {

    private final Environment environment;

    @Value("${app.env-name:unknown}")
    private String envName;
    private String envold;

    public EnvController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/env")
    public String envInfo() {
        List<String> activeProfiles = Arrays.asList(environment.getActiveProfiles());
        return "Hello from environment: " + envName +
                " | activeProfiles=" + activeProfiles;
    }

    @GetMapping("/env")
    public String envdoor() {
        List<String> activeProfiles = Arrays.asList(environment.getActiveProfiles());
        return "Hello for learning " + envold +
                " | activeProfiles=" + activeProfiles;
    }
}
