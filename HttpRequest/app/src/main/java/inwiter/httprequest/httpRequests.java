package inwiter.httprequest;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


import java.util.ArrayList;
import java.util.List;

public class httpRequests extends AsyncTask<String, Void, String>
{

    @Override
    protected String doInBackground(String ... params)
    {
        String url = "http://inviter.com/signin/doSignIn/";
        String result = "failedResponse";
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost request = new HttpPost(url);
            List<NameValuePair> postParameters = new ArrayList<>();
            postParameters.add(new BasicNameValuePair("emailID", "barathbaisetty@inviter.com"));
            postParameters.add(new BasicNameValuePair("password", "jaisriram3981"));

            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(
                    postParameters);

            request.setEntity(formEntity);
            HttpResponse response = httpClient.execute(request);
            String jsonString = EntityUtils.toString(response.getEntity());

            JsonConversation jsonConversationObj = new JsonConversation();
            String jsonKeyValue = jsonConversationObj.getJSONValue(jsonString, "description");
            result = jsonKeyValue;
            Log.i("app", "Server success response: "+ jsonKeyValue);


        } catch(Exception e) {
            // Do something about exceptions
            result = e.getMessage();
            Log.i("app", "Server failed response: "+e);
        }
        return  result;
    }
}
