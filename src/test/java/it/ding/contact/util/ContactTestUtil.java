package it.ding.contact.util;

import static java.util.Comparator.comparing;

import com.github.javafaker.Faker;
import it.ding.contact.model.Contact;
import java.util.List;

public class ContactTestUtil {

    private static Faker faker = new Faker();

    public static Contact generateContactWithMandatoryFieldsFilled() {
        return Contact.builder()
            .lastName(faker.name().lastName())
            .firstName(faker.name().firstName())
            .email(faker.internet().emailAddress())
            .build();
    }

    public static Contact generateContactWithAllFieldsFilled() {
        return Contact.builder()
            .lastName(faker.name().lastName())
            .firstName(faker.name().firstName())
            .email(faker.internet().emailAddress())
            .phone(faker.phoneNumber().phoneNumber())
            .addressLine1(faker.address().streetAddress())
            .addressLine2(faker.address().streetAddress())
            .city(faker.address().city())
            .zipCode(faker.address().zipCode())
            .countrySubDivision(faker.address().state())
            .country(faker.address().country())
            .build();
    }

    public static void sortContactsById(List<Contact> contactList) {
        contactList.sort(comparing(Contact::getId));
    }

}
