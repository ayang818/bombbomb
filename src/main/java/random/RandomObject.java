package random;

import com.alibaba.fastjson.JSON;
import dto.JsonDTO;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @ClassName RandomObject
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/11/7 20:33
 **/
public class RandomObject {
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static JsonDTO getRandomObject() {
        JsonDTO jsonDTO = new JsonDTO();
        jsonDTO.setUser(RANDOM.ints().toString());
        jsonDTO.setPass(RANDOM.ints().toString());
        return jsonDTO;
    }
}
