package OkHttpClient;

import OkHttpClient.exceptions.BadRequestException;
import OkHttpClient.exceptions.NotFoundException;
import OkHttpClient.exceptions.AuthorizationException;
import OkHttpClient.exceptions.ServiceConditionException;
import OkHttpClient.exceptions.SystemException;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class ApiCallTest {
    public static void main(String args[]) {

        ApiClient apiClient = new ApiClient();

        try {
            Map<String, Object> response = apiClient.getRequest("https://reqres.in/api/users/2", Collections.emptyMap(), Collections.emptyMap(), true);
            System.out.println(response.toString());
        } catch (BadRequestException ex) {
            //log ex
        } catch (AuthorizationException ex) {
            // log ex
        } catch (NotFoundException ex) {
            // log ex
        } catch (IOException ex) {
            // log ex
        } catch (ServiceConditionException ex) {
            // log ex
        } catch (SystemException ex) {
            // log ex
        }

        /*Map <String, Object> postParams = new HashMap<>();
        postParams.put("name", "Sudip");
        postParams.put("job", "Software Eng");
        Map<String, Object> response = apiClient.postRequest("https://reqres.in/api/users/2", postParams, Collections.emptyMap(), true);
        System.out.println(response.toString());*/

    }
}
