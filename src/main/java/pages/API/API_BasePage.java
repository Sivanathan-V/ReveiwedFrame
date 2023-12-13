package pages.API;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.util.Properties;


public class API_BasePage {
    public static RequestSpecification reqSpec;
    public static Response response;

    public void addHeader(String key, String value) {
        try {
            reqSpec = RestAssured.given().header(key, value);
        } catch (Exception e) {
            System.err.println("Unable to add header: " + e.getMessage());
        }


    }

    public void addHeaders(Headers headers) {
        try {
            reqSpec = RestAssured.given().headers(headers);
        } catch (Exception e) {
            System.err.println("Unable to add headers: " + e.getMessage());
        }


    }

    public void addBasicAuth(String userName, String password) {
        try {
            reqSpec = reqSpec.auth().preemptive().basic(userName, password);
        } catch (Exception e) {
            System.err.println("Unable to execute basic auth : " + e.getMessage());
        }


    }

    public void addPathParam(String key, String value) {
        try {
            reqSpec = reqSpec.pathParam(key, value);
        } catch (Exception e) {
            System.err.println("Unable to add path parameter : " + e.getMessage());
        }


    }

    public void addQueryParam(String key, String value) {
        try {
            reqSpec = reqSpec.queryParam(key, value);
        } catch (Exception e) {
            System.err.println("Unable to add query parameter : " + e.getMessage());
        }

    }

    public void addBody(String body) {
        try {
            reqSpec = reqSpec.body(body);
        } catch (Exception e) {
            System.err.println("Unable to add body : " + e.getMessage());
        }

    }

    public void addObjectBody(Object body) {
        try {
            reqSpec = reqSpec.body(body);
        } catch (Exception e) {
            System.err.println("Unable to add object body : " + e.getMessage());
        }


    }

    public Response requestType(String type, String endPoint) {

        try {
            switch (type) {
                case "GET":
                    response = reqSpec.log().all().get(endPoint);
                    break;
                case "POST":
                    response = reqSpec.log().all().post(endPoint);
                    break;
                case "PUT":
                    response = reqSpec.log().all().put(endPoint);
                    break;
                case "DELETE":
                    response = reqSpec.log().all().delete(endPoint);
                    break;
                case "PATCH":
                    response = reqSpec.log().all().patch(endPoint);
                    break;

            }

        } catch (Exception e) {
            System.err.println("Unable to send request to the endPoint : " + e.getMessage());
        }


        return response;
    }

    public int getStatusCode(Response response) {
        int statusCode = 0;
        try {
            statusCode = response.getStatusCode();

        } catch (Exception e) {
            System.err.println("Unable to get the status code: " + e.getMessage());
        }


        return statusCode;
    }

    public String getResBodyAsString(Response response) {
        String resBody = null;
        try {
             resBody = response.asString();
        } catch (Exception e) {
            System.err.println("Unable to get the status code: " + e.getMessage());

        }

        return resBody;

    }

    public String getResBodyAsPrettyString(Response response) {
        String prettyString = null;
        try {
            prettyString = response.asPrettyString();
        }catch (Exception e){
            System.err.println("Unable to get the response body: " + e.getMessage());

        }

        return prettyString;

    }

    public static String getPropertyFileValue(String key){
        Properties properties = null;
        try {
            properties = new Properties();
            properties.load(new FileInputStream( "./src/main/resources/properties/APIConfig.properties"));
        } catch (Exception e) {
            System.err.println("Unable to the propertyFile: " + e.getMessage());
        }

        return (String) properties.get(key);

    }
}
