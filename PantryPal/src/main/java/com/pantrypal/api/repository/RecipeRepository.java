package com.pantrypal.api.repository;

import com.pantrypal.api.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    // Non-paged variant (handy for tests / simple lists)
    @Query("""
           select distinct r
           from Recipe r
           join r.ingredients i
           where lower(i.name) in :names
           """)
    List<Recipe> findByAnyIngredientNameIn(@Param("names") Collection<String> names);

    // Paged variant used by the controller (/api/search)
    @Query(value = """
           select distinct r
           from Recipe r
           join r.ingredients i
           where lower(i.name) in :names
           """,
            countQuery = """
           select count(distinct r)
           from Recipe r
           join r.ingredients i
           where lower(i.name) in :names
           """)
    Page<Recipe> findByAnyIngredientNameIn(
            @Param("names") Collection<String> names,
            Pageable pageable);
}
