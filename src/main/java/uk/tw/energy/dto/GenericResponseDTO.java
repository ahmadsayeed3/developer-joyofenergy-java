package uk.tw.energy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GenericResponseDTO {

    private boolean isError;

    @JsonProperty("errors")
    private List<ErrorDTO> errorDTOList;

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
}
