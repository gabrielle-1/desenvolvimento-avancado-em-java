package com.gabrielle.tdd;

import com.gabrielle.tdd.model.BookingModel;
import com.gabrielle.tdd.repository.BookingRepository;
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

    // Classe de configuração com método que retorna o bookingService
    // com a anotação @Bean criando o ponto de injeção no teste.
    // @TestConfiguration Anotação de que é um Bean apenas para testes.
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

    @BeforeEach
    public void setup(){
        // Preparar o repository através de um Mock
        // Quando o repository for chamado, retorne tal coisa que será o bookingModel.

        LocalDate checkIn = LocalDate.parse("2022-11-10");
        LocalDate checkOut = LocalDate.parse("2022-11-20");
        BookingModel bookingModel = new BookingModel("1", "Gabrielle", checkIn, checkOut, 2);

        // Simulando para que: Quando precisar de uma instancia de BookingRepository, retornar o BookingModel
        Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserveName()))
                .thenReturn(Optional.of(bookingModel));
    }

}
