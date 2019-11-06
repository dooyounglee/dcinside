package com.kh.dc.gallary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bService")
public class GallaryServiceImpl implements GallaryService {

	@Autowired
	private GallaryDao bDao;

	@Override
	public List<Board> getBoardList(Board b) {
		return bDao.selectList(b);
	}

	@Override
	public int writeBoard(Board b) {
		return bDao.writeBoard(b);
	}

	@Override
	public int makeGallary(Board b) {
		
		b.setGal_name(b.getGal_name().toUpperCase());
		
		//이미 있는지 확인
		int result=bDao.existGallary(b);
		if(result>0) {//있으면
			return 0;
		}else {//없었으면 만들자
			bDao.makeGallary(b);//create table gal-
			bDao.makeSequence(b);//create sequence
			bDao.makeGallaryReply(b);//create table regal-
			bDao.makeSequenceReply(b);//create sequence regal-
			result=bDao.existGallary(b);
			if(result>0) {
				result=bDao.insertGalList(b);//gallist에 insert
			}else {
				bDao.deleteGallary(b);
			}
			return result;
		}
	}

	@Override
	public List<Gallary> getGallaryList() {
		return bDao.getGallaryList();
	}

	@Override
	public int dropGallary(Board b) {
		
		b.setGal_name(b.getGal_name().toUpperCase());

		bDao.deleteGallary(b);//drop table
		bDao.dropSequence(b);//drop sequence gal-
		bDao.dropGallaryReply(b);//drop reply
		bDao.dropSequenceReply(b);//drop sequece regal-
		int result=bDao.existGallary(b);
		System.out.println("몇개?"+result);
		if(result<1) {
			result=bDao.deleteGallaryList(b);
			System.out.println("지웠찌?"+result);
		}
		return result;
	}

	@Override
	public Board getBoard(Board b) {
		return bDao.getBoard(b);
	}

	@Override
	public int editBoard(Board b) {
		return bDao.editBoard(b);
	}

	@Override
	public int writeReply(Reply r) {
		return bDao.writeReply(r);
	}

	@Override
	public List<Reply> getReplyList(Board b) {
		System.out.println("service");
		System.out.println(b);
		System.out.println(bDao.getReplyList(b));
		return bDao.getReplyList(b);
	}

}
