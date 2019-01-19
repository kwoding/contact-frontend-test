package it.ding.contact.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    private Long id;

    @Builder.Default private String lastName = "";

    @Builder.Default private String firstName = "";

    @Builder.Default private String email = "";

    @Builder.Default private String phone = "";

    @Builder.Default private String addressLine1 = "";

    @Builder.Default private String addressLine2 = "";

    @Builder.Default private String zipCode = "";

    @Builder.Default private String city = "";

    @Builder.Default private String countrySubDivision = "";

    @Builder.Default private String country = "";

}
