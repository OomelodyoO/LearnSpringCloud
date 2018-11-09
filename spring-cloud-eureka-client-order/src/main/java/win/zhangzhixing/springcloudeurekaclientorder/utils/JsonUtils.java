package win.zhangzhixing.springcloudeurekaclientorder.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtils {
    private static final ObjectMapper objectMapper=new ObjectMapper();

    public static JsonNode str2JsonNod(String str){
        try {
            return objectMapper.readTree(str);
        } catch (IOException e) {
            return null;
        }
    }
}
