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

	// Person����ע��
	public static void save1() {
		// ��ȡsession����
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();
		// ��������
		Person p1 = new Person();
		p1.setPersonName("tinzel");
		// ����
		session.save(p1);

		tr.commit();
		session.close();
	}

	/**
	 * ����ע��
	 */
	public static void save() {
		// ��ȡsession����
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();

		// ����һ������
		Person p1 = new Person();
		p1.setPersonName("t1");
		// ����һ�����֤
		IdCard ic1 = new IdCard();
		ic1.setCardId(1);
		ic1.setCardNo("111111111");

		// ���������֮��Ĺ�ϵ
		p1.setIdCard(ic1);
		ic1.setPerson(p1);

		// ����
		session.save(p1); // cascade="save-update"
		// session.save(ic1);

		tr.commit();
		session.close();
		System.out.println("success");
	}

	public static void del() {
		// ��ȡsession����
		Session session = HibernateUtil.getSession();
		Transaction tr = session.beginTransaction();

		// ����
		session.delete(new Person(1));

		tr.commit();
		session.close();
	}

	/**
	 * ��ѯȫ��
	 */
	public static void query() {
		Session session = HibernateUtil.getSession();
		Person person = null;
		IdCard idCard = null;
		Query q = session.createQuery("from Person");
		List l = q.list();
		for (int i = 0; i < l.size(); i++) {
			person = (Person) l.get(i);
			System.out.println("��ţ� " + person.getPersonId());
			System.out.println("������ " + person.getPersonName());
			idCard = person.getIdCard();
			System.out.println("��:  " + idCard.getCardNo() + "    "
					+ idCard.getCardId());
		}
		session.close();
	}
}
