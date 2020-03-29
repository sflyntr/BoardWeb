package com.springbook.biz.board.service;

import com.springbook.biz.board.command.BoardVO;
import com.springbook.biz.board.dao.BoardDAO;
import com.springbook.biz.board.dao.BoardDAOSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
//    private BoardDAO boardDAO;
    private BoardDAOSpring boardDAO;

    @Override
    public void insertBoard(BoardVO board) {
        boardDAO.insertBoard(board);
    }

    @Override
    public void updateBoard(BoardVO board) {
        boardDAO.updateBoard(board);
    }

    @Override
    public void deleteBoard(int seq) {
        boardDAO.deleteBoard(seq);
    }

    @Override
    public BoardVO getBoard(int seq) {
        return boardDAO.getBoard(seq);
    }

    @Override
    public List<BoardVO> getBoardList() {
        return boardDAO.getBoardList();
    }
}
