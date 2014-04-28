package bbs;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GuestbookHome1 {

	private static SqlSession getSession() throws Exception {
		Reader reader = Resources.getResourceAsReader("MyBatisConfig.xml");
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
				.build(reader);
		return sqlMapper.openSession();
	}

	public static List<Guestbook> selectAll() throws Exception {
		SqlSession session = getSession();
		List<Guestbook> list = session
				.selectList("bbs.GuestbookMapper.selectAll");
		session.close();
		return list;
	}

	public static void insert(Guestbook guestbook) throws Exception {
		SqlSession session = getSession();
		session.insert("bbs.GuestbookMapper.insert", guestbook);
		session.commit();
		session.close();
	}

	public static void delete(int id) throws Exception {
		SqlSession session = getSession();
		session.insert("bbs.GuestbookMapper.delete", id);
		session.commit();
		session.close();
	}
}
