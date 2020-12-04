package ru.diasoft.digitalq.quickstart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diasoft.digitalq.quickstart.domain.SmsVerification;

@Repository
public interface SmsVerificationRepository extends JpaRepository<SmsVerification, Long> {
}
