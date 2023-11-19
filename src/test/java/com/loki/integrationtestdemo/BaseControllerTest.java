package com.loki.integrationtestdemo;

import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.testcontainers.shaded.org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class BaseControllerTest {

    public static String APPLICATION_JSON = "application/json";

    public String loadFile(String jsonFile) throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = FileUtils.toFile(classLoader.getResource(jsonFile));
        assert file != null;
        return FileUtils.readFileToString(file, "UTF-8");
    }


    public RequestPostProcessor postHeaders() {

        return request -> {
            request.addHeader("Accept", APPLICATION_JSON);
            request.addHeader("Content-Type", APPLICATION_JSON);
            return request;
        };
    }

    public RequestPostProcessor getHeaders() {
        return request -> {
            request.addHeader("Accept", APPLICATION_JSON);
            return request;
        };
    }
}
