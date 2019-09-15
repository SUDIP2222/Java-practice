package OkHttpClient;

import OkHttpClient.Exceptions.BadRequestException;
import OkHttpClient.Exceptions.NotFoundException;
import OkHttpClient.Exceptions.AuthorizationException;
import OkHttpClient.Exceptions.ServiceConditionException;
import OkHttpClient.Exceptions.SystemException;

import java.io.IOException;
import java.util.Map;

public interface HttpClient {

    public Map<String, Object> getRequest(String connectionUrl, Map<String, Object> queryParams,
                                          Map<String, String> headers, boolean async) throws IOException,
            BadRequestException, NotFoundException, AuthorizationException, ServiceConditionException, SystemException;

    public Map<String, Object> postRequest(String connectionUrl, Map<String, Object> postParams,
                                           Map<String, String> headers, boolean async) throws IOException,
            BadRequestException, NotFoundException, AuthorizationException, ServiceConditionException, SystemException;

    public Map<String, Object> putRequest(String connectionUrl, Map<String, Object> putParams,
                                          Map<String, String> headers, boolean async) throws IOException,
            BadRequestException, NotFoundException, AuthorizationException, ServiceConditionException, SystemException;

    public Map<String, Object> deleteRequest(String connectionUrl, Map<String, String> headers) throws IOException, BadRequestException,
            NotFoundException, AuthorizationException, ServiceConditionException, SystemException;


}
