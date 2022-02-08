import configuration.SpringConf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by: Ian_Rakhmatullin
 * Date: 07.02.2022
 */
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(SpringConf.class);

    }
}
