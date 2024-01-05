package id.web.skillmatch.gateway.category.command;

import id.web.skillmatch.model.category.Category;
import id.web.skillmatch.repository.CategoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaCategoryCommandGateway implements CategoryCommandGateway {

    private final CategoryJpaRepository categoryJpaRepository;

    @Override
    public void save(Category category) {
        categoryJpaRepository.save(category);
    }
}
