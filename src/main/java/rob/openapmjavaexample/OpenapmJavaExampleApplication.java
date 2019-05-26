package rob.openapmjavaexample;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpenapmJavaExampleApplication {

    public static void main(String[] args) {
        ElasticApmAttacher.attach();
        SpringApplication.run(OpenapmJavaExampleApplication.class, args);
    }

}
