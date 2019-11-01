package com.kh.dc.gallary;

import java.util.List;

public interface GallaryService {

	List<Board> getBoardList(Board b);

	int writeBoard(Board b);

	
}
