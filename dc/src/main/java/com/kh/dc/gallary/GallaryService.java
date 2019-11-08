package com.kh.dc.gallary;

import java.util.List;

public interface GallaryService {

	List<Board> getBoardList(Board b);

	int writeBoard(Board b);

	int makeGallary(Board b);

	List<Gallary> getGallaryList();

	int dropGallary(Board b);

	Board getBoard(Board b);

	int editBoard(Board b);

	int writeReply(Reply r);

	List<Reply> getReplyList(Board b);

	Reply getReply(Reply r);

	Reply getLastestReply(Reply r);

	int deleteReply(Reply r);

	
}
