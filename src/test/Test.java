package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.tinzel.o2o.entity.IdCard;
import edu.tinzel.o2o.entity.Person;
import edu.tinzel.o2o.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		// save1();
		// query();
		//save();
		del();
	}

	// Person表单个注册
	public static void save1() {
		// 获取session对象
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		// 创建对象
		Person p1 = new Person();
		p1.setPersonName("tinzel");
		// 保存
		session.save(p1);

		tr.commit();
		session.close();
	}

	/**
	 * 级联注册
	 */
	public static void save() {
		// 获取session对象
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();

		// 创建一个公民
		Person p1 = new Person();
		p1.setPersonName("t1");
		// 创建一个身份证
		IdCard ic1 = new IdCard();
		ic1.setCardId(1);
		ic1.setCardNo("111111111");

		// 建立类和类之间的关系
		p1.setIdCard(ic1);
		ic1.setPerson(p1);

		// 保存
		session.save(p1); // cascade="save-update"
		// session.save(ic1);

		tr.commit();
		session.close();
		System.out.println("success");
	}

	public static void del() {
		// 获取session对象
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();

		// 保存
		session.delete(new Person(1));

		tr.commit();
		session.close();
	}

	/**
	 * 查询全部
	 */
	public static void query() {
		Session session = HibernateUtil.getSession();
		Person person = null;
		IdCard idCard = null;
		Query q = session.createQuery("from Person");
		List l = q.list();
		for (int i = 0; i < l.size(); i++) {
			person = (Person) l.get(i);
			System.out.println("编号： " + person.getPersonId());
			System.out.println("姓名： " + person.getPersonName());
			idCard = person.getIdCard();
			System.out.println("卡:  " + idCard.getCardNo() + "    "
					+ idCard.getCardId());
		}
		session.close();
	}
}
