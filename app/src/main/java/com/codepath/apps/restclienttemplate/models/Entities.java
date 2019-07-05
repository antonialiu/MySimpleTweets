package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Entities {

    public static String mediaUrl;

    public static Entities fromJSON(JSONObject json) throws JSONException {
        Entities entities = new Entities();

        Entities.mediaUrl = json.getString("media/media_url_https");

        return entities;
    }
}
