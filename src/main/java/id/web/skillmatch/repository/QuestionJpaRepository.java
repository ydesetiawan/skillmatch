package id.web.skillmatch.repository;

import id.web.skillmatch.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionJpaRepository extends JpaRepository<Question, Long> {
}
