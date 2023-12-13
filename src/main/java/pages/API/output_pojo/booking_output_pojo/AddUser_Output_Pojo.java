package pages.API.output_pojo.booking_output_pojo;

import lombok.Data;
import pages.API.API_BasePage;

@Data
public class AddUser_Output_Pojo extends API_BasePage {
    private int bookingid;
    private BookingOutput booking;
}
