/*
 * Created by DQCodegen
 */
package ru.diasoft.digitalq.quickstart.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "SmsVerificationCheckRequest", description = "")
@JsonFilter("DynamicExclude")
public class SmsVerificationCheckRequest implements Serializable {

    @ApiModelProperty(name = "ProcessGUID", dataType = "java.lang.String", value = "GUID процесса", required = false, position = 1)
    @JsonProperty("ProcessGUID")
    protected String processGUID;

    @ApiModelProperty(name = "Code", dataType = "java.lang.String", value = "Проверочный код", required = false, position = 2)
    @JsonProperty("Code")
    protected String code;

}
