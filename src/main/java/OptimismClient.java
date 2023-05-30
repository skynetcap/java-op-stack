import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class OptimismClient {

    private final String endpoint;
    private final OkHttpClient client;

    public OptimismClient(String endpoint) {
        this.endpoint = endpoint;
        this.client = new OkHttpClient.Builder().build();
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String optimismVersion() {
        String json = "{\"jsonrpc\":\"2.0\",\"method\":\"optimism_outputAtBlock\",\"params\":[],\"id\":1}";
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
        Request request = new Request.Builder()
                .url(endpoint)
                .post(body)
                .build();

        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println("RESPONSE: " + response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
