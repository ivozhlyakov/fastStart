/*
 * Created by DQCodegen
 */
package ru.diasoft.digitalq.quickstart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmsVerificationDeliveredMessage {

    @JsonProperty("code")
    protected String code;

}
