package example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import example.vo.BookVO;

public class BookDAO {

	private SqlSessionFactory factory;

	public BookDAO(SqlSessionFactory factory) {
		this.factory = factory;
	}

	public HashMap<String, Object> selectByISBNHashMap(String id , String password) {

		HashMap<String, Object> map = null;

		SqlSession session = factory.openSession();

		map = session.selectOne("example.myBook.selectBookByISBNHashMap", id);
		map = session.selectOne("example.myBook.selectBookByISBNHashMap", password);
		
		return map;
	}

	public List<HashMap<String, Object>> selectAllHashMap() {
		
		List<HashMap<String, Object>> list = null;
		
		SqlSession session = factory.openSession();
		
		list = session.selectList("example.myBook.selectAllHashmap");
		
		return list;
	}

	public BookVO selectByISBNBookVO(String isbn) {
		
		BookVO book = null;
		
		SqlSession session = factory.openSession();
		
		book = session.selectOne("example.myBook.selectBookByISBNBookVO",isbn);
		
		return book;
	}

	public BookVO selectByISBNResultMap(String isbn) {
		
		BookVO book = null;
		
		SqlSession session = factory.openSession();
		
		try {
			book = session.selectOne("example.myBook.selectBookByISBNResultMap",isbn);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		
		
		
		return book;
	}

	public int updateByISBN(BookVO book) {
		
		int result = 0;
		
		SqlSession session = factory.openSession();
		
		try {
			result = session.update("example.myBook.update",book);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {  // 모든 구문에서는 try catch와 finally를 반드시 사용해줘야된다.
			session.commit();
			session.close();
		}
		
		
		
		
		
		return result;
	}

}
