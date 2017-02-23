package ru.tandser.polling.web.json;

import java.io.File;
import java.util.List;

public class JsonConverter {

    private JsonConverter() {}

    public static String toJson(Object obj) {
        try {
            return JacksonObjectMapper.getInstance().writer().writeValueAsString(obj);
        } catch (Exception exc) {
            throw new IllegalStateException(exc);
        }
    }

    public static <T> T fromJson(String source, Class<T> type) {
        try {
            return JacksonObjectMapper.getInstance().readerFor(type).readValue(source);
        } catch (Exception exc) {
            throw new IllegalArgumentException(exc);
        }
    }

    public static <T> T fromJson(File source, Class<T> type) {
        try {
            return JacksonObjectMapper.getInstance().readerFor(type).readValue(source);
        } catch (Exception exc) {
            throw new IllegalArgumentException(exc);
        }
    }

    public static <T> List<T> fromJsonToList(String source, Class<T> type) {
        try {
            return JacksonObjectMapper.getInstance().readerFor(type).<T>readValues(source).readAll();
        } catch (Exception exc) {
            throw new IllegalArgumentException(exc);
        }
    }

    public static <T> List<T> fromJsonToList(File source, Class<T> type) {
        try {
            return JacksonObjectMapper.getInstance().readerFor(type).<T>readValues(source).readAll();
        } catch (Exception exc) {
            throw new IllegalArgumentException(exc);
        }
    }
}