package pages.API.manager;


import pages.API.API_BasePage;
import pages.API.globals.GlobalDatas;
import pages.API.payloads.BookingPayloads;

public class PayloadObjectManager extends API_BasePage {


    private BookingPayloads bookingPayloads;
    private GlobalDatas globalData;

    /**
     * @author Sivanathan
     * @see this is a method used to create object for BookingPayloads
     * @return the object of BookingPayloads class
     * @since 28/08/2023
     */
    public BookingPayloads getBookingPayload() {
        try {
            return (bookingPayloads == null)? bookingPayloads = new BookingPayloads(): bookingPayloads;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return bookingPayloads;
    }

    /**
     * @author Sivanathan
     * @see this is a method used to create object for GlobalDatas
     * @return the object of GlobalDatas class
     * @since 28/08/2023
     */

    public GlobalDatas getGlobalDatas() {
        try {
            return (globalData == null)? globalData = new GlobalDatas(): globalData;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return globalData;
    }


}
