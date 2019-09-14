package OkHttpClient;

import OkHttpClient.Utils.ExecuteRequest;
import OkHttpClient.exceptions.BadRequestException;
import OkHttpClient.exceptions.NotFoundException;
import OkHttpClient.exceptions.AuthorizationException;
import OkHttpClient.exceptions.ServiceConditionException;
import OkHttpClient.exceptions.SystemException;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import java.io.IOException;
import java.util.Map;

import static OkHttpClient.Contants.AppConstant.URL;
import static OkHttpClient.Contants.AppConstant.HEADER_BUILDER;
import static OkHttpClient.Contants.AppConstant.REQUEST_BODY;

public class ApiClient implements HttpClient {

    ExecuteRequest executeRequest = new ExecuteRequest();

    @Override
    public Map<String, Object> getRequest(String connectionUrl, Map<String, Object> queryParams,
                                          Map<String, String> headers, boolean async) throws BadRequestException,
            NotFoundException, AuthorizationException, ServiceConditionException, SystemException, IOException {

        Map<String, Object> params = executeRequest.setQueryParams(connectionUrl, queryParams, headers);
        Request request = new Request.Builder()
                .url((String) params.get(URL))
                .headers((Headers) params.get(HEADER_BUILDER))
                .build();

        return executeRequest.getResponseMapByHttpRequestExecute(request);

    }


    public Map<String, Object> postRequest(String connectionUrl, Map<String, Object> postParams,
                                           Map<String, String> headers, boolean async) throws BadRequestException,
            NotFoundException, AuthorizationException, ServiceConditionException, SystemException, IOException {

        Map<String, Object> params = executeRequest.setParamsAndHeaders(postParams, headers);
        Request request = new Request.Builder()
                .url(connectionUrl)
                .headers((Headers) params.get(HEADER_BUILDER))
                .post((RequestBody) params.get(REQUEST_BODY))
                .build();

        return executeRequest.getResponseMapByHttpRequestExecute(request);

    }


    public Map<String, Object> putRequest(String connectionUrl, Map<String, Object> putParams,
                                          Map<String, String> headers, boolean async) throws BadRequestException,
            NotFoundException, AuthorizationException, ServiceConditionException, SystemException, IOException {

        Map<String, Object> params = executeRequest.setParamsAndHeaders(putParams, headers);
        Request request = new Request.Builder()
                .url(connectionUrl)
                .headers((Headers) params.get(HEADER_BUILDER))
                .put((RequestBody) params.get(REQUEST_BODY))
                .build();

        return executeRequest.getResponseMapByHttpRequestExecute(request);

    }

    public Map<String, Object> deleteRequest(String connectionUrl) throws BadRequestException,
            NotFoundException, AuthorizationException, ServiceConditionException, SystemException, IOException {
        Request request = new Request.Builder().url(connectionUrl).delete().build();
        return executeRequest.getResponseMapByHttpRequestExecute(request);
    }

}
