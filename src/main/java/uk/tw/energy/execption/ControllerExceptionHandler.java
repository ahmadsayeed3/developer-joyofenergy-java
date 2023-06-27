package uk.tw.energy.execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uk.tw.energy.dto.ErrorDTO;
import uk.tw.energy.dto.GenericResponseDTO;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ErrorDTO> errors = new ArrayList<>();
        GenericResponseDTO genericResponseDTO = new GenericResponseDTO(null);
        genericResponseDTO.setErrorDTOList(errors);
        genericResponseDTO.setError(true);
        exception.getBindingResult().getAllErrors().forEach(objectError -> {
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setErrorCode("FIELD_ERROR");
            errorDTO.setErrorDescription(objectError.getDefaultMessage());
            errors.add(errorDTO);
        });

        return new ResponseEntity<>(genericResponseDTO, HttpStatus.BAD_REQUEST);
    }

}
