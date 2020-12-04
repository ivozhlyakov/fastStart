package ru.diasoft.digitalq.quickstart.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "sms_verification")
public class SmsVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sms_verification_verificationid_seq")
    @SequenceGenerator(name = "sms_verification_verificationid_seq", sequenceName = "sms_verification_verificationid_seq",allocationSize = 1)
    @Column(name = "verificationid")
    private Long verificationid;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "processguid")
    private String processguid;

    @Column(name = "secretcode")
    private String secretcode;

    @Column(name = "status")
    private String status;

}
