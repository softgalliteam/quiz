package a99000587.test.retrofit;

/**
 * Created by Shankar on 1/27/2018.
 */

public interface DownlodableCallback<T>  {
    void onSuccess(T result);

    void onFailure(String error);
    void onUnauthorized(int errorNumber);
}
