package com.springbook.biz.board.service;

import com.springbook.biz.board.command.BoardVO;

import java.util.List;

public interface BoardService {
    void insertBoard(BoardVO board);
    void updateBoard(BoardVO board);
    void deleteBoard(int seq);
    BoardVO getBoard(int seq);
    List<BoardVO> getBoardList();
}
