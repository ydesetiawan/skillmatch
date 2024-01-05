package id.web.skillmatch.repository;

import id.web.skillmatch.model.answer.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerJpaRepository extends JpaRepository<Answer, Long> {
}
