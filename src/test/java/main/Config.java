package main;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ImportResource("classpath:application-build.xml")
@ComponentScan(basePackages = { "see" })
@PropertySource("classpath:config/conf.properties")
public class Config implements EnvironmentAware{
    private Environment env;
    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }
    public String getProperty(String key){
        return env.getProperty(key);
    }
}

