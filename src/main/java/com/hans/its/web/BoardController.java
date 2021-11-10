package com.hans.its.web;

import com.hans.its.service.BoardService;
//import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Api(tags = {"1. Board"})
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class BoardController {
    private final BoardService boardService;

    //

}
