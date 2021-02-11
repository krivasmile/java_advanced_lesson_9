package ua.kyiv.app.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.kyiv.app.dao.BucketDao;
import ua.kyiv.app.dao.impl.BucketDaoImpl;
import ua.kyiv.app.dao.impl.ProductDaoImpl;
import ua.kyiv.app.domain.Bucket;
import ua.kyiv.app.service.BucketService;

public class BucketServiceImpl implements BucketService {
	private static Logger LOG = Logger.getLogger(BucketServiceImpl.class);
	private BucketDao bucketDao;
	private static BucketServiceImpl bucketServiceImpl;

	private BucketServiceImpl(){
		try {
			bucketDao = new BucketDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOG.error(e);
		}
	}
	
	public static BucketServiceImpl getBucketServiceImpl() {
		if (bucketServiceImpl == null) {
			bucketServiceImpl = new BucketServiceImpl();
		}
		return bucketServiceImpl;
	}

	@Override
	public Bucket create(Bucket t) {
		return bucketDao.create(t);
	}

	@Override
	public Bucket read(int id) {
		return bucketDao.read(id);
	}

	@Override
	public Bucket update(Bucket t){
		return bucketDao.update(t);
	}

	@Override
	public void delete(int id) {
		bucketDao.delete(id);
	}

	@Override
	public List<Bucket> readAll() {
		return bucketDao.readAll();
	}

}
