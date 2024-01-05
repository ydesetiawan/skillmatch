package id.web.skillmatch.gateway.category.query;

import id.web.skillmatch.model.category.Category;
import id.web.skillmatch.repository.CategoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaCategoryQueryGateway implements CategoryQueryGateway {

    private final CategoryJpaRepository categoryJpaRepository;

    @Override
    public Optional<Category> findById(Long id) {
        return categoryJpaRepository.findById(id);
    }
}
