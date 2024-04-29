package org.example.infra.orm.repository;

import org.example.infra.orm.entity.BookEntity;

import java.util.List;

public class BookEntityRepository extends Repository<BookEntity>  {
    @Override
    public BookEntity findById(int id) {
        return session.get(BookEntity.class, id);
    }

    public List<BookEntity> findAllByKey(String key) {
        return (session
                .createQuery("from BookEntity where title like :q", BookEntity.class)
                .setParameter("q", key+"%"))
                .list();
    }

    @Override
    List<BookEntity> findAll() {
        return null;
    }
}
