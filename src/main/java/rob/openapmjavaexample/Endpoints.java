package rob.openapmjavaexample;

import co.elastic.apm.api.ElasticApm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class Endpoints {
    private Random random = new Random();
    private static final Logger logger = LoggerFactory.getLogger(Endpoints.class);

    @RequestMapping(value = "/fast", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String fast() {
        ElasticApm.currentTransaction().setUser(null, "user@userland.com", null);
        return "Hello";
    }

    @RequestMapping(value = "/slow", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String slow() throws InterruptedException {
        someSlowWork();
        moreSlowWork();
        return "Hello";
    }

    @RequestMapping(value = "/crash", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String error() {
        logger.info("I'm about to craaaashh...");
        if (1 == 1) {
            throw new RuntimeException("The error!");
        }
        return "Hello";
    }

    private void someSlowWork() throws InterruptedException {
        Thread.sleep(900 + random.nextInt(200));
    }

    private void moreSlowWork() throws InterruptedException {
        Thread.sleep(450 + random.nextInt(100));
    }
}
