package com.example.assignment1ads1.Controller;


import com.example.assignment1ads1.Model.Interface.Token;
import com.example.assignment1ads1.Persistance.Interface.IEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/")
public class RPNController {

    IEvaluateService evaluateService;

    @Autowired
    public RPNController(IEvaluateService evaluateService) {
        this.evaluateService = evaluateService;
    }

    @PostMapping()
    public ResponseEntity<Integer> evaluateExpression(@RequestBody() ArrayList<Token> tokenList) {

        Integer result = evaluateService.evaluateExpression(tokenList);

        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

