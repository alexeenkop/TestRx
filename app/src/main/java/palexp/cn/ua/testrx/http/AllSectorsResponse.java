package palexp.cn.ua.testrx.http;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by pALEXp on 28.04.2017.
 */

public class AllSectorsResponse {

    private ArrayList<Sector> data;
    private boolean success = false;
    private Error error;
    @SerializedName("status_code")
    private String statusCode = "";

    public AllSectorsResponse() {
    }

    public AllSectorsResponse(ArrayList<Sector> data, boolean success, Error error, String statusCode) {
        this.data = data;
        this.success = success;
        this.error = error;
        this.statusCode = statusCode;
    }

    public ArrayList<Sector> getData() {
        return data;
    }

    public void setData(ArrayList<Sector> data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
