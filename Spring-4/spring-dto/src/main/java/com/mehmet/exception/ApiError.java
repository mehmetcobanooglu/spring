package com.mehmet.exception;

import java.util.Date;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// @NoArgsConstructor
// @AllArgsConstructor

public class ApiError {

    private String id;

    private Date errorTime;

    private Map<String, List<String>> errors;

}
