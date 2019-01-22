package utils;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Utility {
    public static byte[] getSha512(String value) {
        try {
            return MessageDigest.getInstance("SHA-512").digest(value.getBytes("UTF-8"));
        }
        catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String,String> getQueryParamsMapFromJsonBody(play.mvc.Http.Request request){
        Map<String,String> queryParamMap = new HashMap();
        try{
            queryParamMap.putAll(getQueryParams(request.body().asJson()));
        }catch(Exception ex){
            //TODO log
        }
        return queryParamMap;
    }

    public static Map<String,String> getQueryParams(JsonNode node){
        Map<String,String> queryParamMap = new HashMap();
        try{
            java.util.Iterator<String> iterator = node.fieldNames();
            while(iterator.hasNext()){
                String fieldName = iterator.next();

                if (node.get(fieldName) instanceof com.fasterxml.jackson.databind.node.ObjectNode) { //for jsonNode like UserData
                    queryParamMap.put(fieldName,node.get(fieldName).toString());
                }
                else {
                    queryParamMap.put(fieldName,node.get(fieldName).asText());
                }

            }
        }catch(Exception ex){
            //TODO log
        }
        return queryParamMap;
    }
}
