package palexp.cn.ua.testrx.http;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by pALEXp on 28.04.2017.
 */
public interface ApiService {

    @GET("sector/allsectors")
    Observable<AllSectorsResponse> allSectors();

}