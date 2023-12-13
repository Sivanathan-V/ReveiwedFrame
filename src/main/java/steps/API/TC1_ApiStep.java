package steps.API;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.API.API_BasePage;
import pages.API.endpoints.EndPoints;
import pages.API.manager.PayloadObjectManager;
import pages.API.output_pojo.booking_output_pojo.AddUser_Output_Pojo;
import pages.API.output_pojo.booking_output_pojo.BookingList_Output_Pojo;
import pages.API.output_pojo.token.CreateToken_Output_Pojo;

import java.io.IOException;

public class TC1_ApiStep extends API_BasePage {

   public static PayloadObjectManager pom = new PayloadObjectManager ();


    /**
     * @author Sivanathan
     * @see this method is used to add the header
     * @since 06/11/2023
     */
    @Given("User adds the header")
    public void user_adds_the_header() {

            addHeader("Content-Type","application/json");

    }
    /**
     * @author Sivanathan
     * @see this method is used to pass the payload of CreateToken
     * @throws IOException for handling any input or output operation failure or interruption
     * @since 06/11/2023
     */
    @When("User add payload for basic authentication")
    public void user_add_payload_for_basic_authentication() throws IOException {

            addObjectBody(pom.getBookingPayload().createTokenPayload(getPropertyFileValue("username"), getPropertyFileValue("password")));
      	}
    /**
     * @author Sivanathan
     * @see this method is used to send CreateToken request
     * @param reqMethod should be passed as String and it tells which Http method to be used and verify the status code
     * @since 06/11/2023
     */
    @When("User send {string} request for creating token")
    public void user_send_request_for_creating_token(String reqMethod) {

            response = requestType(reqMethod, EndPoints.APIBASICAUTH);
            int statusCode = getStatusCode(response);
            pom.getGlobalDatas().setStatusCode(statusCode);

    }

    /**
     * @author Sivanathan
     * @see this method is used to get the token
     * @since 06/11/2023
     */
    @Then("User get the logtoken")
    public void user_get_the_logtoken() {

            CreateToken_Output_Pojo ct_o_p = response.as(CreateToken_Output_Pojo.class);
            String actToken = 	ct_o_p.getToken();
            pom.getGlobalDatas().setToken(actToken);


    }

    /**
     * @author Sivanathan
     * @see this method is used to set GetBookingIds request
     * @param reqMethod should be passed as String and it tells which Http method to be used and verify the status code
     * @since 06/11/2023
     */
    @When("User send {string} request to booking list endpoint")
    public void user_send_request_to_booking_list_endpoint(String reqMethod) {

            response = requestType(reqMethod,EndPoints.BOOKINGLIST);
            int statusCode = getStatusCode(response);
            pom.getGlobalDatas().setStatusCode(statusCode);
            BookingList_Output_Pojo[] bl_o_p = response.as(BookingList_Output_Pojo[].class);

    }


    /**
     * @author Sivanathan
     * @see this method is used to pass the payload of CreateBooking
     * @param firstname should be passed as the String
     * @param lastname should be passed as the String
     * @param totalprice should be passed as the String
     * @param depositpaid should be passed as the String
     * @param checkin should be passed as the String
     * @param checkout should be passed as the String
     * @param additionalneeds should be passed as the String
     * @since 06/11/2023
     */
    @When("User adds the payload for create booking {string},{string},{string},{string},{string},{string},{string}")
    public void user_adds_the_payload_for_create_booking(String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) {

            int price = Integer.parseInt(totalprice);
            boolean dp = Boolean.valueOf(depositpaid);
            addObjectBody(pom.getBookingPayload().bookUserPayload(firstname, lastname, price, dp, checkin, checkout, additionalneeds));

    }
    /**
     * @author Sivanathan
     * @see this method is used to send CreateBooking request
     * @param reqMethod should be passed as String and it tells which Http method to be used and verify the status code
     * @since 06/11/2023
     */
    @When("User send {string} request for creating a booking")
    public void user_send_request_for_creating_a_booking(String reqMethod) {

            response = requestType(reqMethod, EndPoints.BOOKINGLIST);
            int statusCode = getStatusCode(response);
            pom.getGlobalDatas().setStatusCode(statusCode);
            AddUser_Output_Pojo au_o_p = response.as(AddUser_Output_Pojo.class);
            int bId = au_o_p.getBookingid();
            String bookId = String.valueOf(bId);
            pom.getGlobalDatas().setBookingId(bookId);

    }


}
