package com.anonymous63.sms.entity.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Embeddable
public class Address {
    @NotBlank(message = "Street is required")
    @Size(max = 30, message = "Street name cannot exceed 30 characters")
    @Column(length = 30)
    private String street;

    @NotBlank(message = "City is required")
    @Size(max = 30, message = "City name cannot exceed 30 characters")
    @Column(length = 30)
    private String city;

    @NotBlank(message = "State is required")
    @Size(max = 30, message = "State name cannot exceed 30 characters")
    @Column(length = 30)
    private String state;

    @NotBlank(message = "Pin code is required")
    @Pattern(regexp = "\\d{6}", message = "Pin code cannot exceed 6 digits")
    @Column(length = 6)
    private int pinCode;

    @Size(max = 50, message = "Landmark cannot exceed 50 characters")
    private String landmark;
}
