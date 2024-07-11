package com.assembleyourpc.app.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Ashish R. Tiwari",
                        email = "ashisht.clouddev@gmail.com",
                        url = "https://in.linkedin.com/in/ashisht11"
                ),
                description = "OpenApi Documentation for Assemble your PC",
                title = "Product Module Api Documentation"
        )
)
public class SpringApiDocConfig {
}
