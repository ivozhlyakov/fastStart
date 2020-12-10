package ru.diasoft.digitalq.quickstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.diasoft.digitalq.quickstart.domain.SmsVerification;

import java.util.Optional;

@Repository
public interface SmsVerificationRepository extends JpaRepository<SmsVerification, Long> {
    Optional<SmsVerification> findBySecretcodeAndProcessguidAndStatus(String secretCode, String processGuid, String status);

    @Modifying
    @Transactional
    @Query("update SmsVerification set status=?1 where processguid=?2")
    int updateStaus(String status, String guid);

}

