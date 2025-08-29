package com.pantrypal.api.controller;

import com.pantrypal.api.controller.dto.RecipeDto;
import com.pantrypal.api.model.Recipe;
import com.pantrypal.api.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    /** Quick sanity check: http://localhost:8080/api/ping */
    @GetMapping("/ping")
    public Map<String, String> ping() {
        return Map.of("status", "ok");
    }


    @GetMapping("/recipes")
    public List<RecipeDto> all() {
        return recipeService.all().stream().map(RecipeDto::from).toList();
    }


    @GetMapping("/recipes/paged")
    public Map<String, Object> paged(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        Page<Recipe> p = recipeService.paged(PageRequest.of(page, size));
        List<RecipeDto> content = p.getContent().stream().map(RecipeDto::from).toList();

        Map<String, Object> body = new HashMap<>();
        body.put("content", content);
        body.put("page", p.getNumber());
        body.put("size", p.getSize());
        body.put("totalPages", p.getTotalPages());
        body.put("totalElements", p.getTotalElements());
        return body;
    }


    @PostMapping("/search")
    public Map<String, Object> search(@RequestBody Map<String, String> body,
                                      @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {

        String csv = body.getOrDefault("ingredients", "");
        List<String> terms = Arrays.stream(csv.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();

        Page<Recipe> p = terms.isEmpty()
                ? recipeService.paged(PageRequest.of(page, size))
                : recipeService.searchByAnyIngredientPaged(terms, PageRequest.of(page, size));

        List<RecipeDto> content = p.getContent().stream().map(RecipeDto::from).toList();

        Map<String, Object> bodyResp = new HashMap<>();
        bodyResp.put("content", content);
        bodyResp.put("page", p.getNumber());
        bodyResp.put("size", p.getSize());
        bodyResp.put("totalPages", p.getTotalPages());
        bodyResp.put("totalElements", p.getTotalElements());
        return bodyResp;
    }
}
