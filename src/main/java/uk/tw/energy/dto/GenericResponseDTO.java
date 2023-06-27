package uk.tw.energy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class GenericResponseDTO<T> {

    private boolean isError;

    @JsonProperty("errors")
    private List<ErrorDTO> errorDTOList;

    private T payload;

    public GenericResponseDTO(T payload){
        this.payload = payload;
        this.errorDTOList = new ArrayList<>();
    }


    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public List<ErrorDTO> getErrorDTOList() {
        return errorDTOList;
    }

    public void setErrorDTOList(List<ErrorDTO> errorDTOList) {
        this.errorDTOList = errorDTOList;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
