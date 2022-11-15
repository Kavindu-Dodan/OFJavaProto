package ofj.rest;


import dev.openfeature.javasdk.Client;
import dev.openfeature.javasdk.NoOpProvider;
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
        ofInstance.setProvider(new NoOpProvider());

        Client client = ofInstance.getClient();

        client.getStringDetails()

        return client.getStringValue("RSP", "Hello <>");
    }
}
