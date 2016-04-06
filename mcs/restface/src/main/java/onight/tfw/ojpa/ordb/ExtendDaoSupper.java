package onight.tfw.ojpa.ordb;

import java.util.List;

import onight.tfw.ojpa.api.exception.NotSuportException;

import org.apache.ibatis.session.SqlSessionFactory;

public abstract class ExtendDaoSupper<T, D, K> implements StaticTableDaoSupport<T, D, K> {

	@Override
	public int countByExample(D example) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public int deleteByExample(D example) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public int deleteByPrimaryKey(K key) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public int insert(T record) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public int insertSelective(T record) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public int batchInsert(List<T> records) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public int batchUpdate(List<T> records) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public int batchDelete(List<T> records) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public List<T> selectByExample(D example) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public T selectOneByExample(D example) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public T selectByPrimaryKey(K key) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public List<T> findAll(List<T> records) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public int updateByExampleSelective(T record, D example) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public int updateByExample(T record, D example) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public int updateByPrimaryKey(T record) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public int sumByExample(D example) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public void deleteAll() {
		throw new NotSuportException("DaoNotSupport");

	}

	@Override
	public D getExample(T record) {
		throw new NotSuportException("DaoNotSupport");
	}

	@Override
	public SqlSessionFactory getSqlSessionFactory() {
		throw new NotSuportException("DaoNotSupport");
	}

}
