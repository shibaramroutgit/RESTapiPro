package org.example.jsondatabindtest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;

/**
 * https://jsoneditoronline.org/indepth/datasets/json-file-example/
 */
public class ReaderClassByJson
{
    public void readJsonObject() throws IOException {
        File file = new File("src\\test\\java\\org\\example\\jsonfiles\\jsonobject.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(file);
        System.out.println(jsonNode.get("name").asText());
        System.out.println(jsonNode.get("age").asInt());
        System.out.println(jsonNode.get("city").asText());
    }

    public void readJsonArray() throws IOException {
        File file = new File("src\\test\\java\\org\\example\\jsonfiles\\jsonarray.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(file);
        ArrayNode arrayNode = (ArrayNode) jsonNode.get("books");
        for (JsonNode j:arrayNode) {
            System.out.println(j.get("title"));
            System.out.println(j.get("isbn"));
        }
    }

    public void readNestedJson() throws IOException {
        File file = new File("src\\test\\java\\org\\example\\jsonfiles\\nestedjson.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode= objectMapper.readTree(file);
        System.out.println(jsonNode.get("Region").asText());
        ArrayNode arrayNodeCountries = (ArrayNode) jsonNode.get("Countries");
        for (JsonNode j:arrayNodeCountries) {
            JsonNode k = j.get("Data");
            System.out.println(k.get("Capital"));
        }
    }

    public void readArrayOfArrayJson() throws IOException {
        File file = new File("src\\test\\java\\org\\example\\jsonfiles\\arrayofaray.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode= objectMapper.readTree(file);
        ArrayNode arrayNodeUser = (ArrayNode) jsonNode;
        for (JsonNode j:arrayNodeUser) {
            //System.out.println(j.get("city"));
            ArrayNode arrayNodeFriends = (ArrayNode) j.get("friends");
            for (JsonNode k:arrayNodeFriends) {
                //System.out.println(k.get("name"));
                ArrayNode arrayNodehobbies = (ArrayNode) k.get("hobbies");
                for (JsonNode l:arrayNodehobbies) {
                    System.out.println(l.toString());
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {

        ReaderClassByJson readerClassByJson = new ReaderClassByJson();
        //readerClassByJson.readJsonObject();
        //readerClassByJson.readJsonArray();
        //readerClassByJson.readNestedJson();
        readerClassByJson.readArrayOfArrayJson();



    }
}
