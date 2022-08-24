import com.lay.springcloud.entity.Payment;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author Dragon code!
 * @create 2022-07-15 23:57
 */
public class MyTest {

    @Test
    public void Test1() {
        String a = new String("a");
        a.intern();
        String b = "a";
        System.out.println(a == b);//false
    }


    @Test
    public void Test2() {
        String a = new String("a") + new String("b");
//        a.intern();
        String b = "ab";
        System.out.println(a == b);	//true
    }


}
