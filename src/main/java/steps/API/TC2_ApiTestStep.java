package steps.API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import pages.API.API_BasePage;
import pages.API.endpoints.EndPoints;
import pages.API.output_pojo.update_booking.UpdateAll_Output_Pojo;

import java.util.ArrayList;
import java.util.List;

public class TC2_ApiTestStep extends API_BasePage {
    Response response;

    /**
     * @author Sivanathan
     * @see this method is used to add the headers
     * @since 31/08/2023
     */
    @Given("User adds the headers")
    public void user_adds_the_headers() {

        Header h1 = new Header("Content-Type", "application/json");
        Header h2 = new Header("Accept", "application/json");
        Header h3 = new Header("Cookie", "token=" + TC1_ApiStep.pom.getGlobalDatas().getToken());
        List<Header> list = new ArrayList<>();
        list.add(h1);
        list.add(h2);
        list.add(h3);
        Headers headers = new Headers(list);
        addHeaders(headers);

    }

    /**
     * @author Sivanathan
     * @see this method is used to add the path parameter to UpdateBooking api
     * @since 31/08/2023
     */
    @When("User adds path parameter for updating all fields")
    public void user_adds_path_parameter_for_updating_all_fields() {

        addPathParam("id", TC1_ApiStep.pom.getGlobalDatas().getBookingId());

    }

    /**
     * @param firstname       should be passed as the String
     * @param lastname        should be passed as the String
     * @param totalprice      should be passed as the String
     * @param depositpaid     should be passed as the String
     * @param checkin         should be passed as the String
     * @param checkout        should be passed as the String
     * @param additionalneeds should be passed as the String
     * @author Sivanathan
     * @see this method is used to pass the payload of UpdateBooking
     * @since 31/08/2023
     */
    @When("User adds the payload for update booking all fields {string},{string},{string},{string},{string},{string},{string}")
    public void user_adds_the_payload_for_update_booking_all_fields(String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) {

        int price = Integer.parseInt(totalprice);
        boolean dp = Boolean.valueOf(depositpaid);
        addObjectBody(TC1_ApiStep.pom.getBookingPayload().updateAllUserPayload(firstname, lastname, price, dp, checkin, checkout, additionalneeds));

    }

    /**
     * @param reqMethod should be passed as String and it tells which Http method to be used and verify the status code
     * @author Sivanathan
     * @see this method is used to send UpdateBooking request
     * @since 31/08/2023
     */
    @When("User send {string} request for updating all fields")
    public void user_send_request_for_updating_all_fields(String reqMethod) {

        response = requestType(reqMethod, EndPoints.UPDATEBOOKING + "{id}");
        int statusCode = getStatusCode(response);
        TC1_ApiStep.pom.getGlobalDatas().setStatusCode(statusCode);
        UpdateAll_Output_Pojo ua_o_p = response.as(UpdateAll_Output_Pojo.class);


    }

    /**
     * @author Sivanathan
     * @see this method is used to add the path parameter to PartialUpdateBooking api
     * @since 31/08/2023
     */
    @When("User adds path parameter for updating selected fields")
    public void user_adds_path_parameter_for_updating_selected_fields() {

        addPathParam("id", TC1_ApiStep.pom.getGlobalDatas().getBookingId());

    }

    /**
     * @param firstname should be passed as the String
     * @param lastname  should be passed as the String
     * @author Sivanathan
     * @see this method is used to pass the payload of PartialUpdateBooking
     * @since 31/08/2023
     */
    @When("User adds the payload for update booking selected fields {string},{string}")
    public void user_adds_the_payload_for_update_booking_selected_fields(String firstname, String lastname) {

        addObjectBody(TC1_ApiStep.pom.getBookingPayload().upadateSelectedFieldsPayload(firstname, lastname));

    }

    /**
     * @param reqMethod should be passed as String and it tells which Http method to be used and verify the status code
     * @author Sivanathan
     * @see this method is used to send PartialUpdateBooking request
     * @since 31/08/2023
     */
    @When("User send {string} request for updating selected fields")
    public void user_send_request_for_updating_selected_fields(String reqMethod) {

        response = requestType(reqMethod, EndPoints.UPDATEBOOKING + "{id}");
        int statusCode = getStatusCode(response);
        TC1_ApiStep.pom.getGlobalDatas().setStatusCode(statusCode);
        UpdateAll_Output_Pojo ua_o_p = response.as(UpdateAll_Output_Pojo.class);

    }

    /**
     * @author Sivanathan
     * @see this method is used to add the path parameter to DeleteBooking api
     * @since 31/08/2023
     */
    @When("User adds path parameter for deleting booking")
    public void user_adds_path_parameter_for_deleting_booking() {

        addPathParam("id", TC1_ApiStep.pom.getGlobalDatas().getBookingId());
    }

    /**
     * @param reqMethod should be passed as String and it tells which Http method to be used and verify the status code
     * @author Sivanathan
     * @see this method is used to send DeleteBooking request
     * @since 31/08/2023
     */
    @When("User send {string} request for deleting booking")
    public void user_send_request_for_deleting_booking(String reqMethod) {

        response = requestType(reqMethod, EndPoints.DELETEBOOKING + "{id}");
        int statusCode = getStatusCode(response);
        TC1_ApiStep.pom.getGlobalDatas().setStatusCode(statusCode);

    }


}
