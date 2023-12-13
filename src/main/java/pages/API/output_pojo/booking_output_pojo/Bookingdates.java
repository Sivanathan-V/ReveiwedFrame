package pages.API.output_pojo.booking_output_pojo;

import lombok.Data;
import pages.API.API_BasePage;


@Data
public class Bookingdates extends API_BasePage {
    private String checkin;
    private String checkout;

    public Bookingdates(String checkin, String checkout) {
        super();
        this.checkin = checkin;
        this.checkout = checkout;
    }
}
