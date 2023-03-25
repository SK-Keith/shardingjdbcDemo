package com.atguigu.shardingjdbcdemo;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class PropertiesToYamlConverter {

    public static void main(String[] args) {
        String inputFilePath = "/path/to/application.properties";
        String outputFilePath = "/path/to/application.yml";
        PropertiesToYamlConverter converter = new PropertiesToYamlConverter();
        try {
            converter.convertPropertiesToYaml(inputFilePath, outputFilePath);
            System.out.println("Successfully converted properties to YAML.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to convert properties to YAML.");
        }
    }

    public void convertPropertiesToYaml(String inputFilePath, String outputFilePath) throws IOException {
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Map<?, ?> map = mapper.readValue(inputFile, Map.class);
        mapper.writeValue(outputFile, map);
    }
}
