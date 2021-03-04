package com.mvcproject.board.controller.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvcproject.board.controller.model.vo.Board;
import com.mvcproject.board.controller.model.vo.BoardPage;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession sqlSession;

	public int listCount() { // 전체 글 수 조회
		return sqlSession.selectOne("Board.listCount");
	}

 
	public Board selectOne(String board_num) { // 글 가져오기
		return sqlSession.selectOne("Board.selectOne", board_num);
	}

 
	public List<Board> searchList(String keyword) { // 게시글 검색 조회
		return sqlSession.selectList("Board.searchList", keyword);
	}

	public List<Board> selectList(int startPage, int limit) { // 특정 페이지 단위의 게시글 조회
		int startRow = (startPage - 1) * limit;
		//RowBounds row = new RowBounds(startRow, limit);
		BoardPage boardPage = new BoardPage();
		boardPage.setStart(startRow+1);
		boardPage.setEnd(startRow+10);
		return sqlSession.selectList("Board.selectList", boardPage);
	}
}
