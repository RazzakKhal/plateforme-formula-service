package com.bookNDrive.formula_service.dtos.sended;

public record ErrorResponseDto(
        String errorCode,
        String message,
        int status
) {
}

