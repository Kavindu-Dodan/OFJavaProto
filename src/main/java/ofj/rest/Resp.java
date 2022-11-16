package ofj.rest;

import dev.openfeature.contrib.providers.flagd.FlagdProvider;
import dev.openfeature.javasdk.Client;
import dev.openfeature.javasdk.OpenFeatureAPI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resp {

    @GetMapping("/test")
    public String test() {
        return makeResponse();
    }

    private static String makeResponse() {
        OpenFeatureAPI ofInstance = OpenFeatureAPI.getInstance();

        // NO OP
        //ofInstance.setProvider(new NoOpProvider());

        // Flag D
        FlagdProvider provider = new FlagdProvider();
        OpenFeatureAPI.getInstance().setProvider(provider);

        Client client = ofInstance.getClient();

        if (client.getBooleanValue("RSP", false)) {
            return "Welcome Home .!!";
        }else{
            return "Welcome home";
        }

    }
}
