package by.clevertec.autoshow.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ExceptionObject {

    private final int value;
    private final String status;
    private final String message;
}
