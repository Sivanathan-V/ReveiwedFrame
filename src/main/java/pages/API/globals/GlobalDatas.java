package pages.API.globals;


import lombok.Data;
import pages.API.API_BasePage;

@Data
public class GlobalDatas extends API_BasePage {

    private int statusCode;
    private String bookingId;
    private String token;

}
