package com.gabrielle.tdd;

import com.gabrielle.tdd.model.BookingModel;
import com.gabrielle.tdd.model.PersonModel;
import com.gabrielle.tdd.repository.BookingRepository;
import com.gabrielle.tdd.service.BookingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class BookingServiceTest {

    // Class to return a instance of BookingService
    @TestConfiguration
    static class BookingServiceTestConfiguration{
        @Bean
        public BookingService bookingService(){
            return new BookingService();
        }
    }

    @Autowired
    BookingService bookingService;

    @MockBean
    BookingRepository bookingRepository;

    @Test
    public void bookingTestServiceDaysCalculator(){
        String name = "Gabrielle";
        int days = this.bookingService.daysCalculatorWithDatabase(name);
        Assertions.assertEquals(days, 10);
    }

    // BookingRepository method simulation returning a BookingModel
    @BeforeEach
    public void setup(){
        LocalDate checkIn = LocalDate.parse("2022-11-10");
        LocalDate checkOut = LocalDate.parse("2022-11-20");
        PersonModel personModel = new PersonModel(1l, "Gabrielle", 21);
        BookingModel bookingModel = new BookingModel(1l, personModel.getName(), checkIn, checkOut, 2);

        Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserveName()))
                .thenReturn(Optional.of(bookingModel));
    }

}
