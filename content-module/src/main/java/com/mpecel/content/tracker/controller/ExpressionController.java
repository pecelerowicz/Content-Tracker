package com.mpecel.content.tracker.controller;

import com.mpecel.content.tracker.dto.expression.*;
import com.mpecel.content.tracker.service.ExpressionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.el.MethodNotFoundException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/expression")
public class ExpressionController {
    private final ExpressionService expressionService;
    @GetMapping
    public ExpressionsResponse getExpressions(@RequestBody ExpressionsRequest expressionsRequest) {
        throw new MethodNotFoundException();
    }
    @GetMapping("/label")
    public ExpressionResponse getExpression(@RequestBody ExpressionRequest expressionRequest) {
        throw new MethodNotFoundException();
    }
    @PostMapping
    public AddExpressionResponse addExpression(@RequestBody AddExpressionRequest addExpressionRequest) {
        throw new MethodNotFoundException();
    }
    @PostMapping("/interaction")
    public InteractionResponse addInteraction(@RequestBody InteractionRequest interactionRequest) {
        throw new MethodNotFoundException();
    }
}
