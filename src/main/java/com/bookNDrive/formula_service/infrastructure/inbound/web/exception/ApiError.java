package com.bookNDrive.formula_service.infrastructure.inbound.web.exception;

import java.time.OffsetDateTime;
import java.util.Map;

public record ApiError(
        int status,
        String errorCode,
        String messageKey,
        Map<String, Object> arguments,
        String message,
        OffsetDateTime timestamp,
        String path
) {
}
