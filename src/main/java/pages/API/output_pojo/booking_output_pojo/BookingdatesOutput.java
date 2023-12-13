package pages.API.output_pojo.booking_output_pojo;

import lombok.Data;
import pages.API.API_BasePage;

@Data
public class BookingdatesOutput extends API_BasePage {
    private String checkin;
    private String checkout;
}
