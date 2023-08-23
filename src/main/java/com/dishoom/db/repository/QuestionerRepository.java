package com.dishoom.db.repository;

import com.dishoom.db.entity.QuestionerDetails;
import java.util.Optional;

public interface QuestionerRepository {

    void save(QuestionerDetails questionerDetails);

    void saveOrUpdate(QuestionerDetails questionerDetails);

    Optional<QuestionerDetails> getByQuestionerId(String questionerId);
}
