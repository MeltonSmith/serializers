package configuration;

import com.esotericsoftware.kryo.Kryo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by: Ian_Rakhmatullin
 * Date: 07.02.2022
 *
 * TODO add beans for ProtoBuff and others.
 */
@org.springframework.context.annotation.Configuration
@ComponentScan
public class SpringConf {

    /**
     * Bean for Kryo object needed for serialization
     */
    @Bean
    public static Kryo kryo(){
        return new Kryo();
    }
}
