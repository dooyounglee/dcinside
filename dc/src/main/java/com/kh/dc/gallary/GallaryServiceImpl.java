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
			bDao.makeGallary(b);//create table
			result=bDao.existGallary(b);
			if(result>0) {
				result=bDao.insertGalList(b);//gallist에 insert
			}else {
				bDao.deleteGallary(b);
			}
			return result;
		}
	}

}
