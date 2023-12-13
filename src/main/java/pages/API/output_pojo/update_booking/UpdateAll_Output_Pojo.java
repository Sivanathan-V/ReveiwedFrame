package pages.API.output_pojo.update_booking;

import lombok.Data;

@Data
public class UpdateAll_Output_Pojo {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private outputPojoDatesUpdate bookingdates;
    private String additionalneeds;
}
