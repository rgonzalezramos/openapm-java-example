package rob.openapmjavaexample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class Endpoints {
    private Random random = new Random();

    @RequestMapping(value = "/fast", method = RequestMethod.GET, produces = "text/plain")
    public @ResponseBody String fast() {
        return "Hello";
    }

    @RequestMapping(value = "/slow", method = RequestMethod.GET, produces = "text/plain")
    public @ResponseBody String slow() throws InterruptedException {
        someSlowWork();
        moreSlowWork();
        return "Hello";
    }

    private void someSlowWork() throws InterruptedException {
        Thread.sleep(900 + random.nextInt(200));
    }

    private void moreSlowWork() throws InterruptedException {
        Thread.sleep(450 + random.nextInt(100));
    }
}
