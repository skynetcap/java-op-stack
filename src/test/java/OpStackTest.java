import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class OpStackTest {

    @Test
    public void opStackTest() {
        String endpoint = "https://goerli.optimism.io";
        OptimismClient client = new OptimismClient(endpoint);
        log.info("Client endpoint = " + client.getEndpoint());

        client.optimismVersion();
    }

}
