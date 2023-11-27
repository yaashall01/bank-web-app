package com.yaashall.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailMessage {

    private String toAddress;
    private String subject;
    private String body;
    private boolean isHtml;
    private String attachmentName;

}
