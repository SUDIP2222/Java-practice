package OkHttpClient.Utils;

import OkHttpClient.Exceptions.BadRequestException;
import OkHttpClient.Exceptions.NotFoundException;
import OkHttpClient.Exceptions.AuthorizationException;
import OkHttpClient.Exceptions.ServiceConditionException;
import OkHttpClient.Exceptions.SystemException;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.*;
import org.apache.commons.collections4.MapUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import static OkHttpClient.Contants.AppConstant.URL;
import static OkHttpClient.Contants.AppConstant.HEADER_BUILDER;
import static OkHttpClient.Contants.AppConstant.REQUEST_BODY;
import static OkHttpClient.Utils.StringUtils.nullToBlank;

public class ExecuteRequest {

    Gson gson = new Gson();
    private OkHttpClient okHttpClient = new OkHttpClient();
    public final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public Map<String, Object> setQueryParams(String connectionUrl, Map<String, Object> queryParams, Map<String, String> headers) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(connectionUrl).newBuilder();

        if (MapUtils.isNotEmpty(queryParams)) {
            queryParams.forEach((paramKey, paramValue) -> urlBuilder.addQueryParameter(paramKey, paramValue.toString()));
        }
        String url = urlBuilder.build().toString();
        headers = MapUtils.emptyIfNull(headers);
        Headers headerBuilder = Headers.of(headers);

        ImmutableMap<String, Object> urlAndHeaders = ImmutableMap.of(URL, url,
                HEADER_BUILDER, headerBuilder);
        return urlAndHeaders;
    }

    public Map<String, Object> setParamsAndHeaders(Map<String, Object> params, Map<String, String> headers) {

        params = MapUtils.emptyIfNull(params);
        RequestBody requestBody = RequestBody.create(JSON, gson.toJson(params));
        headers = MapUtils.emptyIfNull(headers);
        Headers headerBuilder = Headers.of(headers);

        ImmutableMap<String, Object> paramsAndHeaders = ImmutableMap.of(REQUEST_BODY, requestBody,
                HEADER_BUILDER, headerBuilder);
        return paramsAndHeaders;
    }

    public Map<String, Object> getResponseMapByHttpRequestExecute(Request request) throws BadRequestException,
            NotFoundException, AuthorizationException, ServiceConditionException, SystemException, IOException {

        Call call = okHttpClient.newCall(request);
        Response response = call.execute();

        if (response != null) {
            String responseString = response.body().string();
            return processResponse(response.code(), nullToBlank(responseString));
        }

        return Collections.emptyMap();

    }

    private Map<String, Object> processResponse(int statusCode, String response) throws BadRequestException,
            NotFoundException, AuthorizationException, ServiceConditionException, SystemException {

        Map<String, Object> processedResponse = gson.fromJson(response, new TypeToken<Map<String, Object>>() {
        }.getType());

        switch (statusCode) {
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
            case 205:
            case 206:
            case 207:
            case 208:
            case 226:
                return processedResponse;
            case 400:
                throw new BadRequestException(processErrorResponse(processedResponse));
            case 401:
                throw new AuthorizationException(processErrorResponse(processedResponse));
            case 404:
                throw new NotFoundException(processErrorResponse(processedResponse));
            case 500:
                throw new SystemException(processErrorResponse(processedResponse));
            case 503:
                throw new ServiceConditionException(processErrorResponse(processedResponse));
            default:
                throw new SystemException(processErrorResponse(processedResponse));
        }
    }

    private Object processErrorResponse(Map<String, Object> response) {
        return response.toString();
    }
}
