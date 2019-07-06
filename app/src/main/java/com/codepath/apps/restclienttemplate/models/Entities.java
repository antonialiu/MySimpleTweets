package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Entities {

    public String mediaUrl;

    public static Entities fromJSON(JSONObject json) throws JSONException {
        Entities entities = new Entities();
        if (json.has("media")) {
            entities.mediaUrl = json.getJSONArray("media").getJSONObject(0).getString("media_url_https");
        }

        return entities;
    }
}
