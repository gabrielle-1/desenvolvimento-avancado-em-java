package com.gabrielle.tdd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabrielle.tdd.controller.BookingController;
import com.gabrielle.tdd.model.BookingModel;
import com.gabrielle.tdd.model.PersonModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = BookingController.class)
public class BookingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void bookingTestGetAll() throws Exception {
        mockMvc.perform(get("/bookings"))
                .andExpect(status().isOk());
    }

    @Test
    public void bookingTestSave() throws Exception {
        LocalDate checkIn = LocalDate.parse("2022-11-10");
        LocalDate checkOut = LocalDate.parse("2022-11-20");

        PersonModel personModel = new PersonModel(1l, "Gabrielle", 21);
        BookingModel bookingModel = new BookingModel(1l, personModel.getName(), checkIn, checkOut, 2);

        mockMvc.perform(post("/bookings")
                .contentType("application/json")
                .content(this.objectMapper.writeValueAsString(bookingModel)))
                .andExpect(status().isOk());

    }
}
