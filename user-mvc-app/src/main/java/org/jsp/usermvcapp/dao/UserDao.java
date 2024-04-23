package org.jsp.usermvcapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import org.jsp.usermvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private EntityManager entityManager;

	public User saveUser(User user) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityManager.persist(user);
		entityTransaction.begin();
		entityTransaction.commit();
		return user;
	}

	public User findById(int id) {
		return entityManager.find(User.class, id);
	}

	public User updateUser(User user) {
		User dbUser = findById(user.getId());
		if (dbUser != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			dbUser.setName(user.getName());
			dbUser.setEmail(user.getEmail());
			dbUser.setPassword(user.getPassword());
			dbUser.setPhone(user.getPhone());
			entityTransaction.begin();
			entityTransaction.commit();
			return dbUser;
		}
		return null;
	}

	public User verify(long phone, String password) {
		try {
			return (User) entityManager.createQuery("select u from User u where u.phone=?1 and u.password=?2")
					.setParameter(1, phone).setParameter(2, password).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User verify(String email, String password) {
		try {
			return (User) entityManager.createQuery("select u from User u where u.email=?1 and u.password=?2")
					.setParameter(1, email).setParameter(2, password).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User verify(int id, String password) {
		try {
			return (User) entityManager.createQuery("select u from User u where u.id=?1 and u.password=?2")
					.setParameter(1, id).setParameter(2, password).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public boolean deleteUser(int id) {
		User user = findById(id);
		if (user != null) {
			entityManager.remove(user);
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityTransaction.commit();
			return true;
		}
		return false;
	}
}
