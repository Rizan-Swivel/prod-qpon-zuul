package com.swivel.qpon.wrapper;

import com.swivel.qpon.domain.BaseDto;
import com.swivel.qpon.domain.response.ResponseDto;
import com.swivel.qpon.enums.ResponseStatusType;
import lombok.Getter;

/**
 * ResponseWrapper
 */
@Getter
public class ResponseWrapper implements BaseDto {

    private final ResponseStatusType status;
    private final String message;
    private final ResponseDto data;

    public ResponseWrapper(ResponseStatusType statusType, String message, ResponseDto data) {
        this.status = statusType;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toLogJson() {
        return toJson();
    }
}
