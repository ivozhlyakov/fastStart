/*
 * Created by DQCodegen
 */
package ru.diasoft.digitalq.quickstart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SmsVerificationMessage {

    @JsonProperty("guid")
    protected String guid;

}
