package pages.API.input_pojo.token_output_pojo;

import lombok.Data;
import pages.API.API_BasePage;

@Data
public class CreateToken_Input_Pojo extends API_BasePage {
    private String username;
    private String password;

    public CreateToken_Input_Pojo(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }


}
