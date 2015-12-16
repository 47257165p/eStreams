package tv.estreams.estreams;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;
import tv.estreams.estreams.json.Streams;

public interface TwitchService {

    @GET("streams")
    Call<Streams> games(
            @Query("game") String game);
}
