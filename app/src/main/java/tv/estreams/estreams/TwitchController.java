package tv.estreams.estreams;

import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.ArrayList;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;
import tv.estreams.estreams.json.Stream;
import tv.estreams.estreams.json.Streams;

/**
 * Created by Alejandro on 15/12/2015.
 */
interface TwitchService {

    @GET("streams")
    Call<Streams> games(
            @Query("game") String game);
}

public class TwitchController extends AsyncTask {

    //Atributos necesarios para este objeto
    private final TwitchService service;
    private String game = "League%20of%20Legends";
    private final String TWITCH_BASE_URL = "https://api.twitch.tv/kraken/";
    private final Context context;



    //Objeto que nos crea el retrofit con la URL base y llama al a interfaz para rellenar con las preferencias deseadas.
    public TwitchController(final Context context) {
        this.context = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TWITCH_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(TwitchService.class);
    }

    public void updatePeliculasDB() {
        execute();
    }

    @Override
    protected Object doInBackground(Object[] params) {
        int page = (Integer) params[0];
        Call<Streams> callTwitch = service.games(game);

        try {

            Response<Streams> responseTwitch = callTwitch.execute();
            ArrayList<String> peliculasStrings = new ArrayList<>();

            if (responseTwitch.isSuccess()) {
                Streams results = responseTwitch.body();

                for (Stream result : results.getStreams()) {

                }
            }
            else
            {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}