package bbs;

import java.util.List;

public interface GuestbookMapper {
	Guestbook selectById(int id);

	List<Guestbook> selectAll();

	void insert(Guestbook guestbook);

	void deleteById(int id);

	List<Guestbook> selectPage(int currentPage, int pageSize);

	int selectCount();
}
