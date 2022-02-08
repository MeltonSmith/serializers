import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.JavaSerializer;
import configuration.SpringConf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by: Ian_Rakhmatullin
 * Date: 07.02.2022
 */
@RunWith(SpringRunner.class)
@SpringJUnitConfig(SpringConf.class)
public class Tests {

    @Autowired
    private Kryo kryo;

    @Test
    public void testKryo() throws FileNotFoundException {
        Object someObject = "Some string";
        var output = new Output(new FileOutputStream("file.dat"));
        var input = new Input(new FileInputStream("file.dat"));


        kryo.writeClassAndObject(output, someObject);
        output.close();

        Object theObject = kryo.readClassAndObject(input);
        input.close();

        assertEquals(theObject, "Some string");
    }

    @Test
    public void serializeListWithKryo() throws FileNotFoundException {
        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(2);
        integers.add(2);
        integers.add(2);
        integers.add(2);
        integers.add(2);

        kryo.setRegistrationRequired(false);

        var output = new Output(new FileOutputStream("list.dat"));


        kryo.writeClassAndObject(output, integers);
        output.close();

    }
}
