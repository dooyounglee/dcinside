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
		return sqlSession.insert("boardMapper.writeBoard",b);
	}

	public void makeGallary(Board b) {
		sqlSession.insert("boardMapper.makeGallary",b);
	}
	
	public int existGallary(Board b) {
		return sqlSession.selectOne("boardMapper.existGallary",b);
	}

	public int insertGalList(Board b) {
		return sqlSession.insert("boardMapper.insertGalList",b);
	}

	public void deleteGallary(Board b) {
		sqlSession.insert("boardMapper.deleteGallary",b);
	}
	
	
}
