package org.skyscreamer.yoga.demo.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by IntelliJ IDEA. User: Carter Page Date: 4/19/11 Time: 6:18 PM
 */
public final class TestUtil
{
    protected final Log _log = LogFactory.getLog( getClass() );

    public static JSONObject getJSONObject( String url, Map<String, String> params ) throws JSONException
    {
        return new JSONObject( getContent( url, params ) );
    }

    public static  JSONArray getJSONArray( String url, Map<String, String> params ) throws JSONException
    {
        return new JSONArray( getContent( url, params ) );
    }

    public static  String getContent( String url, Map<String, String> params )
    {
        RestTemplate restTemplate = new RestTemplate();
        StringBuilder sb = new StringBuilder( "http://localhost:8082" ).append( url ).append( ".json" );
        addParams( params, sb );
        return restTemplate.getForObject( sb.toString(), String.class );
    }

    public static void addParams( Map<String, String> params, StringBuilder sb )
    {
        if ( params == null )
            return;

        String append = "?";
        for ( Entry<String, String> entry : params.entrySet() )
        {
            sb.append( append ).append( entry.getKey() ).append( "=" ).append( entry.getValue() );
        }
    }
}
