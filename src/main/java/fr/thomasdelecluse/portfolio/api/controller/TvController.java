package fr.thomasdelecluse.portfolio.api.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin
public class TvController {
    OkHttpClient client = new OkHttpClient();

    @GetMapping("/Tv/Details/{id}")
    public String getDetailsTv(@PathVariable Number id) {

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/tv/" + id + "?api_key=0c0e7b2ac6b9afd4ee3aeb83a772ef7a&language=fr-FR")
                .build();

        return requestExecute(request);
    }

    @GetMapping("/Tv/DetailsActors/{id}")
    public String getDetailsActorTV(@PathVariable Number id) {

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/tv/" + id + "/credits?api_key=0c0e7b2ac6b9afd4ee3aeb83a772ef7a&language=fr-FR")
                .build();

        return requestExecute(request);
    }

    public String requestExecute(Request request) {
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
