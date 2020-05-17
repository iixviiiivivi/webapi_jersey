package webapi.jersey.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import webapi.jersey.model.Member;

public class MemberDao implements IDao<Member>{
	
	@Override
	public List<Member> findAll() {
		String sql = "select * from member";
		Session session = IDao.getSession();
		NativeQuery<Member> query = session.createNativeQuery(sql, Member.class);
		List<Member> members = query.list();
		return members;
	}

	@Override
	public Member findOne(Integer id) {
		Session session = IDao.getSession();
		Member member = session.get(Member.class, id);
		return member;
	}

	@Override
	public Member save(Member obj) {
		Session session = IDao.getSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		return obj;
	}

	@Override
	public Member update(Integer id, Member obj) {
		Session session = IDao.getSession();
		if(session.get(Member.class, id) != null) {
			session.clear();
			obj.setId(id);
			session.beginTransaction();
			session.update(obj);
			session.getTransaction().commit();
			return obj;
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(Integer id) {
		Session session = IDao.getSession();
		Member member = session.get(Member.class, id);
		if(member != null) {
			session.beginTransaction();
			session.delete(member);
			session.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}
		
}
