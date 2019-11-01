package com.kh.dc.gallary;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("bDao")
public class GallaryDao {

	@Autowired
	private SqlSession sqlSession;

	public List<Board> selectList(Board b) {
		return sqlSession.selectList("boardMapper.selectBoardList",b);
	}

	public int writeBoard(Board b) {
		// TODO Auto-generated method stub
		return sqlSession.insert("boardMapper.writeBoard",b);
	}
	
	
}
