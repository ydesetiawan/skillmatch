package id.web.skillmatch.gateway.category.query;

import id.web.skillmatch.model.category.Category;

import java.util.Optional;

public interface CategoryQueryGateway {

    Optional<Category> findById(Long id);

}
