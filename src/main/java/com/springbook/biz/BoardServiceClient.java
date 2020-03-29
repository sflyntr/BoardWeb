package com.springbook.biz;

import com.springbook.biz.board.command.BoardVO;
import com.springbook.biz.board.service.BoardService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {
    public static void main(String[] args) {
        AbstractApplicationContext container =
                new GenericXmlApplicationContext("applicationContext.xml");

        BoardService boardService = (BoardService) container.getBean("boardService");

        BoardVO vo = new BoardVO();
        vo.setTitle("Test");
        vo.setWriter("intellij");
        vo.setContent("임시내용....");
        boardService.insertBoard(vo);

        List<BoardVO> boardList = boardService.getBoardList();
        for (BoardVO board: boardList) {
            System.out.println("---> " + board.toString());
        }

        container.close();
    }
}
