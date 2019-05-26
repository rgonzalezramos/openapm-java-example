package rob.openapmjavaexample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Endpoints {
    @RequestMapping(value = "/fast", method = RequestMethod.GET, produces = "text/plain")
    public @ResponseBody String fast() {
        return "Hello";
    }

    @RequestMapping(value = "/slow", method = RequestMethod.GET, produces = "text/plain")
    public @ResponseBody String slow() throws InterruptedException {
        Thread.sleep(1000);
        return "Hello";
    }
}
