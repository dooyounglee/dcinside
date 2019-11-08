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

	public List<Gallary> getGallaryList() {
		return sqlSession.selectList("boardMapper.getGallaryList");
	}

	public void makeSequence(Board b) {
		sqlSession.insert("boardMapper.makeSequence",b);
	}

	public void dropSequence(Board b) {
		sqlSession.insert("boardMapper.dropSequence",b);
	}

	public int deleteGallaryList(Board b) {
		return sqlSession.delete("boardMapper.deleteGallaryList",b);
	}

	public Board getBoard(Board b) {
		return sqlSession.selectOne("boardMapper.getBoard",b);
	}

	public int editBoard(Board b) {
		return sqlSession.update("boardMapper.editBoard",b);
	}

	public int writeReply(Reply r) {
		return sqlSession.update("boardMapper.writeReply",r);
	}

	public void makeGallaryReply(Board b) {
		sqlSession.insert("boardMapper.makeGallaryReply",b);
	}

	public void makeSequenceReply(Board b) {
		sqlSession.insert("boardMapper.makeSequenceReply",b);
	}
	
	public void dropGallaryReply(Board b) {
		sqlSession.insert("boardMapper.dropGallaryReply",b);
	}
	
	public void dropSequenceReply(Board b) {
		sqlSession.insert("boardMapper.dropSequenceReply",b);
	}

	public List<Reply> getReplyList(Board b) {
		return sqlSession.selectList("boardMapper.getReplyList",b);
	}

	public Reply getReply(Reply r) {
		return sqlSession.selectOne("boardMapper.getReply",r);
	}

	public Reply getLastestReply(Reply r) {
		return sqlSession.selectOne("boardMapper.getLastestReply",r);
	}

	public int deleteReply(Reply r) {
		return sqlSession.delete("boardMapper.deleteReply",r);
	}

	
	
}
