import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {
    public static void main(String[] args) {
         
    }
    static int test() {
        int x = 1;
        try {
            return x;
        }
        finally {
            return x + 1;
        }
    }
}