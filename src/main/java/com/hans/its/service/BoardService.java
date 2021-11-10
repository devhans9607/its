package com.hans.its.service;

import com.hans.its.repository.CommentRepository;
import com.hans.its.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    //
}
