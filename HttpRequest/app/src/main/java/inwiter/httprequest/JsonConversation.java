package inwiter.httprequest;

import android.util.Log;

import org.json.JSONObject;

public class JsonConversation {

    public String getJSONValue(String jsonString, String keyValue){

        String jsonkeyValue = "";

        try{
            JSONObject jsonObject = new JSONObject(jsonString);
            jsonkeyValue = jsonObject.getString(keyValue);
        } catch (Exception e){
            Log.i("app", "JSON conversation error: "+ e);
        }

        return jsonkeyValue;
    }
}
