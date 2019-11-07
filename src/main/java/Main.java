import executor.ExecutorPool;
import random.RandomObject;
import util.HttpUtil;

public class Main {
    public static void main(String[] args) {
        String url = "http://119.28.227.179/2018.php";
        Runnable runnable = () -> HttpUtil.post(url, RandomObject.getRandomObject());
        while (true) {
            ExecutorPool.execute(runnable);
        }
    }
}
