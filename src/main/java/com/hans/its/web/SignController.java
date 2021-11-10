package com.hans.its.web;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"3. Sign"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class SignController {
}
