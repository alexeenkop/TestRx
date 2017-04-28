package palexp.cn.ua.testrx;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import palexp.cn.ua.testrx.http.AllSectorsResponse;
import palexp.cn.ua.testrx.http.ApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
    }

    ProgressDialog progressDialog;

    public void onBtnTimer(View view) {
        Observable.just(0)
                  .delay(3, TimeUnit.SECONDS)
                  .doOnSubscribe(disposable -> progressDialog.show())
                  .doOnComplete(() -> progressDialog.dismiss())
                  .subscribeOn(AndroidSchedulers.mainThread())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe();
    }

    public void onBtnRequest(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://aviationconnect.com/api/v1/")
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Observable<AllSectorsResponse> responseObservable = apiService.allSectors();
        responseObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(allSectorsResponse -> {
                    Toast.makeText(this, "Request Success!", Toast.LENGTH_SHORT).show();
                    if (allSectorsResponse.getError() == null)
                        Toast.makeText(this, "First item name: " + allSectorsResponse.getData().get(0).getName(), Toast.LENGTH_SHORT)
                             .show();
                    else
                        Toast.makeText(this, allSectorsResponse.getError().getMessage(), Toast.LENGTH_SHORT).show();
                }, throwable -> {
                    throwable.fillInStackTrace();
                    Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}
