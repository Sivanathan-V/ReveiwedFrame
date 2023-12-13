package pages.API.payloads;


import lombok.Data;
import pages.API.API_BasePage;
import pages.API.input_pojo.booking_input_pojo.AddUser_Input_Pojo;
import pages.API.input_pojo.booking_input_pojo.Bookingdates;
import pages.API.input_pojo.token_output_pojo.CreateToken_Input_Pojo;
import pages.API.input_pojo.update_booking_input_pojo.Dates;
import pages.API.input_pojo.update_booking_input_pojo.UpdateAll_Input_Pojo;
import pages.API.input_pojo.update_booking_input_pojo.UpdatePatch_Input_Pojo;


@Data
public class BookingPayloads extends API_BasePage {

    CreateToken_Input_Pojo ct_i_p;
    AddUser_Input_Pojo bk_i_p;
    UpdateAll_Input_Pojo ua_i_p;
    UpdatePatch_Input_Pojo up_i_p;

    /**
     * @author Sivanathan
     * @see this is a method used for getting the payload for create token
     * @param username should be passed as String, this holds the username
     * @param password should be passed as String, this holds the password
     * @return This method returns the payload for create token
     * @since 28/08/2023
     */
    public CreateToken_Input_Pojo createTokenPayload(String username, String password) {

        try {
            ct_i_p = new CreateToken_Input_Pojo(username, password);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return ct_i_p;
    }

    /**
     * @author Sivanathan
     * @see this is a method used for getting the payload for create booking
     * @param firstname should be passed as String
     * @param lastname should be passed as String
     * @param totalprice should be passed as int
     * @param depositpaid should be passed as boolean
     * @param checkin should be passed as String
     * @param checkout should be passed as String
     * @param additionalneeds should be passed as String
     * @return This method returns the payload for Create booking
     * @since 29/08/2023
     */
    public AddUser_Input_Pojo bookUserPayload(String firstname, String lastname, int totalprice, boolean depositpaid,
                                              String checkin, String checkout, String additionalneeds) {

        try {
            Bookingdates bd = new Bookingdates(checkin,checkout);

            bk_i_p = new AddUser_Input_Pojo( firstname, lastname,totalprice, depositpaid,
                    bd, additionalneeds);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return bk_i_p;
    }

    /**
     * @author Sivanathan
     * @see this is a method used for getting the payload for update booking using put
     * @param firstname should be passed as String
     * @param lastname should be passed as String
     * @param totalprice should be passed as int
     * @param depositpaid should be passed as boolean
     * @param checkin should be passed as String
     * @param checkout should be passed as String
     * @param additionalneeds should be passed as String
     * @return This method returns the payload for update booking using put
     * @since 31/08/2023
     */
    public UpdateAll_Input_Pojo updateAllUserPayload(String firstname, String lastname, int totalprice, boolean depositpaid,
                                                     String checkin, String checkout, String additionalneeds) {
        try {
            Dates dates = new Dates(checkin,checkout);
            ua_i_p = new UpdateAll_Input_Pojo(firstname, lastname,totalprice, depositpaid,
                    dates, additionalneeds);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return ua_i_p;
    }

    /**
     * @author Sivanathan
     * @see this is a method used for getting the payload for update selected fields
     * @param firstname should be passed as String
     * @param lastname should be passed as String
     * @return This method returns the payload for update selected fields
     * @since 31/08/2023
     */
    public UpdatePatch_Input_Pojo upadateSelectedFieldsPayload(String firstname, String lastname) {
        try {
            up_i_p = new UpdatePatch_Input_Pojo(firstname, lastname);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return up_i_p;
    }




}
