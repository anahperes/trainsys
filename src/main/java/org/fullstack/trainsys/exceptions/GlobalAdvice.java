package org.fullstack.trainsys.exceptions;

import org.fullstack.trainsys.exceptions.dto.Error;
import org.springframework.http.ResponseEntity;

public class GlobalAdvice {
    public ResponseEntity<?> handler(BadRequest exception) {
        Error error = Error.builder()
                .code("400")
                .message(exception.getMessage())
                .build();
        return ResponseEntity.status(400).body(error);
    }

    public ResponseEntity<?> handler(Unauthorized exception) {
        Error error = Error.builder()
                .code("401")
                .message(exception.getMessage())
                .build();
        return ResponseEntity.status(401).body(error);
    }

    public ResponseEntity<?> handler(Forbidden exception) {
        Error error = Error.builder()
                .code("403")
                .message(exception.getMessage())
                .build();
        return ResponseEntity.status(403).body(error);
    }

    public ResponseEntity<?> handler(NotFoundException exception) {
        Error error = Error.builder()
                .code("404")
                .message(exception.getMessage())
                .build();
        return ResponseEntity.status(404).body(error);
    }

    public ResponseEntity<?> handler(Conflict exception) {
        Error error = Error.builder()
                .code("409")
                .message(exception.getMessage())
                .build();
        return ResponseEntity.status(409).body(error);
    }

    public ResponseEntity<?> handler(InternalServerError exception) {
        Error error = Error.builder()
                .code("500")
                .message(exception.getMessage())
                .build();
        return ResponseEntity.status(500).body(error);
    }
}
