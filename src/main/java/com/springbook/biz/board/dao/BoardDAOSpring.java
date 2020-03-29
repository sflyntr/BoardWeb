package com.springbook.biz.board.dao;

import com.springbook.biz.board.command.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDAOSpring extends JdbcDaoSupport {
    // SQL
    private final String BOARD_INSERT = "insert into board(seq, title, writer, content) " +
            "values((select nvl(max(seq),0)+1 from board), ?, ?, ?)";
    private final String BOARD_UPDATE = "update board set title = ?, content = ? where seq = ?";
    private final String BOARD_DELETE = "delete from board where seq = ?";
    private final String BOARD_GET = "select * from board where seq=?";
    private final String BOARD_LIST = "select * from board";

    @Autowired
    public void setSuperDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    public void insertBoard(BoardVO vo) {
        System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
        getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
    }

    public void updateBoard(BoardVO vo) {
        System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
        getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
    }

    public void deleteBoard(int seq) {
        System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
        getJdbcTemplate().update(BOARD_DELETE, seq);
    }

    public BoardVO getBoard(int seq) {
        System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
        Object[] args = {seq};
        return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
    }

    public List<BoardVO> getBoardList() {
        System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");
        return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
    }

    class BoardRowMapper implements RowMapper<BoardVO> {
        @Override
        public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            BoardVO board = new BoardVO();
            board.setSeq(rs.getInt("SEQ"));
            board.setTitle(rs.getString("TITLE"));
            board.setWriter(rs.getString("WRITER"));
            board.setContent(rs.getString("CONTENT"));
            board.setRegDate(rs.getDate("REGDATE"));
            board.setCnt(rs.getInt("CNT"));
            return board;
        }
    }

}
