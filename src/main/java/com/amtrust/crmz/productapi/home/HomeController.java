package com.amtrust.crmz.productapi.home;

import lombok.extern.log4j.Log4j2;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;

@RestController
@Log4j2
public class HomeController {

    @GetMapping("/")
    public String getStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product API v 1.0.0 is up!");
        sb.append("<br>");
        sb.append("Service is running on ").append(StringUtils.isEmpty(System.getenv("HOSTNAME")) ? System.getenv("COMPUTERNAME") : System.getenv("HOSTNAME"));
        sb.append("<br>");
        sb.append("Accessed timestamp: ").append(
            DateFormat.getDateTimeInstance().format(new Date())
        );
        return sb.toString();
    }

}
