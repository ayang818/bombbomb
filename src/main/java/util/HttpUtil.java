package util;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpUtil {
    private static  final OkHttpClient CLIENT = new OkHttpClient();
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);

    public static Response post(String url, Object body) {
        MediaType jsonType = MediaType.get("application/json");
        RequestBody requestBody = RequestBody.create(jsonType, com.alibaba.fastjson.JSON.toJSONString(body));
        Request request = new Request.Builder().url(url).post(requestBody).build();
        try (Response response = CLIENT.newCall(request).execute()) {
            LOGGER.info("bomb success");
            return  response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Response get(String url) {
        Request request = new Request.Builder().url(url).get().build();
        try (Response response = CLIENT.newCall(request).execute()) {
            LOGGER.info("bomb fail");
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
