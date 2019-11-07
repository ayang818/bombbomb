package util;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class HttpUtil {
    private static final OkHttpClient CLIENT;
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);

    static  {
        CLIENT = new OkHttpClient.Builder().connectTimeout(3, TimeUnit.SECONDS).readTimeout(5, TimeUnit.SECONDS).build();;
    }
    private static AtomicInteger times = new AtomicInteger();

    public static Response post(String url, Object body) {
        MediaType jsonType = MediaType.get("application/json");
        RequestBody requestBody = RequestBody.create(jsonType, JSON.toJSONString(body));
        Request request = new Request.Builder().url(url).post(requestBody).build();
        try (Response response = CLIENT.newCall(request).execute()) {
            times.incrementAndGet();
            LOGGER.info("bomb success {}", times);
            return response;
        } catch (IOException e) {
            LOGGER.info("server bombed!");
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
