package com.anonymous63.sms.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationError implements ErrorDetails {
    private Map<String, String> fieldErrors;
}
