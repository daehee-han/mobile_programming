package com.kmu.ndhs;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    final static private String URL = "http://10.0.2.2/Register.php";
    private Map<String, String> parameters;

    public RegisterRequest(String userID, String userPassword, String userName, int userRoomNumber, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("userName", userName);
        parameters.put("userRoomNumber", userRoomNumber + "");
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
