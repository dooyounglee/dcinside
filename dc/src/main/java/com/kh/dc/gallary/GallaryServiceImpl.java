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

}
