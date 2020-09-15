package text;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lovo.hibernate.db.HibernateSession;
import com.lovo.hibernate.entity.Powe;
import com.lovo.hibernate.entity.Role;
import com.lovo.hibernate.entity.RolePowe;
import com.lovo.hibernate.entity.UserEntity;
import com.lovo.hibernate.entity.UserRole;

public class Text {
	Session session = null;
	Transaction tr = null;

	@Before
	public void before() {
		session = HibernateSession.getSession();
		tr = session.getTransaction();
		tr.begin();
	}

	@Test
	public void textSession() {
		System.out.println(session);
	}

	@Test
	public void sava() {
		UserEntity user = new UserEntity();
		user.setUserName("赵子龙");
		session.save(user);

		Role role = new Role();
		role.setRoleName("老师");
		session.save(role);

		Powe powe = new Powe();
		powe.setPoweName("上课");
		session.save(powe);

		UserRole userRole = new UserRole();
		userRole.setUserEntity(user);
		userRole.setRole(role);
		UserRole userRole1 = new UserRole();
		userRole1.setUserEntity(user);
		userRole1.setRole(role);

		session.save(userRole);
		session.save(userRole1);

		RolePowe rolePowe = new RolePowe();
		rolePowe.setRole(role);
		rolePowe.setPowe(powe);
		RolePowe rolePowe1 = new RolePowe();
		rolePowe1.setRole(role);
		rolePowe.setPowe(powe);

		session.save(rolePowe);
		session.save(rolePowe1);
	}

	@Test
	public void find() {
		UserEntity userEntity = session.get(UserEntity.class, "402880e467c68fcc0167c68fcf910000");
		for (UserRole userRole : userEntity.getUserRole()) {
			for (RolePowe rolePowe : userRole.getRole().getRolePowe()) {
				System.out.println("用户：" + userEntity.getUserName() + "拥有的权限为" + rolePowe.getPowe().getPoweName());
			}

		}
	}
	
	@Test
	public void cha() {
		String hql = "select  from ";
	}

	@After
	public void after() {
		tr.commit();
		session.close();
	}
}
