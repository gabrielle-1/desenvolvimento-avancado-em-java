package com.gabrielle.tdd.repository;

import com.gabrielle.tdd.model.BookingModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookingRepository extends JpaRepository<BookingModel, String> {

    Optional<BookingModel> findByReserveName(String reserveName);

}
