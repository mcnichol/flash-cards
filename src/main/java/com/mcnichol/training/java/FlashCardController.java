package com.mcnichol.training.java;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlashCardController {

    private FlashCardService flashCardService;

    FlashCardController(FlashCardService flashCardService){
        this.flashCardService = flashCardService;
    }

    @RequestMapping("/question/next")
    public ResponseEntity<Question> doStuff(){

        return new ResponseEntity<>(flashCardService.nextQuestion(), HttpStatus.OK);
    }
}
