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
public class MovieController {

    @GetMapping("/Movie/PopularMovies")
     public String getAllMovie() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/popular?api_key=0c0e7b2ac6b9afd4ee3aeb83a772ef7a&language=fr-FR")
                .build();

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

    @GetMapping("/Movie/TopRateMovies/{dayorweek}")
    public String getTopRateMovieByDayOrWeek(@PathVariable String dayorweek) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/trending/all/"+ dayorweek +"?api_key=0c0e7b2ac6b9afd4ee3aeb83a772ef7a&language=fr-FR")
                .build();

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
    @GetMapping("/Movie/Detailsmovie/{id}")
    public String getDetailsMovie(@PathVariable Number id) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/"+ id +"?api_key=0c0e7b2ac6b9afd4ee3aeb83a772ef7a&language=fr-FR")
                .build();

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
    @GetMapping("/Movie/DetailsActors/{id}")
    public String getDetailsActorMovie(@PathVariable Number id) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/"+ id +"/credits?api_key=0c0e7b2ac6b9afd4ee3aeb83a772ef7a&language=fr-FR")
                .build();

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
    @GetMapping("/Movie/DetailsTrailer/{id}")
    public String getDetailsTrailerMovie(@PathVariable Number id) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/"+ id +"/videos?api_key=0c0e7b2ac6b9afd4ee3aeb83a772ef7a&language=fr-FR")
                .build();

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
