package com.gabrielle.tdd.model;

import java.time.LocalDate;

/**
 * class of model booking
 * @param args
 *
 * @throws Exception lancada
 */
public class BookingModel {
  private Long id;
  private String reserveName;
  private LocalDate checkIn;
  private LocalDate checkOut;
  private int numberGuests;

  public BookingModel(Long id, String reserveName, LocalDate checkIn,
      LocalDate checkOut, int numberGuests) {
    this.id = id;
    this.reserveName = reserveName;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
    this.numberGuests = numberGuests;
  }

  public Long getId() {
    return id;
  }

  public String getReserveName() {
    return reserveName;
  }

  public void setReserveName(String reserveName) {
    this.reserveName = reserveName;
  }

  public LocalDate getCheckIn() {
    return checkIn;
  }

  public void setCheckIn(LocalDate checkIn) {
    this.checkIn = checkIn;
  }

  public LocalDate getCheckOut() {
    return checkOut;
  }

  public void setCheckOut(LocalDate checkOut) {
    this.checkOut = checkOut;
  }

  public int getNumberGuests() {
    return numberGuests;
  }

  public void setNumberGuests(int numberGuests) {
    this.numberGuests = numberGuests;
  }
}
