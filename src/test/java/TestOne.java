//import com.bird.main.ChooseLevel;
import com.bird.main.ChooseLevel;
import com.bird.main.LastFifthRecord;
import org.junit.jupiter.api.Test;
import com.bird.dao.BTService;
import com.bird.dao.Bird_Time;

import java.util.List;

public class TestOne {
    @Test
    public void test(){
        new ChooseLevel().init();
        List all = new BTService().findAll();
        for (Object o : all) {
            System.out.println(o.getClass().getTypeName());
        }
        System.out.println(new BTService().findAll().toString());
    }
} 